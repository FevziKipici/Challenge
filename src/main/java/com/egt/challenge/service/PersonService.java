package com.egt.challenge.service;

import com.egt.challenge.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPerson();
    Person findPersonById(Long id);
    void savePerson(Person person);
    void updatePerson(Person person);
    void deletePerson(Long id);
}
