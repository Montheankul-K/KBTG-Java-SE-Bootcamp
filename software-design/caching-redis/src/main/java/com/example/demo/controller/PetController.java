package com.example.demo.controller;

import com.example.demo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping(path = "/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("count")
    public ResponseEntity<String> count() {
        var numberOfPet = petService.count();
        return new ResponseEntity<>(numberOfPet,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addPet() {
        petService.addPet();
        return new ResponseEntity<>("done",HttpStatus.OK);
    }


}
