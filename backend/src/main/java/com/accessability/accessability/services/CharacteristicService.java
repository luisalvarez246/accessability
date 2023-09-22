package com.accessability.accessability.services;

import com.accessability.accessability.models.Characteristic;
import com.accessability.accessability.repositories.ICharacteristicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CharacteristicService {

    @Autowired
    ICharacteristicRepository iCharacteristicRepository;

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

    public String updateCharacteristicById(Characteristic updateCharacteristic) {
        try {
            if (iCharacteristicRepository.existsById(updateCharacteristic.getId())) {
                iCharacteristicRepository.save(updateCharacteristic);
                return ("Characteristic updated: " + updateCharacteristic.getId());
            } else {
                return ("Characteristic not updated: Record with ID :" + updateCharacteristic.getId() + "does not exist");
            }
        }catch(Exception error) {
            throw new RuntimeException("Characteristic not updated: " + error.getMessage());
        }
    }

}
