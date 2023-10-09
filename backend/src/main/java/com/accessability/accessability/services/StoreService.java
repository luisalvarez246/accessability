package com.accessability.accessability.services;

import com.accessability.accessability.dto.StoreCreateRequest;
import com.accessability.accessability.models.Characteristic;
import com.accessability.accessability.models.Store;
import com.accessability.accessability.models.Type;
import com.accessability.accessability.repositories.ICharacteristicRepository;
import com.accessability.accessability.repositories.IStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.Normalizer;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreService {

    @Autowired
    IStoreRepository iStoreRepository;

    @Autowired
    ICharacteristicRepository iCharacteristicRepository;
    private final String storePath = System.getProperty("user.dir") + "/src/main/webapp/images";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH_mm_ss");

    public String saveStore(StoreCreateRequest request, MultipartFile image)
    {
        Store store = new Store();

        try
        {
            mapRequest(store, request, image);
            iStoreRepository.save(store);
            return "Added new Store";
        }
        catch(Exception error)
        {
            return (error.getMessage() + request.toString());
        }
    }

    public Store getStoreById(long id) {
        return (Store) iStoreRepository.findById(id).orElse(null);
    }

    public ArrayList<Store> getAllStores() {
        return (ArrayList<Store>) iStoreRepository.findAll();
    }

    public String deleteStoreById(long id)
    {
        StringBuilder   deletedImages;
        if (iStoreRepository.existsById(id))
        {
            try
            {
                iStoreRepository.deleteById(id);
                deletedImages = deleteUnusedImages();
                return ("Deleted store with ID: " + id + ", Deleted images: " + deletedImages);
            }
            catch (Exception error)
            {
                throw new RuntimeException("Store not deleted: " + error.getMessage());
            }
        }
        else
            return ("Not deleted, store with ID: " + id + "does not exist");
    }

    public String updateStoreById(long id, StoreCreateRequest request, MultipartFile image)
    {
        Store           updateStore = iStoreRepository.findById(id).orElse(null);
        StringBuilder   deletedImages;
        try
        {
            if (updateStore != null)
            {
                mapRequest(updateStore, request, image);
                iStoreRepository.save(updateStore);
                deletedImages = deleteUnusedImages();
                return ("Store updated: " + updateStore.getId() + ", Deleted images: " + deletedImages);
            }
            else
            {
                return ("Store not updated: Record with ID :" + id + "does not exist");
            }
        }
        catch(Exception error)
        {
            throw new RuntimeException("Store not updated: " + error.getMessage());
        }
    }

    public String crossUpdate(Store store)
    {
        iStoreRepository.save(store);
        return (" id_" + store.getId());
    }

    public void mapRequest(Store store, StoreCreateRequest request, MultipartFile image)
    {
        List<Characteristic>    selectedCharacteristics;

        store.setStoreName(request.getStoreName());
        store.setType(request.getType());
        store.setCity(request.getCity());
        store.setAddress(request.getAddress());
        store.setPhone(request.getPhone());
        store.setWeb(request.getWeb());
        store.setEmail(request.getEmail());
        store.setDescription(request.getDescription());
        store.setImage(imageProcessing(image));
        selectedCharacteristics = iCharacteristicRepository.findAllById(request.getCharacteristicIds());
        store.setCharacteristic(new HashSet<>(selectedCharacteristics));
        store.setCategories(categoryLoad(selectedCharacteristics));
    }

    public String categoryLoad(List<Characteristic> selectedCharacteristics)
    {
        String  categories;

        categories = selectedCharacteristics.stream()
                        .map(characteristic -> characteristic.getCategory().name())
                        .distinct()
                        .collect(Collectors.joining(","));
        return (categories);
    }

    public ArrayList<Store> findByCharacteristicId(Long characteristicId)
    {
        return (iStoreRepository.findByCharacteristicId(characteristicId));
    }

    public ArrayList<String> getCitiesInStore()
    {
        ArrayList<Store>    stores;
        ArrayList<String>   cities;

        stores = (ArrayList<Store>) iStoreRepository.findAll();
        cities = (ArrayList<String>) stores.stream()
                    .map(Store::getCity)
                    .distinct()
                    .collect(Collectors.toList());
        return (cities);
    }

    public ArrayList<Type> getTypesInStore()
    {
        ArrayList<Store>    stores;
        ArrayList<Type>   types;

        stores = (ArrayList<Store>) iStoreRepository.findAll();
        types = (ArrayList<Type>) stores.stream()
                    .map(Store::getType)
                    .distinct()
                    .collect(Collectors.toList());
        return (types);
    }

    public String imageProcessing(MultipartFile image)
    {
        String  originalFileName;
        String  extension;
        String  fileNameWithoutExtension;
        String  fileName;

        if ((image != null) && (!image.isEmpty()))
        {
            try
            {
                originalFileName = image.getOriginalFilename();
                extension = originalFileName.substring(originalFileName.lastIndexOf('.'));
                fileNameWithoutExtension = originalFileName.substring(0, originalFileName.lastIndexOf('.'));
                fileName = fileNameWithoutExtension + formatImageName() + extension;
                Files.copy(image.getInputStream(), Path.of(storePath, fileName), StandardCopyOption.REPLACE_EXISTING);
            }
            catch (Exception error)
            {
                throw new RuntimeException("Error image could not be saved: " + error.getMessage());
            }
        }
        else
            fileName = "default.png";
        return (fileName);
    }

    public StringBuilder deleteUnusedImages() throws IOException
    {
        ArrayList<Store>    storeList;
        ArrayList<String>   imageList;
        File                directory;
        File[]              files;
        String              normalizedFileNames;
        StringBuilder       deletedImages;

        storeList = (ArrayList<Store>) iStoreRepository.findAll();
        imageList = (ArrayList<String>) storeList.stream()
                .map(store -> Normalizer.normalize(store.getImage(), Normalizer.Form.NFD))
                .distinct()
                .collect(Collectors.toList());
        directory = new File(storePath);
        files = directory.listFiles();
        deletedImages = new StringBuilder();
        for (File file : files)
        {
            normalizedFileNames = Normalizer.normalize(file.getName(), Normalizer.Form.NFD);
            if ((!imageList.contains(normalizedFileNames)) && (!normalizedFileNames.equals("default.png")))
            {
                deletedImages.append(file.getName()).append(" ");
                Files.delete(Path.of(storePath, file.getName()));
            }
        }
        return (deletedImages);
    }

    public ArrayList<Store> searchStores(String city, Type type, String categories)
    {
        return (iStoreRepository.searchStores(city, type, categories));
    }

    public String formatImageName()
    {
        String timestamp;
        Instant instant = Instant.now();
        LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH_mm_ss");

        timestamp = formatter.format(localDateTime);
        return (timestamp);
    }
}
