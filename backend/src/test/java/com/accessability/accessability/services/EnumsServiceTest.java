package com.accessability.accessability.services;

import com.accessability.accessability.models.City;
import com.accessability.accessability.models.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EnumsServiceTest {

    @Autowired
    EnumsService    enumsService;

    @Test
    void getAllTypes_retrieves_all_fields_in_Types_enum()
    {
        //arrange
        List<Type>  typeList;
        int         currentNumberOfTypes;
        //act
        currentNumberOfTypes = Type.values().length;
        typeList = enumsService.getAllTypes();
        //assert
        assertNotNull(typeList);
        assertEquals(currentNumberOfTypes, typeList.size());
    }

    @Test
    void getAllCities_retrieves_all_fields_in_City_enum()
    {
        //arrange
        List<String>    citiesList;
        int             currentNumberOfCities;
        //act
        currentNumberOfCities = City.values().length;
        citiesList = enumsService.getAllCities();
        //assert
        assertNotNull(citiesList);
        assertEquals(currentNumberOfCities, citiesList.size());
    }
}