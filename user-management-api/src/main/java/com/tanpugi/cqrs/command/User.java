package com.tanpugi.cqrs.command;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.tanpugi.cqrs.shared.DefaultUserType;

@Document
public class User {
	@Id
	private String id;
	private DefaultUserType type;
	private String firstName;
	private String lastName;
	@Indexed
	private String email;
	private String introduction;
	private String accessCode;
	private String jobDescription;
	private Date dateOfBirth;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public DefaultUserType getType() {
		return type;
	}
	public void setType(DefaultUserType type) {
		this.type = type;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getAccessCode() {
		return accessCode;
	}
	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	
	
}
