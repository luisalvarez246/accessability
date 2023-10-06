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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StoreServiceTest {

    @InjectMocks
    private StoreService storeService;

    @Mock
    private IStoreRepository storeRepository;

    @Mock
    private ICharacteristicRepository characteristicRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test_save_store() {
        StoreCreateRequest request = new StoreCreateRequest();
        Store store = new Store();
        request.setStoreName("Mi Tienda");
        request.setType(Type.restaurant);
        request.setAddress("Dirección de Tienda");
        request.setPhone("Teléfono de Tienda");
        request.setWeb("Web de Tienda");
        request.setEmail("Email de Tienda");
        request.setImage("Image de Tienda");
        request.setCharacteristicIds(Arrays.asList(1L, 5L, 7L, 8L));
        storeService.mapRequest(store, request);

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
        StoreCreateRequest request = new StoreCreateRequest();
        Store store = new Store();
        request.setStoreName("Mi Tienda");
        request.setType(Type.restaurant);
        request.setAddress("Dirección de Tienda");
        request.setPhone("Teléfono de Tienda");
        request.setWeb("Web de Tienda");
        request.setEmail("Email de Tienda");
        request.setImage("Image de Tienda");
        request.setCharacteristicIds(Arrays.asList(1L, 5L, 7L, 8L));
        storeService.mapRequest(store, request);

        ArrayList<Store> storeList = new ArrayList<>();
        storeList.add(store);

        when(storeRepository.findAll()).thenReturn(storeList);

        ArrayList<Store> expectedStoresList = storeService.getAllStores();

        assertEquals(storeList, expectedStoresList);
    }

    @Test
    public void update_a_store_by_id() {
        Store updateStore = new Store();
        StoreCreateRequest request = new StoreCreateRequest();
        request.setStoreName("Mi Tienda");
        request.setType(Type.restaurant);
        request.setAddress("Dirección de Tienda");
        request.setPhone("Teléfono de Tienda");
        request.setWeb("Web de Tienda");
        request.setEmail("Email de Tienda");
        request.setImage("Image de Tienda");
        request.setCharacteristicIds(Arrays.asList(1L, 5L, 7L, 8L));
        storeService.mapRequest(updateStore, request);
        updateStore.setId(1L);


        when(storeRepository.findById(1L)).thenReturn(Optional.of(updateStore));
        when(storeRepository.save(updateStore)).thenReturn(updateStore);

        String result = storeService.updateStoreById(1L, request);

        assertEquals("Store updated: 1" , result);
    }
}
