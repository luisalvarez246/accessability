package com.accessability.accessability.services;

import com.accessability.accessability.dto.StoreCreateRequest;
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
            store.setStoreName(request.getStoreName());
            store.setType(request.getType());
            store.setCategory(request.getCategory());
            store.setAddress(request.getAddress());
            store.setPhone(request.getPhone());
            store.setWeb(request.getWeb());
            store.setEmail(request.getEmail());
            store.setImage(request.getImage());
            List<Characteristic> selectedCharacteristics = iCharacteristicRepository.findAllById(request.getCharacteristicIds());
            store.setCharacteristic(new HashSet<>(selectedCharacteristics));
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

    public String deleteStoreById(long id) {
        try{
            iStoreRepository.deleteById(id);
            return "Deleted " + id;
        }catch(Exception error) {
            return error.getMessage();
        }
    }

    public String updateStoreById(long id, StoreCreateRequest request) {
        Store updateStore = iStoreRepository.findById(id).orElse(null);
        try
        {
            if (updateStore != null)
            {
                updateStore.setStoreName(request.getStoreName());
                updateStore.setType(request.getType());
                updateStore.setCategory(request.getCategory());
                updateStore.setAddress(request.getAddress());
                updateStore.setPhone(request.getPhone());
                updateStore.setWeb(request.getWeb());
                updateStore.setEmail(request.getEmail());
                updateStore.setImage(request.getImage());
                List<Characteristic> selectedCharacteristics = iCharacteristicRepository.findAllById(request.getCharacteristicIds());
                updateStore.setCharacteristic(new HashSet<>(selectedCharacteristics));
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

}
