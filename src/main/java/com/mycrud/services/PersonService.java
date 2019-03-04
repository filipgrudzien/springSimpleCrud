package com.mycrud.services;

import com.mycrud.entities.Person;
import com.mycrud.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepo;

    public void insertOrUpdatePerson(Person person){
        personRepo.save(person);
    }

    public void deletePerson(long personId){
        personRepo.deleteById(personId);
    }

    public List<Person> getAllPeople(){
        return personRepo.findAll();
    }

    public Person getSpecificPerson(long id){

        Person person = personRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        return person;
    }

}
