package com.accessability.accessability.services;

import com.accessability.accessability.models.Type;
import com.accessability.accessability.repositories.IEnumRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

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
}
