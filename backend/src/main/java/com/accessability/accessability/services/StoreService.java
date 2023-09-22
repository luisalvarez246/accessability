package com.accessability.accessability.services;

import com.accessability.accessability.models.Store;
import com.accessability.accessability.repositories.IStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StoreService {

    @Autowired
    IStoreRepository iStoreRepository;

    public String saveStore(Store store) {
        try{
            iStoreRepository.save(store);
            return "Added new Store";
        }catch(Exception error) {
            return error.getMessage();
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

    public String updateStoreById(Store updateStore) {
        try {
            if (iStoreRepository.existsById(updateStore.getId())) {
                iStoreRepository.save(updateStore);
                return ("Store updated: " + updateStore.getId());
            } else {
                return ("Store not updated: Record with ID :" + updateStore.getId() + "does not exist");
            }
        }catch(Exception error) {
            throw new RuntimeException("Store not updated: " + error.getMessage());
        }
    }

}
