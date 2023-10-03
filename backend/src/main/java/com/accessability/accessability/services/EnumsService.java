package com.accessability.accessability.services;

import com.accessability.accessability.models.City;
import com.accessability.accessability.models.Type;
import com.accessability.accessability.repositories.IEnumRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnumsService implements IEnumRepository
{
    @Override
    public ArrayList<Type> getAllTypes()
    {
        Type[]          enumValues;
        ArrayList<Type> typeList;

        enumValues = Type.values();
        typeList = new ArrayList<>(Arrays.asList(enumValues));
        return (typeList);
    }
    @Override
    public ArrayList<String> getAllCities()
    {
        City[]              enumValues;
        ArrayList<String> cityList;


        enumValues = City.values();
        cityList = (ArrayList<String>) new ArrayList<>(Arrays.asList(enumValues))
                        .stream()
                        .map(city -> city.toString().replace("_", " "))
                        .collect(Collectors.toList());
        return (cityList);
    }
}