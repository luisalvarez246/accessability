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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class StoreService {

    @Autowired
    IStoreRepository iStoreRepository;

    @Autowired
    ICharacteristicRepository iCharacteristicRepository;

    @Autowired
    ImageService    imageService;

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
        StringBuilder   deletedImages;
        if (iStoreRepository.existsById(id))
        {
            try
            {
                iStoreRepository.deleteById(id);
                deletedImages = imageService.deleteUnusedImages();
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
                deletedImages = imageService.deleteUnusedImages();
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
        store.setImage(imageService.imageProcessing(image));
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

    public <T> List<T> getFieldValuesInStore(Function<Store, T> fieldMapper)
    {
        List<Store> stores;
        List<T>     field;

        stores = iStoreRepository.findAll();
        field = stores.stream()
                .map(fieldMapper)
                .distinct()
                .collect(Collectors.toList());
        return (field);
    }

    public List<String> getCitiesInStore()
    {
        return (getFieldValuesInStore(Store::getCity));
    }

    public List<Type> getTypesInStore()
    {
        return (getFieldValuesInStore(Store::getType));
    }

    public ArrayList<Store> searchStores(String city, Type type, String categories)
    {
        return (iStoreRepository.searchStores(city, type, categories));
    }
}
