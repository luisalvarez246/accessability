package com.accessability.accessability.controllers;

import com.accessability.accessability.models.Store;
import com.accessability.accessability.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/stores")
public class StoreController {

    @Autowired
    StoreService storeService;

    @GetMapping
    public ArrayList<Store> getAllStores() {
        return storeService.getAllStores();
    }

    @GetMapping(path = "/{id}")
    public Store getStoreById(@PathVariable long id) {
        return storeService.getStoreById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteStoreById(@PathVariable long id) {
        return storeService.deleteStoreById(id);
    }

    @PostMapping
    public String saveStore(@RequestBody Store store) {
        return (storeService.saveStore(store));
    }

    @PutMapping(path = "/update/{id}")
    public String updateStoreById (@PathVariable long id, @RequestBody Store store) {
        store.setId(id);
        return (storeService.updateStoreById(store));
    }
}
