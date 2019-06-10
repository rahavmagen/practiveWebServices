package com.example.test3.test3.services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test3.test3.models.Person;
import com.example.test3.test3.repository.PersonDB;

@Service
public class PersonServicesImple implements PersonServices {

	@Autowired 
	PersonDB personDb;
	
	private final Logger log = Logger.getLogger(PersonServicesImple.class.getName());
	
	@Override
	public List<Person> getAllPersons() {
		
		personDb.getPersons();
		return personDb.getPersons();
	}

	@Override
	public List<Person> getPersonById(int id) {
		
		return  personDb.getPersons().stream().filter(p -> p.getIdName() == id).collect(Collectors.toList());
		
	}

	@Override
	public String getCryptoByLang(String  prm) {

		JSONObject jsonObject= null;
		
		try {
			URI uri = new URI("https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=ENG");
			System.out.println("uri = "+uri.toString());
			jsonObject = new JSONObject(new JSONTokener(uri.toURL().openStream())); 
			
		} catch (URISyntaxException  | IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("return value "+jsonObject);
		return jsonObject.toString();
	}
	
	@Override
	public String getCryptoByPrm(HashMap<String, String> prm) {

		JSONObject jsonObject= null;
		String prmValues="";
		int i=0;
		for(Map.Entry<String , String>  entry: prm.entrySet()) {
			if(i==0) {
			prmValues = prmValues+ entry.getValue()+",";
			}
			else {
				prmValues = prmValues+","+ entry.getValue();
			}
			i++;
		}
		
		System.out.println("prm values = "+prmValues);
		
		try {
			URI uri = new URI("https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms="+prmValues);
			System.out.println("the  uri = "+uri.toString());
			jsonObject = new JSONObject(new JSONTokener(uri.toURL().openStream())); 
		
			
			System.out.println("the euro is " + jsonObject.get("EUR"));
			JSONObject tmpObj = new JSONObject();
			tmpObj.put("test" , "111");
			jsonObject.put("1" , tmpObj);
			
			System.out.println("return value "+jsonObject.toString());
			
		} catch (URISyntaxException  | IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("return value "+jsonObject);
		log.log(Level.INFO,"the rerun value from logger is "+jsonObject);
		
		return jsonObject.toString();
	}
	
	


}
