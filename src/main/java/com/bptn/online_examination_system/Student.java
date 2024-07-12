package com.bptn.online_examination_system;


import java.io.Serializable;



public class Student implements Serializable{
	//declare instance variable
	String firstName;
	String lastName;
	int id;

	//create parameterized constructor
	Student(String firstName, String lastName, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}

	//creates getter methods
	String getFirstName() {
		return firstName;
	}

	String getLastName() {
		return lastName;
	}

	int getId() {
		return id;
	}

	//creates setter methods
	void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	void setLastName(String lastName) {
		this.lastName = lastName;
	}

	void setId(int id) {
		this.id = id;
	}
	
	//overrides toString method
	@Override
	public String toString(){
		return String.format("[%s, %s, %d ]", firstName, lastName, id);
	}
	
}
