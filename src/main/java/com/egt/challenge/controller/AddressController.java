package com.egt.challenge.controller;


import com.egt.challenge.model.Address;
import com.egt.challenge.model.Person;
import com.egt.challenge.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;


    @PostMapping
    public ResponseEntity<Map<String,String>> createPerson(@Valid @RequestBody Address address){
        addressService.saveAddress(address);

        Map<String,String> map=new HashMap<>();
        map.put("Message","Address created successfully");
        map.put("success","true");

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }





}


