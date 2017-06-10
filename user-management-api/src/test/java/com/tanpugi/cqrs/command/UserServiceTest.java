package com.tanpugi.cqrs.command;

import static org.assertj.core.api.Assertions.*;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tanpugi.BaseTest;
import com.tanpugi.cqrs.command.UserService;
import com.tanpugi.cqrs.shared.DefaultServiceException;
import com.tanpugi.cqrs.shared.DefaultUserModel;

public class UserServiceTest extends BaseTest {
	
	@Autowired
	private UserService service;
	
	@Test
	public void testAddUser() {
		DefaultUserModel m = new DefaultUserModel();
		m.setType("admin");
		m.setFirstName("fname");
		m.setLastName("lname");
		m.setIntroduction("intro");
		m.setJobDescription("jobdesc");
		m.setAccessCode("access");
		m.setEmail("email@email.com");
		m.setDateOfBirth(new Date());
		
		service.addUser(m);
	}

	@Test(expected=DefaultServiceException.class)
	public void testAddUserInvalidType() {
		DefaultUserModel m = new DefaultUserModel();
		m.setType("invalid");
		m.setFirstName("fname");
		m.setLastName("lname");
		m.setIntroduction("intro");
		m.setJobDescription("jobdesc");
		m.setAccessCode("access");
		m.setEmail("email@email.com");
		m.setDateOfBirth(new Date());
		
		service.addUser(m);
	}

	@Test(expected=DefaultServiceException.class)
	public void testAddUserDuplicateEmail() {
		testAddUser();
		testAddUser();
	}
}
