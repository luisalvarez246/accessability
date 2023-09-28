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

    @Nested
    class GetStoreById
    {
        @BeforeEach
        void setup()
        {
           storeList.get(0).setId(1L);
           storeList.get(1).setId(2L);

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
           storeList.get(0).setId(1L);
           storeList.get(1).setId(2L);

           when(storeService.deleteStoreById(any(Long.class))).thenAnswer(invocation ->
           {
                Long argument = invocation.getArgument(0);
                if (argument != null && (argument < 1L || argument > 2L))
                    return (null);
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
}