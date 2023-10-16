package com.accessability.accessability.services;

import com.accessability.accessability.initializers.CharacteristicInitializer;
import com.accessability.accessability.initializers.StoreInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataInitializationService
{
    @Autowired
    private CharacteristicInitializer characteristicInitializer;

    @Autowired
    private StoreInitializer storeInitializer;

    public void initializeData() {
        characteristicInitializer.characteristicInitialize();
        storeInitializer.storeInitialize();
    }
}
