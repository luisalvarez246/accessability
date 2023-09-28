package com.accessability.accessability.controllers;

import com.accessability.accessability.models.Characteristic;
import com.accessability.accessability.models.Store;
import com.accessability.accessability.services.CharacteristicService;
import com.accessability.accessability.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/characteristics")
public class CharacteristicController {

    @Autowired
    CharacteristicService characteristicService;

    @GetMapping
    public ArrayList<Characteristic> getAllCharacteristics() {
        return characteristicService.getAllCharacteristics();
    }

    @GetMapping(path = "/{id}")
    public Characteristic getCharacteristicById(@PathVariable long id) {
        return characteristicService.getCharacteristicById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteCharacteristicById(@PathVariable long id) {
        return characteristicService.deleteCharacteristicById(id);
    }

    @PostMapping
    public String saveCharacteristic(@RequestBody Characteristic characteristic) {
        return (characteristicService.saveCharacteristic(characteristic));
    }

    @PutMapping(path = "/update/{id}")
    public String updateCharacteristicById (@PathVariable long id, @RequestBody Characteristic characteristic) {
        characteristic.setId(id);
        return (characteristicService.updateCharacteristicById(characteristic));
    }


}
