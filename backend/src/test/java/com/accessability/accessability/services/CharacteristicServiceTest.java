package com.accessability.accessability.services;

import com.accessability.accessability.models.Characteristic;
import com.accessability.accessability.models.Store;
import com.accessability.accessability.repositories.ICharacteristicRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CharacteristicServiceTest {

    @InjectMocks
    CharacteristicService characteristicService;

    @Mock
    StoreService storeService;

    @Mock
    ICharacteristicRepository characteristicRepository;
    @Test
    void save_a_characteristic() {
        Characteristic expectedCharacteristic = new Characteristic();
        expectedCharacteristic.setId(2L);
        expectedCharacteristic.setIcon("icon2");
        expectedCharacteristic.setTitle("Accesss with ramp");

        when(characteristicRepository.save(expectedCharacteristic)).thenReturn(expectedCharacteristic);

        String saveCharacteristic = characteristicService.saveCharacteristic(expectedCharacteristic);

        assertEquals("Added new characteristic", saveCharacteristic);

    }

    @Test
    void get_characteristic_by_an_id() {
        Characteristic expectedCharacteristic = new Characteristic();
        expectedCharacteristic.setId(1L);
        expectedCharacteristic.setIcon("icon1");
        expectedCharacteristic.setTitle("Access with ramp");

        when(characteristicRepository.findById(1L)).thenReturn(Optional.of(expectedCharacteristic));

        Characteristic getCharacteristicById = characteristicService.getCharacteristicById(1L);

        assertEquals("Access with ramp", getCharacteristicById.getTitle());

    }

    @Test
    void get_all_characteristics() {
        Characteristic characteristic_1 = new Characteristic();
        characteristic_1.setId(1L);
        characteristic_1.setIcon("icon1");
        characteristic_1.setTitle("Access with ramp");

        Characteristic characteristic_2 = new Characteristic();
        characteristic_2.setId(2L);
        characteristic_2.setIcon("icon2");
        characteristic_2.setTitle("Adapted services");

        ArrayList<Characteristic> characteristicList = new ArrayList<>();
        characteristicList.add(characteristic_1);
        characteristicList.add(characteristic_2);
        when(characteristicRepository.findAll()).thenReturn(characteristicList);

        List<Characteristic> characteristicListExpected = characteristicService.getAllCharacteristics();

        assertEquals(characteristicListExpected, characteristicList);

    }

    @Test
    public void delete_a_characteristic_by_id_success() {

        doNothing().when(characteristicRepository).deleteById(1L);

        String result = characteristicService.deleteCharacteristicById(1L);

        verify(characteristicRepository).deleteById(1L);

        assertEquals("Deleted characteristic1", result);
    }

    @Test
    public void delete_characteristic_by_id_failure() {

        doThrow(new RuntimeException("Error deleting characteristic")).when(characteristicRepository).deleteById(2L);

        String result = characteristicService.deleteCharacteristicById(2L);

        verify(characteristicRepository).deleteById(2L);

        assertEquals("Error deleting characteristic", result);
    }

    @Test
    public void update_characteristic_by_id_success() {

        Characteristic updateCharacteristic = new Characteristic();
        updateCharacteristic.setId(1L);

        Store store1 = new Store();
        store1.setId(1L);
        StringBuilder changedStores;

        changedStores = new StringBuilder();
        changedStores.append("updated Stores:");
        changedStores.append(storeService.crossUpdate(store1));

        when(characteristicRepository.existsById(updateCharacteristic.getId())).thenReturn(true);

        when(storeService.findByCharacteristicId(updateCharacteristic.getId())).thenReturn(new ArrayList<>());

        String result = characteristicService.updateCharacteristicById(updateCharacteristic.getId(), updateCharacteristic)+ "StoreUpdated";

        verify(characteristicRepository).existsById(updateCharacteristic.getId());
        verify(characteristicRepository).save(updateCharacteristic);

        assertEquals("Characteristic updated: id_1 updated Stores:StoreUpdated", result);
    }
}
