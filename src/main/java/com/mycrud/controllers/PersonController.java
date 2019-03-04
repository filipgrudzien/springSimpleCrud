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

    @RequestMapping("/")
    public String showMainPage(){
        return "index";
    }

    @GetMapping("/create")
    public String showCreationForm(Model model) {
        model.addAttribute("person", new Person());
        return "form";
    }

    @PostMapping("/create")
    public String submitCreationForm(@ModelAttribute Person person, Model model) {
        personRepo.save(person);
        model.addAttribute("people", personRepo.findAll());
        return "index";
    }

    @GetMapping(value = "/delete/{id}")
    public String deletePerson(@PathVariable int id, Model model){
        personRepo.deleteById(id);
        model.addAttribute("people", personRepo.findAll());
        return "index";
    }

    @RequestMapping(value = "/edit/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public String editPerson(@PathVariable int id, Model model){

        Person person = personRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("person", person);
        return "edit-person";
    }

    @RequestMapping(value = "/update/{id}", method = {RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET})
    public String updatePerson(@PathVariable("id") int id, Model model, @Valid Person person){

        personRepo.save(person);
        model.addAttribute("people", personRepo.findAll());
        return "index";
    }
}