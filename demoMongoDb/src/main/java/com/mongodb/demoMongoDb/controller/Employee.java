package com.mongodb.demoMongoDb.controller;

public class Employee {

	private String id;
	private String firstName;
	private String lastname;
	private String address;
	public Employee(String _id, String firstName, String lastname, String address) {
		super();
		this.id = _id;
		this.firstName = firstName;
		this.lastname = lastname;
		this.address = address;
	}
	public Employee() {

	}
	public String get_id() {
		return id;
	}
	public void set_id(String _id) {
		this.id = _id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
