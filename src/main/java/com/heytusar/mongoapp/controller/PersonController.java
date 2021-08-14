package com.heytusar.mongoapp.controller;

import java.util.List;

import com.heytusar.mongoapp.model.Person;
import com.heytusar.mongoapp.repository.PersonRepository;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    private PersonRepository personRepository;
	
	@Autowired
	public PersonController(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	
	@RequestMapping("/person")
	List<Person> getAllPerson() {
		return personRepository.findAll();
	}

    @RequestMapping("/person/{id}")
	Person getPersonById(@PathVariable String id) {
		return personRepository.findById(id).orElse(null);
	}
	
	@RequestMapping("/personByConuntry/{country}")
	List<Person> getPersonsByCountry(@PathVariable String country) {
		return personRepository.findAllByCountry(country);
	}
	
	@PostMapping("/person")
	Person savePlayer(@RequestBody String jsonBody) {
        
        JSONObject json = new JSONObject(jsonBody);
        Person person = new Person();
        person.setName(json.getString("name"));
        person.setCountry(json.getString("country"));

		return personRepository.save(person);
	}
}
