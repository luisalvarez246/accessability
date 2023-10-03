package com.accessability.accessability.controllers;

import com.accessability.accessability.models.Type;
import com.accessability.accessability.repositories.IEnumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping(path = "/api")
public class EnumsController
{
    @Autowired
    IEnumRepository iEnumRepository;

    @GetMapping(path = "/type")
    public ResponseEntity<ArrayList<Type>> getAllTypes()
    {
        return (ResponseEntity.ok(iEnumRepository.getAllTypes()));
    }

    @GetMapping(path = "/cities")
    public ResponseEntity<ArrayList<String>> getAllCities()
    {
        return (ResponseEntity.ok(iEnumRepository.getAllCities()));
    }
}
