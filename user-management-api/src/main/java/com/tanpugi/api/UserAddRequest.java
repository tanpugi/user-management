package com.tanpugi.api;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class UserAddRequest {

	@NotNull
	private String type;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull @Email 
	private String email;
	@NotNull
	private String introduction;
	@NotNull
	private String accessCode;
	@NotNull
	private String jobDescription;
	@NotNull
	private Date dateOfBirth;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
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
