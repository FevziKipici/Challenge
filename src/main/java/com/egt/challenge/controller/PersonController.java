package com.egt.challenge.controller;

import com.egt.challenge.dto.PersonDTO;
import com.egt.challenge.model.Person;
import com.egt.challenge.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;


    @PostMapping
    public ResponseEntity<Map<String,String>> createPerson(@Valid @RequestBody Person person){
       personService.savePerson(person);

       Map<String,String> map=new HashMap<>();
       map.put("Message","Person created successfully");
       map.put("success","true");

       return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonWithId(@PathVariable("id") Long id){
        Person person=personService.findPersonById(id);
        return ResponseEntity.ok(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String,String>> updatePerson(@PathVariable Long id, @Valid @RequestBody PersonDTO personDTO){
        Person person=personService.findPersonById(id);

        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());

        personService.updatePerson(person);

        Map<String,String> map=new HashMap<>();
        map.put("Message","Person updated successfully");
        map.put("success","true");

        return ResponseEntity.ok(map);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,String>> deletePerson(@PathVariable Long id){
        personService.deletePerson(id);

        Map<String,String> map=new HashMap<>();
        map.put("Message","Person deleted successfully");
        map.put("success","true");

        return ResponseEntity.ok(map);
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPerson(){
        List<Person> personList=personService.getAllPerson();
        return ResponseEntity.ok(personList);
    }



}
