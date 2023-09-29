package com.accessability.accessability.controllers;

import com.accessability.accessability.dto.StoreCreateRequest;
import com.accessability.accessability.models.Characteristic;
import com.accessability.accessability.models.Store;
import com.accessability.accessability.models.Type;
import com.accessability.accessability.services.StoreService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalMatchers.not;
import static org.mockito.Mockito.*;

@SpringBootTest
class StoreControllerTest
{
    @Autowired
    private StoreController     storeController;

    @MockBean
    private StoreService        storeService;

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
            store.setImage("img.png");
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
        payload.setImage("store.png");
        payload.setCharacteristicIds(Arrays.asList(1L, 5L, 7L, 8L));
    }


    @Test
    void getAllStores()
    {
        //arrange
        ArrayList<Store>    response;

        when(storeService.getAllStores()).thenReturn(storeList);
        //act
        response = storeController.getAllStores();
        //assert
        verify(storeService, times(1)).getAllStores();
        assertEquals(2, response.size());
    }

    @Test
    void saveStore()
    {
        //arrange
        String  response;
        when(storeService.saveStore(any(StoreCreateRequest.class))).thenReturn("Added new Store");
        //act
        response = storeController.saveStore(payload);
        //assert
        verify(storeService, times(1)).saveStore(payload);
        assertNotNull(response);
        assertEquals("Added new Store", response);
    }

    @Nested
    class GetStoreById
    {
        @BeforeEach
        void setup()
        {
           when(storeService.getStoreById(any(Long.class))).thenAnswer(invocation ->
           {
                Long argument = invocation.getArgument(0);
                if (argument != null && (argument < 1L || argument > 2L))
                    return (null);
                else if (argument == 1L)
                    return (storeList.get(0));
                else
                    return (storeList.get(1));
            });
        }

        @Test
        void non_existing_id_returns_null()
        {
            //arrange
            Store    searchedStore;
            //act1
            searchedStore = storeController.getStoreById(3L);
            //assert1
            verify(storeService, times(1)).getStoreById(3L);
            assertNull(searchedStore);
            //act2
            searchedStore = storeController.getStoreById(10L);
            //assert2
            verify(storeService, times(1)).getStoreById(10L);
            assertNull(searchedStore);
        }

        @Test
        void existing_id_returns_a_store()
        {
            //arrange
            Store    searchedStore;
            //act1
            searchedStore = storeController.getStoreById(1L);
            //assert1
            verify(storeService, times(1)).getStoreById(1L);
            assertNotNull(searchedStore);
            assertEquals(1, searchedStore.getId());
            //act2
            searchedStore = storeController.getStoreById(2L);
            //assert2
            verify(storeService, times(1)).getStoreById(2L);
            assertNotNull(searchedStore);
            assertEquals(2, searchedStore.getId());
        }
    }

    @Nested
    class DeleteStoreById
    {
        @BeforeEach
        void setup()
        {
           when(storeService.deleteStoreById(any(Long.class))).thenAnswer(invocation ->
           {
                Long argument = invocation.getArgument(0);
                if (argument != null && (argument < 1L || argument > 2L))
                    return ("Not deleted, store with ID: " + argument + "does not exist");
                else if (argument == 1L)
                {
                    storeList.remove(0);
                    return ("Deleted 1");
                }
                else
                {
                    storeList.remove(storeList.size() - 1);
                    return ("Deleted 2");
                }
            });
        }

        @Test
        void non_existing_id_returns_error_message()
        {
            //arrange
            String  deletedStore;
            //act1
            deletedStore = storeController.deleteStoreById(3L);
            //assert1
            verify(storeService, times(1)).deleteStoreById(3L);
            assertEquals("Not deleted, store with ID: 3does not exist", deletedStore);
            //act2
            deletedStore = storeController.deleteStoreById(10L);
            //assert2
            verify(storeService, times(1)).deleteStoreById(10L);
            assertEquals("Not deleted, store with ID: 10does not exist", deletedStore);
        }

        @Test
        void existing_id_deletes_a_store()
        {
            //arrange
            String  deletedStore;
            //act1
            deletedStore = storeController.deleteStoreById(1L);
            //assert1
            verify(storeService, times(1)).deleteStoreById(1L);
            assertNotNull(deletedStore);
            assertEquals("Deleted 1", deletedStore);
            assertEquals(1, storeList.size());
            //act2
            deletedStore = storeController.deleteStoreById(2L);
            //assert2
            verify(storeService, times(1)).deleteStoreById(2L);
            assertNotNull(deletedStore);
            assertEquals("Deleted 2", deletedStore);
            assertEquals(0, storeList.size());
        }
    }
    @Nested
    class UpdateStoreById
    {
        @BeforeEach
        void setup()
        {
           when(storeService.updateStoreById(any(Long.class), any(StoreCreateRequest.class))).thenAnswer(invocation ->
           {
                Long argument = invocation.getArgument(0);
                if (argument != null && (argument < 1L || argument > 2L))
                    return ("Store not updated: Record with ID :" + argument + "does not exist");
                else if (argument == 1L)
                {
                    return ("Store updated: 1");
                }
                else
                {
                    return ("Store updated: 2");
                }
            });
        }

        @Test
        void non_existing_id_returns_error_message()
        {
            //arrange
            String  updatedStore;
            //act1
            updatedStore = storeController.updateStoreById(3L, payload);
            //assert1
            verify(storeService, times(1)).updateStoreById(3L, payload);
            assertEquals("Store not updated: Record with ID :3does not exist", updatedStore);
            //act2
            updatedStore = storeController.updateStoreById(10L, payload);
            //assert2
            verify(storeService, times(1)).updateStoreById(10L, payload);
            assertEquals("Store not updated: Record with ID :10does not exist", updatedStore);
        }

        @Test
        void existing_id_updates_a_store()
        {
            //arrange
            String  updatedStore;
            //act1
            updatedStore = storeController.updateStoreById(1L, payload);
            //assert1
            verify(storeService, times(1)).updateStoreById(1L, payload);
            assertNotNull(updatedStore);
            assertEquals("Store updated: 1", updatedStore);
            //act2
            updatedStore = storeController.updateStoreById(2L, payload);
            //assert2
            verify(storeService, times(1)).updateStoreById(2L, payload);
            assertNotNull(updatedStore);
            assertEquals("Store updated: 2", updatedStore);
        }
    }
}