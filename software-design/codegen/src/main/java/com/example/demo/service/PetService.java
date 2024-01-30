package com.example.demo.service;

import org.openapi.example.model.Pet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    public List<Pet> list() {
        var p = new Pet(1L, "sample-pet");
        return List.of(p);
    }
}
