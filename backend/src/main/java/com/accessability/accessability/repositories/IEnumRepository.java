package com.accessability.accessability.repositories;

import com.accessability.accessability.models.Type;

import java.util.List;

public interface IEnumRepository
{
    List<Type> getAllTypes();
    List<String> getAllCities();
}
