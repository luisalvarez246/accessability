package com.accessability.accessability.services;

import com.accessability.accessability.models.Characteristic;
import com.accessability.accessability.models.Store;
import com.accessability.accessability.repositories.ICharacteristicRepository;
import com.accessability.accessability.repositories.IStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacteristicService {

    @Autowired
    ICharacteristicRepository   iCharacteristicRepository;

    @Autowired
    StoreService                storeService;

    public String saveCharacteristic(Characteristic characteristic) {
        try{
            iCharacteristicRepository.save(characteristic);
            return "Added new characteristic";
        }catch(Exception error) {
            return error.getMessage();
        }
    }

    public Characteristic getCharacteristicById(long id) {
        return (Characteristic) iCharacteristicRepository.findById(id).orElse(null);
    }

    public ArrayList<Characteristic> getAllCharacteristics() {
        return (ArrayList<Characteristic>) iCharacteristicRepository.findAll();
    }

    public String deleteCharacteristicById(long id) {
        try{
            iCharacteristicRepository.deleteById(id);
            return "Deleted characteristic" + id;
        }catch(Exception error) {
            return error.getMessage();
        }
    }

    public String updateCharacteristicById(long id, Characteristic updateCharacteristic)
    {
        ArrayList<Store>        storeList;
        List<Long>              characteristicId;
        List<Characteristic>    characteristicList;
        StringBuilder           changedStores;

        updateCharacteristic.setId(id);
        changedStores = new StringBuilder();
        changedStores.append("updated Stores:");
        try
        {
            if (iCharacteristicRepository.existsById(updateCharacteristic.getId()))
            {
                iCharacteristicRepository.save(updateCharacteristic);
                storeList = storeService.findByCharacteristicId(updateCharacteristic.getId());
                for(Store store : storeList)
                {
                    characteristicId = store.getCharacteristic().stream()
                                        .map(characteristic -> characteristic.getId())
                                        .collect(Collectors.toList());
                    characteristicList = iCharacteristicRepository.findAllById(characteristicId);
                    store.setCategories(storeService.categoryLoad(characteristicList));
                    changedStores.append(storeService.crossUpdate(store));
                }
                return ("Characteristic updated: id_" + updateCharacteristic.getId() + " " + changedStores);
            }
            else
            {
                return ("Characteristic not updated: Record with ID :" + updateCharacteristic.getId() + "does not exist");
            }
        }
        catch(Exception error)
        {
            throw new RuntimeException("Characteristic not updated: " + error.getMessage());
        }
    }
}
