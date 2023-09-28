package com.accessability.accessability.services;

import com.accessability.accessability.models.Store;
import com.accessability.accessability.repositories.ICharacteristicRepository;
import com.accessability.accessability.repositories.IStoreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
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
    public void testSaveStore() {
        StoreCreateRequest request = new StoreCreateRequest();

        // Configura request según tus necesidades

        Store store = new Store();
        when(storeRepository.save(any())).thenReturn(store);

        String result = storeService.saveStore(request);

        assertEquals("Added new Store", result);
        verify(storeRepository, times(1)).save(any());
    }

    @Test
    public void testGetStoreById() {
        long storeId = 1L;
        Store expectedStore = new Store();
        when(storeRepository.findById(storeId)).thenReturn(Optional.of(expectedStore));

        Store result = storeService.getStoreById(storeId);

        assertEquals(expectedStore, result);
    }

    @Test
    public void testDeleteStoreById() {
        long storeId = 1L;
        doNothing().when(storeRepository).deleteById(storeId);

        String result = storeService.deleteStoreById(storeId);

        assertEquals("Deleted " + storeId, result);
    }

// Escribe pruebas similares para otros métodos, como getAllStores y updateStoreById

}
