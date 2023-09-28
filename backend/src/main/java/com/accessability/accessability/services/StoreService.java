package com.accessability.accessability.services;

import com.accessability.accessability.dto.StoreCreateRequest;
import com.accessability.accessability.models.Category;
import com.accessability.accessability.models.Characteristic;
import com.accessability.accessability.models.Store;
import com.accessability.accessability.repositories.ICharacteristicRepository;
import com.accessability.accessability.repositories.IStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public String saveStore(StoreCreateRequest request)
    {
        Store store = new Store();

        try
        {
            mapRequest(store, request);
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

    public String updateStoreById(long id, StoreCreateRequest request) {
        Store updateStore = iStoreRepository.findById(id).orElse(null);
        try
        {
            if (updateStore != null)
            {
                mapRequest(updateStore, request);
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

    public void mapRequest(Store store, StoreCreateRequest request)
    {
        List<Characteristic>    selectedCharacteristics;

        store.setStoreName(request.getStoreName());
        store.setType(request.getType());
        store.setAddress(request.getAddress());
        store.setPhone(request.getPhone());
        store.setWeb(request.getWeb());
        store.setEmail(request.getEmail());
        store.setImage(request.getImage());
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
}
