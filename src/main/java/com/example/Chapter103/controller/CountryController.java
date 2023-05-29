package com.example.Chapter103.controller;

import com.example.Chapter103.model.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.module.Configuration;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController {
    @GetMapping("/france")
    public Country france(){
        Country c = Country.of("France",67);
        return c;
    }
    @GetMapping("/spain")
    public ResponseEntity<Country> spain(){
        Country c = Country.of("Spain",47);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("continent","Europe")
                .header("capital","Barselone")
                .header("favorite_food","cheese and wine")
                .body(c);
    }
    @GetMapping("/all")
    public List<Country> contries(){
        Country c1 = Country.of("France",67);
        Country c2 = Country.of("Spain",47);
        return List.of(c1,c2);
    }
}
