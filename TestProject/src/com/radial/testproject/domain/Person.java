package com.radial.testproject.domain;

/**
 * Models a single bank customer.
 * **All classes are intentionally kept as simple as possible with only enough complexity to allow for testing scenarios**
 *   
 * @author David Hood
 *
 */
public class Person {

	private String fName;
	private String lName;
	private String personId;
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
}
