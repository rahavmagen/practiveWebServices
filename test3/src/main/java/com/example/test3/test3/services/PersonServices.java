package com.example.test3.test3.services;

import java.util.HashMap;
import java.util.List;

import com.example.test3.test3.models.Person;

public interface  PersonServices {
	
	public List<Person> getAllPersons();
	public List<Person> getPersonById(int id);
	public String  getCryptoByLang(String prm);
	public String  getCryptoByPrm(HashMap<String,String> prm);
	
	


}
