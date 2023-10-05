package com.accessability.accessability.services;

import com.accessability.accessability.dto.StoreCreateRequest;
import com.accessability.accessability.models.Store;
import com.accessability.accessability.models.Type;
import com.accessability.accessability.repositories.ICharacteristicRepository;
import com.accessability.accessability.repositories.IStoreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class StoreServiceTest {

    //@InjectMocks
    //private StoreService storeService;

    @Autowired
    IStoreRepository iStoreRepository;

    @Mock
    private ICharacteristicRepository characteristicRepository;
/*
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test_save_store() {
        StoreCreateRequest request = new StoreCreateRequest();
        StoreCreateRequest payload;
        Store store;

        store = new Store();
        payload = new StoreCreateRequest();
        payload.setStoreName("Mi Tienda");
        payload.setType(Type.restaurant);
        payload.setAddress("Dirección de Tienda");
        payload.setPhone("Teléfono de Tienda");
        payload.setWeb("Web de Tienda");
        payload.setEmail("Email de Tienda");
        //payload.setImage("Image de Tienda");
        payload.setCharacteristicIds(Arrays.asList(1L, 5L, 7L, 8L));
        storeService.mapRequest(store, payload);

        when(storeRepository.save(any())).thenReturn(store);

        String result = storeService.saveStore(request);

        assertEquals("Added new Store", result);
    }

    @Test
    public void test_get_store_by_id() {
        long storeId = 1L;
        Store expectedStore = new Store();
        when(storeRepository.findById(storeId)).thenReturn(Optional.of(expectedStore));

        Store result = storeService.getStoreById(storeId);

        assertEquals(expectedStore, result);
    }

    @Test
    public void test_delete_store_by_id() {
        long storeId = 1L;
        doNothing().when(storeRepository).deleteById(storeId);

        String result = storeService.deleteStoreById(storeId);

        assertEquals("Deleted " + storeId, result);
    }

    @Test
    public void test_get_all_stores() {
        StoreCreateRequest payload;
        Store store;
        store = new Store();
        payload = new StoreCreateRequest();
        payload.setStoreName("Mi Tienda");
        payload.setType(Type.restaurant);
        payload.setAddress("Dirección de Tienda");
        payload.setPhone("Teléfono de Tienda");
        payload.setWeb("Web de Tienda");
        payload.setEmail("Email de Tienda");
        //payload.setImage("Image de Tienda");
        payload.setCharacteristicIds(Arrays.asList(1L, 5L, 7L, 8L));
        storeService.mapRequest(store, payload);

        ArrayList<Store> storeList = new ArrayList<>();
        storeList.add(store);

        when(storeRepository.findAll()).thenReturn(storeList);

        ArrayList<Store> expectedStoresList = storeService.getAllStores();

        assertEquals(storeList, expectedStoresList);
    }

    @Test
    public void update_a_store_by_id() {
        Store updateStore = new Store();
        StoreCreateRequest payload;
        payload = new StoreCreateRequest();
        payload.setStoreName("Mi Tienda");
        payload.setType(Type.restaurant);
        payload.setAddress("Dirección de Tienda");
        payload.setPhone("Teléfono de Tienda");
        payload.setWeb("Web de Tienda");
        payload.setEmail("Email de Tienda");
        //payload.setImage("Image de Tienda");
        payload.setCharacteristicIds(Arrays.asList(1L, 5L, 7L, 8L));
        storeService.mapRequest(updateStore, payload);
        updateStore.setId(1L);


        when(storeRepository.findById(1L)).thenReturn(Optional.of(updateStore));
        when(storeRepository.save(updateStore)).thenReturn(updateStore);

        String result = storeService.updateStoreById(1L, request);

        assertEquals("Store updated: 1" , result);
    }*/

    @Test
    void dumbTest() throws IOException {
        String storePath = System.getProperty("user.dir") + "/src/main/webapp/images";
        File    directory;
        File[]  files;
        ArrayList<String> fileNames;
        ArrayList<Store>    storeList;
        ArrayList<String>   imageList;

        storeList = (ArrayList<Store>) iStoreRepository.findAll();
        imageList = (ArrayList<String>) storeList.stream()
                .map(Store::getImage)
                .distinct()
                .collect(Collectors.toList());
        directory = new File(storePath);
        files = new File(storePath).listFiles();
        fileNames = new ArrayList<>();
        for (File file : files)
        {
            fileNames.add(file.getName());
            if (!imageList.contains(file.getName()) && !file.getName().equals("default.png"))
                Files.delete(Path.of(storePath, file.getName()));
        }
        //Files.delete(Path.of(storePath, fileNames.get(1)));

        System.out.println(fileNames);
    }
}
