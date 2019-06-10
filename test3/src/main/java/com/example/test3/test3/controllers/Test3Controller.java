package com.example.test3.test3.controllers;

import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.test3.test3.models.Person;
import com.example.test3.test3.services.PersonServices;

@Component
@RestController
public class Test3Controller {

	@Autowired
	PersonServices personService;

	@RequestMapping("test")
	public String test() {

		return "hello";

	}

	@RequestMapping("person/{id}")
	public List<Person> getPersonById(@PathVariable int id) {

		System.out.println("id is " + id);
		List<Person> persons = personService.getPersonById(id);

		return persons;

	}

	// http://localhost:8080/crypto/ENG/EUR

	@RequestMapping(value = "crypto/{lang}/{anotherlang}", produces = "application/json")

	public String getCryptoByLang(@PathVariable("lang") String language,
			@PathVariable("anotherlang") String anotherLang) {

		System.out.println("lang is " + language);
		System.out.println("another lang is " + anotherLang);

		return personService.getCryptoByLang(language).toString();

	}

	// http://localhost:8080/crypto?lang=ENG&lang2=Heb
	@RequestMapping(value = "crypto")

	public String getParametersFromUrl(@RequestParam HashMap<String, String> prm) {

		System.out.println("prm are  " + prm.get("lang2"));

		return personService.getCryptoByPrm(prm);

	}

	@RequestMapping(value = "checkPost", method = RequestMethod.POST ,  produces = "application/json")
	public String checkPost(@RequestBody String request) {

		
		System.out.println("111111111111");
		System.out.println("request is " + request);
		JSONObject jsonObject = new JSONObject(request);
		return jsonObject.get("USD").toString();

	}

}
