package com.sbt.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.sbt.ActiveFlag;
import com.sbt.Position;

@XmlRootElement
public class Employee {

	// First Name
	private String firstName;
	
	// Last Name
	private String lastName;
	
	// Middle Initial
	private String middleInitial;
	
	// Email Address
	private String emailAddress;
	
	// Phone Number
	private String phoneNumber;
	
	// Position Category (Indirect, Direct, Program Manager, Director, Executive)
	private Position position;
	
	// Date Hired
	private Date dateHired;
	
	// Address 1
	private String address1;
	
	// Address 2
	private String address2;
	
	// City
	private String city;
	
	// State
	private String state;
	
	
	// Zip Code
	private String zipCode;
	
	// Active Flag
	private ActiveFlag activeFlag;
	
	public Employee() {
		
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

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Date getDateHired() {
		return dateHired;
	}

	public void setDateHired(Date dateHired) {
		this.dateHired = dateHired;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public ActiveFlag getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(ActiveFlag activeFlag) {
		this.activeFlag = activeFlag;
	}

}
