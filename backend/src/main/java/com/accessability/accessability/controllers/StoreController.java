package com.accessability.accessability.controllers;

import com.accessability.accessability.dto.StoreCreateRequest;
import com.accessability.accessability.models.Category;
import com.accessability.accessability.models.Store;
import com.accessability.accessability.models.Type;
import com.accessability.accessability.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public String saveStore(@ModelAttribute StoreCreateRequest request, @RequestParam("image") MultipartFile image) {
        return (storeService.saveStore(request, image));
    }

    @PutMapping(path = "/update/{id}")
    public String updateStoreById (@PathVariable long id, @ModelAttribute StoreCreateRequest request, @RequestParam("image") MultipartFile image)
    {
        return (storeService.updateStoreById(id, request, image));
    }

    @GetMapping(path = "/cities")
    public ResponseEntity<ArrayList<String>> getAllCities()
    {
       return (ResponseEntity.ok(storeService.getAllCities()));
    }

    @GetMapping(path = "/types")
    public ResponseEntity<ArrayList<Type>> getAllTypesInStore()
    {
       return (ResponseEntity.ok(storeService.getAllTypesInStore()));
    }

    @GetMapping(path = "/search")
    public ResponseEntity<ArrayList<Store>> searchStores (
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "type", required = false) Type type,
            @RequestParam(value = "categories", required = false) String categories
    )
    {
        return (ResponseEntity.ok(storeService.searchStores(city, type, categories)));
    }
}
