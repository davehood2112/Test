package com.radial.testproject.domain;

import java.util.List;

/**
 * Models a simple bank account.
 * **All classes are intentionally kept as simple as possible with only enough complexity to allow for testing scenarios**
 * 
 * @author David Hood
 *
 */
public class Account {
	
	private String acctNum;
	private List<Person> persons;
	private float balance;
	private String acctType;
	private boolean isActive;
	
	public String getAcctNum() {
		return acctNum;
	}
	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getAcctType() {
		return acctType;
	}
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}	
}
