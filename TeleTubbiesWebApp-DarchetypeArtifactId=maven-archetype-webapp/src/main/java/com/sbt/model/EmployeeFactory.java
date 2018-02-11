package com.sbt.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.sbt.ActiveFlag;
import com.sbt.Position;

public class EmployeeFactory {

	private EmployeeFactory() {
		
	}
	
	public static final Employee getEmployee(final DBObject dbObject) {
		Employee employee = new Employee();
		String firstName = (String) dbObject.get("firstName");
		employee.setFirstName(firstName);
		
		//  Last Name
		String lastName = (String) dbObject.get("lastName");
		employee.setLastName(lastName);
		
		//  Middle Initial
		String middleInitial = (String) dbObject.get("middleInitial");
		employee.setMiddleInitial(middleInitial);
		
		//  Email Address
		String emailAddress = (String) dbObject.get("emailAddress");
		employee.setEmailAddress(emailAddress);
		
		//  Phone Number
		String phoneNumber = (String) dbObject.get("phoneNumber");
		employee.setPhoneNumber(phoneNumber);
		
		//  Position Category (Indirect, Direct, Program Manager, Director, Executive)
		if(dbObject.containsField("position") && dbObject.get("position") != null) {
			System.out.println(dbObject.get("position"));
			Position position = Position.getPosition((String) dbObject.get("position"));
			employee.setPosition(position);
		}
		
		//  Date Hired
		if(dbObject.containsField("dateHired") && dbObject.get("dateHired") != null) {
			try {
				// String pattern = "MM/dd/yyyy";
				// DateFormat dateFormat = new SimpleDateFormat(pattern);
				Date dateHired = (Date) dbObject.get("dateHired");
				employee.setDateHired(dateHired);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//  Address 1
		String address1 = (String) dbObject.get("address1");
		employee.setAddress1(address1);
		
		//  Address 2
		String address2 = (String) dbObject.get("address2");
		employee.setAddress2(address2);
		
		//  City
		String city = (String) dbObject.get("city");
		employee.setCity(city);
		
		//  State
		String state = (String) dbObject.get("state");
		employee.setState(state);
		
		//  Zip Code
		String zipCode = (String) dbObject.get("zipCode");
		employee.setZipCode(zipCode);
		
		//  Active Flag
		if(dbObject.containsField("activeFlag") && dbObject.get("activeFlag") != null) {
			ActiveFlag activeFlag = ActiveFlag.getActiveFlag((String) dbObject.get("activeFlag"));	
			employee.setActiveFlag(activeFlag);
		}
		return employee;
	}
}
