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
    public List<Type> getAllTypes()
    {
        Type[]      enumValues;
        List<Type>  typeList;

        enumValues = Type.values();
        typeList = new ArrayList<>(Arrays.asList(enumValues));
        return (typeList);
    }

    public List<String> getAllCities()
    {
        City[]          enumValues;
        List<String>    cityList;


        enumValues = City.values();
        cityList = new ArrayList<>(Arrays.asList(enumValues))
                        .stream()
                        .map(city -> city.toString().replace("_", " "))
                        .collect(Collectors.toList());
        return (cityList);
    }
}
