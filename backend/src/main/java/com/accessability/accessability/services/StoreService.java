package com.accessability.accessability.services;

import com.accessability.accessability.dto.StoreCreateRequest;
import com.accessability.accessability.models.Category;
import com.accessability.accessability.models.Characteristic;
import com.accessability.accessability.models.Store;
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
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
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
        if (iStoreRepository.existsById(id))
        {
            iStoreRepository.deleteById(id);
            return ("Deleted store with ID: " + id);
        }
        else
            return ("Not deleted, store with ID: " + id + "does not exist");
    }

    public String updateStoreById(long id, StoreCreateRequest request, MultipartFile image) {
        Store updateStore = iStoreRepository.findById(id).orElse(null);
        try
        {
            if (updateStore != null)
            {
                mapRequest(updateStore, request, image);
                deleteUnusedImages();
                iStoreRepository.save(updateStore);
                return ("Store updated: " + updateStore.getId());
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

    public ArrayList<String> getAllCities()
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

    public String imageProcessing(MultipartFile image)
    {
        String  originalFileName;
        String  extension;
        String  fileNameWithoutExtension;
        String  timestamp;
        String  fileName;

        if ((image != null) && (!image.isEmpty()))
        {
            try
            {
                originalFileName = image.getOriginalFilename();
                extension = originalFileName.substring(originalFileName.lastIndexOf('.'));
                fileNameWithoutExtension = originalFileName.substring(0, originalFileName.lastIndexOf('.'));
                timestamp = Instant.now().toString().substring(0, Instant.now().toString().lastIndexOf('.'));
                fileName = fileNameWithoutExtension + timestamp + extension;
                Files.copy(image.getInputStream(), Path.of(storePath, fileName), StandardCopyOption.REPLACE_EXISTING);
            }
            catch (Exception error)
            {
                throw new RuntimeException("Error image could not be saved: " + error.getMessage());
            }
        }
        else
            fileName = "";
        return (fileName);
    }

    public void deleteUnusedImages() throws IOException
    {
        ArrayList<Store>    storeList;
        ArrayList<String>   imageList;
        File                directory;
        File[]              files;

        storeList = (ArrayList<Store>) iStoreRepository.findAll();
        imageList = (ArrayList<String>) storeList.stream()
                .map(Store::getImage)
                .distinct()
                .collect(Collectors.toList());
        directory = new File(storePath);
        files = directory.listFiles();
        for (File file : files)
        {
            if ((!imageList.contains(file.getName())) && (!file.getName().equals("default.png")))
                Files.delete(Path.of(storePath, file.getName()));
        }
    }
}
