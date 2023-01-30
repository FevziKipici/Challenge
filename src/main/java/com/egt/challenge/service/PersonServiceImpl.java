package com.egt.challenge.service;

import com.egt.challenge.exception.ResourceNotFoundException;
import com.egt.challenge.model.Person;
import com.egt.challenge.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository personRepository;


    @Override
    public List<Person> getAllPerson() {
       return personRepository.findAll();
    }

    @Override
    public Person findPersonById(Long id) {
        return personRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("The person with id "+id+" not found"));
    }

    @Override
    public void savePerson(Person person) {
         personRepository.save(person);
    }

    @Override
    public void updatePerson(Person person) {
        Person foundPerson=findPersonById(person.getPersonId());

//        foundPerson.setFirstName(person.getFirstName());
//        foundPerson.setLastName(person.getLastName());
        //TODO address must be added

        personRepository.save(person);

    }


    @Override
    public void deletePerson(Long id) {
        Person foundPerson=findPersonById(id);
        personRepository.delete(foundPerson);

    }
}
