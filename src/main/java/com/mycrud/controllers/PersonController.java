package com.mycrud.controllers;

import com.mycrud.entities.Person;
import com.mycrud.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepo;

    @GetMapping("/person")
    public String showPerson() {
        return "test";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showPersonList(Model model) {
        model.addAttribute("people", personRepo.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String greetingForm(Model model) {
        model.addAttribute("person", new Person());
        return "form";
    }

    @PostMapping("/create")
    public String personCreationSubmit(@ModelAttribute Person person) {
        personRepo.save(person);
        return "index";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deletePerson(@PathVariable int id){
        personRepo.deleteById(id);
        return "index";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPerson(@PathVariable int id, Model model){

        Person person = personRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("person", person);
        return "edit-person";
    }

    @RequestMapping(value = "/update/{id}", method = {RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET})
    public String updatePerson(@PathVariable("id") int id, Model model, @Valid Person person){

        //Person person = (Person) model.asMap().get("person");
        personRepo.save(person);
        return "index";
    }
}