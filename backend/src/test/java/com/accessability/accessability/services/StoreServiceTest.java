package com.accessability.accessability.services;

import com.accessability.accessability.dto.StoreCreateRequest;
import com.accessability.accessability.models.Store;
import com.accessability.accessability.models.Type;
import org.hibernate.annotations.SecondaryRow;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StoreServiceTest
{
    @Autowired
    StoreService    storeService;

    @Test
    void mapRequest()
    {
        StoreCreateRequest  payload;
        Store               store;

        store = new Store();
        payload = new StoreCreateRequest();
        payload.setStoreName("Mi Tienda");
        payload.setType(Type.restaurant);
        payload.setAddress("Dirección de Tienda");
        payload.setPhone("Dirección de Tienda");
        payload.setWeb("Dirección de Tienda");
        payload.setEmail("Dirección de Tienda");
        payload.setImage("Dirección de Tienda");
        payload.setCharacteristicIds(Arrays.asList(1L, 5L, 7L, 8L));
        storeService.mapRequest(store, payload);
        System.out.println(store);
        System.out.println(store.getCharacteristic());
    }
}