package com.accessability.accessability.controllers;

import com.accessability.accessability.models.Category;
import com.accessability.accessability.models.Characteristic;
import com.accessability.accessability.models.Type;
import com.accessability.accessability.services.CharacteristicService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class CharacteristicControllerTest
{
    @Autowired
    private CharacteristicController     characteristicController;

    @MockBean
    private CharacteristicService        characteristicService;

    private ArrayList<Characteristic>    characteristicList;
    private Characteristic               emptyCharacteristic;


    @BeforeEach
    public void setup()
    {
        Characteristic  characteristic;

        characteristicList = new ArrayList<>();
        for (int i = 0; i < 2; i++)
        {
            characteristic = new Characteristic();
            characteristic.setTitle("Support Staff for PMR");
            characteristic.setIcon("support_staff.svg");
            characteristic.setCategory(Category.prm);
            characteristicList.add(characteristic);
        }
        characteristicList.get(0).setId(1L);
        characteristicList.get(1).setId(2L);
        emptyCharacteristic = new Characteristic();
    }

    @Test
    void getAllCharacteristics()
    {
        //arrange
        ArrayList<Characteristic>    response;

        when(characteristicService.getAllCharacteristics()).thenReturn(characteristicList);
        //act
        response = characteristicController.getAllCharacteristics();
        //assert
        verify(characteristicService, times(1)).getAllCharacteristics();
        assertEquals(2, response.size());
    }

    @Test
    void saveCharacteristic()
    {
        //arrange
        String          response;
        when(characteristicService.saveCharacteristic(any(Characteristic.class))).thenReturn("Added new Characteristic");
        //act
        response = characteristicController.saveCharacteristic(emptyCharacteristic);
        //assert
        verify(characteristicService, times(1)).saveCharacteristic(emptyCharacteristic);
        assertNotNull(response);
        assertEquals("Added new Characteristic", response);
    }

    @Nested
    class GetCharacteristicById
    {
        @BeforeEach
        void setup()
        {
           when(characteristicService.getCharacteristicById(any(Long.class))).thenAnswer(invocation ->
           {
                Long argument = invocation.getArgument(0);
                if (argument != null && (argument < 1L || argument > 2L))
                    return (null);
                else if (argument == 1L)
                    return (characteristicList.get(0));
                else
                    return (characteristicList.get(1));
            });
        }

        @Test
        void non_existing_id_returns_null()
        {
            //arrange
            Characteristic    searchedCharacteristic;
            //act1
            searchedCharacteristic = characteristicController.getCharacteristicById(3L);
            //assert1
            verify(characteristicService, times(1)).getCharacteristicById(3L);
            assertNull(searchedCharacteristic);
            //act2
            searchedCharacteristic = characteristicController.getCharacteristicById(10L);
            //assert2
            verify(characteristicService, times(1)).getCharacteristicById(10L);
            assertNull(searchedCharacteristic);
        }

        @Test
        void existing_id_returns_a_characteristic()
        {
            //arrange
            Characteristic    searchedCharacteristic;
            //act1
            searchedCharacteristic = characteristicController.getCharacteristicById(1L);
            //assert1
            verify(characteristicService, times(1)).getCharacteristicById(1L);
            assertNotNull(searchedCharacteristic);
            assertEquals(1, searchedCharacteristic.getId());
            //act2
            searchedCharacteristic = characteristicController.getCharacteristicById(2L);
            //assert2
            verify(characteristicService, times(1)).getCharacteristicById(2L);
            assertNotNull(searchedCharacteristic);
            assertEquals(2, searchedCharacteristic.getId());
        }
    }

    @Nested
    class DeleteCharacteristicById
    {
        @BeforeEach
        void setup()
        {
           when(characteristicService.deleteCharacteristicById(any(Long.class))).thenAnswer(invocation ->
           {
                Long argument = invocation.getArgument(0);
                if (argument != null && (argument < 1L || argument > 2L))
                    return ("Not deleted, characteristic with ID: " + argument + "does not exist");
                else if (argument == 1L)
                {
                    characteristicList.remove(0);
                    return ("Deleted 1");
                }
                else
                {
                    characteristicList.remove(characteristicList.size() - 1);
                    return ("Deleted 2");
                }
            });
        }

        @Test
        void non_existing_id_returns_error_message()
        {
            //arrange
            String  deletedCharacteristic;
            //act1
            deletedCharacteristic = characteristicController.deleteCharacteristicById(3L);
            //assert1
            verify(characteristicService, times(1)).deleteCharacteristicById(3L);
            assertEquals("Not deleted, characteristic with ID: 3does not exist", deletedCharacteristic);
            //act2
            deletedCharacteristic = characteristicController.deleteCharacteristicById(10L);
            //assert2
            verify(characteristicService, times(1)).deleteCharacteristicById(10L);
            assertEquals("Not deleted, characteristic with ID: 10does not exist", deletedCharacteristic);
        }

        @Test
        void existing_id_deletes_a_characteristic()
        {
            //arrange
            String  deletedCharacteristic;
            //act1
            deletedCharacteristic = characteristicController.deleteCharacteristicById(1L);
            //assert1
            verify(characteristicService, times(1)).deleteCharacteristicById(1L);
            assertNotNull(deletedCharacteristic);
            assertEquals("Deleted 1", deletedCharacteristic);
            assertEquals(1, characteristicList.size());
            //act2
            deletedCharacteristic = characteristicController.deleteCharacteristicById(2L);
            //assert2
            verify(characteristicService, times(1)).deleteCharacteristicById(2L);
            assertNotNull(deletedCharacteristic);
            assertEquals("Deleted 2", deletedCharacteristic);
            assertEquals(0, characteristicList.size());
        }
    }
    
    @Nested
    class UpdateCharacteristicById
    {
        @BeforeEach
        void setup()
        {
            when(characteristicService.updateCharacteristicById(any(Long.class), any(Characteristic.class))).thenAnswer(invocation ->
            {
                Long argument = invocation.getArgument(0);
                if (argument != null && (argument < 1L || argument > 2L))
                    return ("Characteristic not updated: Record with ID :" + argument + "does not exist");
                else if (argument == 1L)
                {
                    return ("Characteristic updated: 1");
                }
                else
                {
                    return ("Characteristic updated: 2");
                }
            });
        }

        @Test
        void non_existing_id_returns_error_message()
        {
            //arrange
            String  updatedCharacteristic;
            //act1
            updatedCharacteristic = characteristicController.updateCharacteristicById(3L, emptyCharacteristic);
            //assert1
            verify(characteristicService, times(1)).updateCharacteristicById(3L, emptyCharacteristic);
            assertEquals("Characteristic not updated: Record with ID :3does not exist", updatedCharacteristic);
            //act2
            updatedCharacteristic = characteristicController.updateCharacteristicById(10L, emptyCharacteristic);
            //assert2
            verify(characteristicService, times(1)).updateCharacteristicById(10L, emptyCharacteristic);
            assertEquals("Characteristic not updated: Record with ID :10does not exist", updatedCharacteristic);
        }

        @Test
        void existing_id_updates_a_characteristic()
        {
            //arrange
            String  updatedCharacteristic;
            //act1
            updatedCharacteristic = characteristicController.updateCharacteristicById(1L, emptyCharacteristic);
            //assert1
            verify(characteristicService, times(1)).updateCharacteristicById(1L, emptyCharacteristic);
            assertNotNull(updatedCharacteristic);
            assertEquals("Characteristic updated: 1", updatedCharacteristic);
            //act2
            updatedCharacteristic = characteristicController.updateCharacteristicById(2L, emptyCharacteristic);
            //assert2
            verify(characteristicService, times(1)).updateCharacteristicById(2L, emptyCharacteristic);
            assertNotNull(updatedCharacteristic);
            assertEquals("Characteristic updated: 2", updatedCharacteristic);
        }
    }
}