package com.example.test3.test3.models;

public class Person {

	String firstName;
	String lastName;
	int  IdName;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getIdName() {
		return IdName;
	}
	public void setIdName(int idName) {
		IdName = idName;
	}
	
	public Person(String firstName, String lastName, int idName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		IdName = idName;
	}

	
}
