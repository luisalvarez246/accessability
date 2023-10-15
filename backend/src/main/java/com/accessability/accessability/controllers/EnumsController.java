package com.accessability.accessability.controllers;

import com.accessability.accessability.models.Type;
import com.accessability.accessability.repositories.IEnumRepository;
import com.accessability.accessability.services.EnumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class EnumsController
{
    @Autowired
    EnumsService    enumsService;

    @GetMapping(path = "/type")
    public ResponseEntity<List<Type>> getAllTypes()
    {
        return (ResponseEntity.ok(enumsService.getAllTypes()));
    }

    @GetMapping(path = "/cities")
    public ResponseEntity<List<String>> getAllCities()
    {
        return (ResponseEntity.ok(enumsService.getAllCities()));
    }
}
