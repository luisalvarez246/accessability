package com.accessability.accessability.controllers;

import com.accessability.accessability.dto.StoreCreateRequest;
import com.accessability.accessability.models.Store;
import com.accessability.accessability.models.Type;
import com.accessability.accessability.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/stores")
public class StoreController {

    @Autowired
    StoreService storeService;

    @GetMapping
    public List<Store> getAllStores() {
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
    public String saveStore(@ModelAttribute StoreCreateRequest request, @RequestParam(value = "image", required = false) MultipartFile image)
    {
        return (storeService.saveStore(request, image));
    }

    @PutMapping(path = "/update/{id}")
    public String updateStoreById (@PathVariable long id, @ModelAttribute StoreCreateRequest request, @RequestParam("image") MultipartFile image)
    {
        return (storeService.updateStoreById(id, request, image));
    }

    @GetMapping(path = "/cities")
    public ResponseEntity<List<String>> getCitiesInStore()
    {
       return (ResponseEntity.ok(storeService.getCitiesInStore()));
    }

    @GetMapping(path = "/types")
    public ResponseEntity<List<Type>> getTypesInStore()
    {
       return (ResponseEntity.ok(storeService.getTypesInStore()));
    }

    @GetMapping(path = "/search")
    public ResponseEntity<List<Store>> searchStores (
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "type", required = false) Type type,
            @RequestParam(value = "categories", required = false) String categories
    )
    {
        return (ResponseEntity.ok(storeService.searchStores(city, type, categories)));
    }

    @GetMapping(path = "/random")
    public ResponseEntity<List<Store>> getRandomStores()
    {
        return (ResponseEntity.ok(storeService.getRandomStores()));
    }
}
