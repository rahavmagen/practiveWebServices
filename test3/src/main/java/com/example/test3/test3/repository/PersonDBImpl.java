package com.example.test3.test3.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.test3.test3.models.Person;

@Repository
public class PersonDBImpl implements PersonDB {

	PersonDBImpl() {
		this.populateDB();
	}
	
	List<Person> persons = new ArrayList<Person>();
	
	@Override
	public void populateDB() {

		Person p1 = new Person("rahav" , "Magen", 11 );
		Person p2 = new Person("Maya" , "tal", 22 );
		Person p3 = new Person("Shahar" , "xMagen", 33 );
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
	}

	@Override
	public List<Person> getPersons() {
		return persons;
	}




}
