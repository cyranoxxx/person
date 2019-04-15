package com.golhan.personal.controller;

import com.golhan.personal.entity.Person;
import com.golhan.personal.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping
    public Person save(@RequestBody @Valid Person person) {
        return personRepository.save(person);
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable long id, @RequestBody @Valid Person person) {
        Person dbInstance = personRepository.findById(id).get();
        dbInstance.setName(person.getName());
        return personRepository.save(dbInstance);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        personRepository.deleteById(id);
    }

    @GetMapping
    public List<Person> findAll() {
        return (List<Person>) personRepository.findAll();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable long id) {
        return personRepository.findById(id).get();
    }
}
