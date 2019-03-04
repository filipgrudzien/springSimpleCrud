package com.mycrud.controllers;

import com.mycrud.entities.Person;
import com.mycrud.repositories.PersonRepository;
import com.mycrud.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/")
    public String showMainPage() {
        return "index";
    }

    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    public String showCreationForm(Model model) {
        model.addAttribute("person", new Person());
        return "form";
    }

    @PostMapping("/create")
    public String submitCreationForm(@Valid Person person, Errors errors, Model model) {

        if(errors.hasErrors()){
            //model.addAttribute("person", new Person());
            return "form";
        }

        personService.insertOrUpdatePerson(person);
        model.addAttribute("people", personService.getAllPeople());
        return "index";
    }

    @GetMapping(value = "/delete/{id}")
    public String deletePerson(@PathVariable long id, Model model) {

        personService.deletePerson(id);
        model.addAttribute("people", personService.getAllPeople());
        return "index";
    }

    @RequestMapping(value = "/edit/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public String editPerson(@PathVariable long id, Model model) {

        Person person = personService.getSpecificPerson(id);
        model.addAttribute("person", person);
        return "edit-person";
    }

    @RequestMapping(value = "/update/{id}", method = {RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET})
    public String updatePerson(@PathVariable("id") long id, Model model, @Valid Person person, Errors errors) {

        if(errors.hasErrors()){
            model.addAttribute("person", person);
            return "edit-person";
        }

        personService.insertOrUpdatePerson(person);
        model.addAttribute("people", personService.getAllPeople());
        return "index";
    }
}