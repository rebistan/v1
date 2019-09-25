package com.Alansari.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


/*
 * Author Rebistan
 * 
 */

@Entity
public class User {
	
	@Id	
	@Column(name="qid")				
	private String qid;
	
	@Column(name="password",nullable = false)
	private String password;
		
	@Column(name="first_name",nullable = false)
	private String firstName;

	@Column(name="last_name",nullable = false)
	private String lastName;
	
	
	@Column(name="phone",nullable = false)
	private String phone;
	
	@Column(name="position",nullable = false)
	private String position;
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Column(name="nationality",nullable = false)
	private String nationality;
	

	@Column(name="gender",nullable = false)
	private String gender;
		

	private boolean isEnabled;
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
	public String getGender() {
		return gender;
	}


	
	public String getNationality() {
		return nationality;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
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

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getQid() {
		return qid;
	}

	public void setQid(String qid) {
		this.qid = qid;
	}


}
