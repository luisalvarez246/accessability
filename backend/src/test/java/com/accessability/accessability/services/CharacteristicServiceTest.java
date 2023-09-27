package com.accessability.accessability.services;

import com.accessability.accessability.models.Characteristic;
import com.accessability.accessability.models.Store;
import com.accessability.accessability.models.Type;
import com.accessability.accessability.repositories.ICharacteristicRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.Proxy;
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

    private List<Characteristic> characteristics;

    Store store = new Store();
    @BeforeEach
    void setUp() {
        Characteristic characteristic1 = new Characteristic();
        characteristic1.setId(1L);
        characteristic1.setIcon("icon1");
        characteristic1.setTitle("Adapted services");

        Characteristic characteristic2 = new Characteristic();
        characteristic2.setId(2L);
        characteristic2.setIcon("icon2");
        characteristic2.setTitle("Accesss with ramp");
    }

    @Test
    void saveCharacteristic() {
        Characteristic expectedCharacteristic = new Characteristic();
        expectedCharacteristic.setId(2L);
        expectedCharacteristic.setIcon("icon2");
        expectedCharacteristic.setTitle("Accesss with ramp");

        when(characteristicRepository.save(expectedCharacteristic)).thenReturn(expectedCharacteristic);

        String saveCharacteristic = characteristicService.saveCharacteristic(expectedCharacteristic);

        assertEquals("Added new characteristic", saveCharacteristic);

    }

    @Test
    void getCharacteristicById() {
        Characteristic expectedCharacteristic = new Characteristic();
        expectedCharacteristic.setId(1L);
        expectedCharacteristic.setIcon("icon1");
        expectedCharacteristic.setTitle("Access with ramp");

        when(characteristicRepository.findById(1L)).thenReturn(Optional.of(expectedCharacteristic));

        Characteristic getCharacteristicById = characteristicService.getCharacteristicById(1L);

        assertEquals("Access with ramp", getCharacteristicById.getTitle());

    }

    @Test
    void getAllCharacteristics() {
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

        ArrayList<Characteristic> characteristicListExpected = characteristicService.getAllCharacteristics();

        assertEquals(characteristicListExpected, characteristicList);

    }

    @Test
    public void testDeleteCharacteristicById_Success() {

        // Configurar el comportamiento del mock para que no lance excepciones al eliminar
        doNothing().when(characteristicRepository).deleteById(1L);

        // Llamar al método de eliminación y verificar el resultado
        String result = characteristicService.deleteCharacteristicById(1L);

        // Verificar que se llamó al método deleteById con el ID correcto
        verify(characteristicRepository).deleteById(1L);

        // Verificar que el resultado es el mensaje de éxito esperado
        assertEquals("Deleted characteristic1", result);
    }

    @Test
    public void testDeleteCharacteristicById_Failure() {

        // Configurar el mock para que lance una excepción al eliminar
        doThrow(new RuntimeException("Error deleting characteristic")).when(characteristicRepository).deleteById(2L);

        // Llamar al método de eliminación y verificar el resultado
        String result = characteristicService.deleteCharacteristicById(2L);

        // Verificar que se llamó al método deleteById con el ID correcto
        verify(characteristicRepository).deleteById(2L);

        // Verificar que el resultado es el mensaje de error esperado
        assertEquals("Error deleting characteristic", result);
    }

    @Test
    public void testUpdateCharacteristicById_Success() {

        // Crear una instancia de la característica que se va a actualizar
        Characteristic updateCharacteristic = new Characteristic();
        updateCharacteristic.setId(1L);

        Store store1 = new Store();
        store1.setId(1L);
        store1.setStoreName("Store1");
        store1.setType(Type.valueOf("restaurant"));
        store1.setCategories("pmr");
        store1.setAddress("la address");
        store1.setEmail("el email");
        store1.setPhone("el phone");
        store1.setWeb("la web");
        store1.setImage("la image");

        // Configurar el comportamiento del mock del repositorio para existsById y save
        when(characteristicRepository.existsById(updateCharacteristic.getId())).thenReturn(true);

        // Simular el resultado de findByCharacteristicId
        when(storeService.findByCharacteristicId(updateCharacteristic.getId())).thenReturn(new ArrayList<Store>());

        // Simular el resultado de findAllById
        when(characteristicRepository.findAllById(anyList())).thenReturn(new ArrayList<Characteristic>());

        // Simular el resultado de crossUpdate
        when(storeService.crossUpdate(any(Store.class))).thenReturn("StoreUpdated");

        // Llamar al método de actualización y verificar el resultado
        String result = characteristicService.updateCharacteristicById(updateCharacteristic);

        // Verificar que existsById y save se hayan llamado con el ID correcto
        verify(characteristicRepository).existsById(updateCharacteristic.getId());
        verify(characteristicRepository).save(updateCharacteristic);

        // Verificar que findByCharacteristicId se haya llamado con el ID correcto
        verify(storeService).findByCharacteristicId(updateCharacteristic.getId());

        // Verificar que crossUpdate se haya llamado con una tienda
        verify(storeService).crossUpdate(store1);

        // Verificar el resultado
        assertEquals("Characteristic updated: id_1 updated Stores:StoreUpdated", result);
    }
}
