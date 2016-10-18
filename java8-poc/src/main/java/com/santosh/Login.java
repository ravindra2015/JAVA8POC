package com.santosh;


public class Login {

	String firstName,lastName;
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Login(String firstName, String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
		}
	
	@Override
	public String toString() {
	    return "[" + firstName + " " + lastName +"]";
	}
}
