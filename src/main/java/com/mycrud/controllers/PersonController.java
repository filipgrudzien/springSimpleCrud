package com.mycrud.controllers;

import com.mycrud.entities.Person;
import com.mycrud.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePerson(@PathVariable int id){
        personRepo.deleteById(id);
        return "index";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPerson(@ModelAttribute Person person){
        return "edit-person";
    }

}