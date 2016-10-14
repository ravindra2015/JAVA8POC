package org.springframework.samples.mvc.javapoc.customer;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Customer {

	private String firstName,lastName,city;
	private int age;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfRegister;	    
	  
	public Customer(String firstName, String lastName, int age,String city, LocalDate dateOfRegister) {  
	    super();  
	    this.firstName = firstName;  
	    this.lastName = lastName;  
	    this.age=age;
	    this.city=city;
	    this.dateOfRegister = dateOfRegister;  
	}

	public Customer() {}

	@Override
	public String toString() {
	    return "[" + firstName + " " + lastName +" " + age +" " + dateOfRegister +" " + city +"]";
	}

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getDateOfRegister() {
		return dateOfRegister;
	}

	public void setDateOfRegister(LocalDate dateOfRegister) {
		this.dateOfRegister = dateOfRegister;
	}
	
}