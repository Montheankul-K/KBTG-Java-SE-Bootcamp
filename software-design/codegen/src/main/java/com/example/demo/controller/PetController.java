package com.example.demo.controller;


import com.example.demo.api.PetsApi;
import com.example.demo.service.PetService;
import org.openapi.example.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PetController implements PetsApi {
    @Autowired
    private PetService petService;

    @Override
    public ResponseEntity<List<Pet>> listPets(Integer limit) {
        var pets = petService.list();
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }
}

