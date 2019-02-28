package com.mycrud.controllers;

import com.mycrud.entities.Person;
import com.mycrud.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepo;

    @GetMapping("/person")
    public String personForm(Model model) {
        model.addAttribute("person", new Person());
        return "index";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Person person) {
        return "result";
    }


    /*
    @RequestMapping("/show")
    public String showEveryPerson(Model model) {

        List<Person> personList = personRepo.findAll();

        if(personList.isEmpty()){
            System.out.println("cossssssssss");
            model.addAttribute("message","the list is empty!!!");
        }else {
            model.addAttribute("personList",personList);
        }

        model.addAttribute("message", "some message");

        return "show-person";
    }
    */


    /*@RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView showEveryPerson(Model model) {

        List<Person> personList = personRepo.findAll();

        if(personList.isEmpty()){
            System.out.println("cossssssssss");
            model.addAttribute("message","the list is empty!!!");
        }else {
            model.addAttribute("personList",personList);
        }

        //model.addAttribute("message", "some message");

        return new ModelAndView("show-person", "model", "messageaaaasdsda");
    }*/

    /*@GetMapping("/show")
    public String greeting(@RequestParam(name="message", required=false, defaultValue="basic message") String message, Model model) {

        model.addAttribute("message", message);
        return "show-person";
    }*/


}

/*
* @Autowired
    public TalkController(TalkRespository talkRepo) {
        this.talkRepo = talkRepo;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addTalk(@RequestBody Talk talk){
        talkRepo.save(talk);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addHardcodedTalk(){
        Talk talk = new Talk("lala");
        talkRepo.save(talk);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Talk> getTalks(){
        return talkRepo.findAll();
    }

 */