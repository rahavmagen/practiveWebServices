package com.example.test3.test3.repository;

import java.util.List;

import com.example.test3.test3.models.Person;

public interface  PersonDB {
	
	public void populateDB ();
	public List<Person> getPersons();

}
