package com.accessability.accessability.controllers;

import com.accessability.accessability.models.City;
import com.accessability.accessability.models.Type;
import com.accessability.accessability.repositories.IEnumRepository;
import com.accessability.accessability.services.EnumsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class EnumsControllerTest
{
    @MockBean
    EnumsService enumsService;

    @Autowired
    EnumsController enumsController;

    @Test
    void getAllTypes_returns_a_list_of_types()
    {
        //arrange
        ResponseEntity<List<Type>>  typeList;

        when(enumsService.getAllTypes()).thenReturn(new ArrayList<>(Arrays.asList(Type.values())));
        //act
        typeList = enumsController.getAllTypes();
        //assert
        verify(enumsService, times(1)).getAllTypes();
        assertNotNull(typeList);
    }

    @Test
    void getAllCities_returns_a_list_of_cities()
    {
        //arrange
        ResponseEntity<List<String>>    cityList;
        String[]                        cities = {"Winterfell", "Dorne"};

        when(enumsService.getAllCities()).thenReturn(new ArrayList<>(Arrays.asList(cities)));
        //act
        cityList = enumsController.getAllCities();
        //assert
        verify(enumsService, times(1)).getAllCities();
        assertNotNull(cityList);
    }
}