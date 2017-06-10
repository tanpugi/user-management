package com.tanpugi.cqrs.query;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="tanpugi", type="user")
public class QUser {
	@Id
	private String id;
	private String userId;
	private String type;
	private String firstName;
	private String lastName;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
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
	
	@Override
	public String toString() {
		String s = "";
		s += "type(" + type + ")\n";
		s += "userid(" + userId + ")\n";
		s += "fname(" + firstName + ")\n";
		s += "lname(" + lastName + ")\n";
		s += "intro(" + introduction + ")\n";
		s += "jobdesc(" + jobDescription + ")\n";
		
		return s;
	}
}
