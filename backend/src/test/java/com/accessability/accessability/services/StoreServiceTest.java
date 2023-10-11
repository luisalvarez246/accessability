package com.accessability.accessability.services;

import com.accessability.accessability.dto.StoreCreateRequest;
import com.accessability.accessability.models.Store;
import com.accessability.accessability.models.Type;
import com.accessability.accessability.repositories.ICharacteristicRepository;
import com.accessability.accessability.repositories.IStoreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class StoreServiceTest {

    @Autowired
    private StoreService storeService;

    @MockBean
    IStoreRepository storeRepository;

    @MockBean
    private ICharacteristicRepository characteristicRepository;

    private ArrayList<Store>    storeList;

    private StoreCreateRequest  payload;

    @BeforeEach
    public void setup()
    {
        Store               store;

        storeList = new ArrayList<>();
        for (int i = 0; i < 2; i++)
        {
            store = new Store();
            store.setStoreName("Store");
            store.setType(Type.restaurant);
            store.setAddress("address");
            store.setPhone("0000000");
            store.setWeb("store.com");
            store.setEmail("store@gmail.com");
            store.setDescription("description");
            store.setImage("default.png");
            storeList.add(store);
        }
        storeList.get(0).setId(1L);
        storeList.get(1).setId(2L);

        payload = new StoreCreateRequest();
        payload.setStoreName("Store");
        payload.setType(Type.restaurant);
        payload.setAddress("Address");
        payload.setPhone("0000000");
        payload.setWeb("store.com");
        payload.setEmail("store@gmail.com");
        payload.setDescription("description");
        payload.setImage(null);
        payload.setCharacteristicIds(Arrays.asList(1L, 5L, 7L, 8L));
    }

    @Test
    public void test_save_store()
    {
        //Arrange
        String  result;

        when(storeRepository.save(any(Store.class))).thenReturn(any(Store.class));
        //Act
        result = storeService.saveStore(payload, null);
        //Assert
        verify(storeRepository, times(1)).save(any());
        assertEquals("Added new Store", result);
    }

    @Nested
    public class GetStoreById
    {
        @Test
        public void getStoreById_existing_id_returns_a_store()
        {
            //Arrange
            long    storeId;
            Store   expectedStore;
            Store   result;

            storeId = 1L;
            expectedStore = storeList.get(0);
            when(storeRepository.findById(storeId)).thenReturn(Optional.of(expectedStore));
            //Act
            result = storeService.getStoreById(storeId);
            //Assert
            verify(storeRepository, times(1)).findById(storeId);
            assertEquals(expectedStore, result);
        }

        @Test
        public void getStoreById_non_existing_id_returns_null()
        {
            //Arrange
            long    storeId;
            Store   result;

            storeId = storeList.size() + 1L;
            when(storeRepository.findById(storeId)).thenReturn(Optional.empty());
            //Act
            result = storeService.getStoreById(storeId);
            //Assert
            verify(storeRepository, times(1)).findById(storeId);
            assertNull(result);
        }
    }

    @Test
    public void getAllStores_returns_ArrayList_of_Store()
    {
        //Arrange
        ArrayList<Store>  result;
        when(storeRepository.findAll()).thenReturn(storeList);
        //Act
        result = storeService.getAllStores();
        //Assert
        verify(storeRepository, times(1)).findAll();
        assertNotNull(result);
    }

    @Nested
    public class DeleteStoreById
    {
        @Test
        public void deleteStoreById_existing_id_deletes_a_store() throws IOException
        {
            //Arrange
            long    storeId;
            String  expectedMessage;
            String   result;

            storeId = 1L;
            expectedMessage = "Deleted store with ID: " + storeId + ", Deleted images: null";
            doNothing().when(storeRepository).deleteById(any(Long.class));
            when(storeRepository.existsById(any(Long.class))).thenReturn(true);
            //Act
            result = storeService.deleteStoreById(storeId, true);
            //Assert
            verify(storeRepository, times(1)).deleteById(any(Long.class));
            assertEquals(expectedMessage, result);
        }

        @Test
        public void deleteStoreById_non_existing_id_returns_error_message()
        {
            //Arrange
            long    storeId;
            Store   result;

            storeId = storeList.size() + 1L;
            when(storeRepository.findById(storeId)).thenReturn(Optional.empty());
            //Act
            result = storeService.getStoreById(storeId);
            //Assert
            verify(storeRepository, times(1)).findById(storeId);
            assertNull(result);
        }
    }
/*
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
}
