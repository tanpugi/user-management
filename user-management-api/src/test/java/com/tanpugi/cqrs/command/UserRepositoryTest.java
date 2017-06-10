package com.tanpugi.cqrs.command;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tanpugi.BaseTest;
import com.tanpugi.cqrs.command.User;
import com.tanpugi.cqrs.command.UserRepository;
import com.tanpugi.cqrs.shared.DefaultUserType;

import java.util.Date;
import java.util.List;

public class UserRepositoryTest extends BaseTest {
	
	@Autowired
	private UserRepository repository;
	
	@Test
	public void testSave() {
		User m = new User();
		m.setType(DefaultUserType.ADMIN);
		m.setFirstName("fname");
		m.setLastName("lname");
		m.setIntroduction("intro");
		m.setJobDescription("jobdesc");
		m.setAccessCode("access");
		m.setDateOfBirth(new Date());
		
		m = repository.save(m);
		assertThat(m).isNotNull();
		assertThat(m.getId()).isNotNull();
		assertThat(m.getFirstName()).isEqualTo("fname");
	}
	
	@Test
	public void testFindAll() {
		testSave();
		List<User> fcs = repository.findAll();
		assertThat(fcs).isNotEmpty();
	}
}
