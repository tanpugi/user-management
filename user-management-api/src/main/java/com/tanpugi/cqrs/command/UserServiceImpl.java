package com.tanpugi.cqrs.command;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanpugi.cqrs.query.UserQueryService;
import com.tanpugi.cqrs.shared.DefaultServiceException;
import com.tanpugi.cqrs.shared.DefaultUserModel;
import com.tanpugi.cqrs.shared.DefaultUserType;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserQueryService userQueryService;

	public void addUser(DefaultUserModel m) throws DefaultServiceException {
		String email = m.getEmail();
		if ((userRepository.countByEmail(email) == 0)) {
			User e = mapper(new User(), m);
			userRepository.save(e);
			triggerEvent(e, m);
		} else {
			throw new DefaultServiceException("Already has user with email = " + email);
		}
	}
	
	private void triggerEvent(User e, DefaultUserModel m) throws DefaultServiceException {
		userQueryService.addQUser(mapper(m, e));
	}

	private DefaultUserModel mapper(DefaultUserModel m, User e) {
		m.setType(e.getType().getText());
		m.setUserId(e.getId());
		m.setFirstName(e.getFirstName());
		m.setLastName(e.getLastName());
		m.setEmail(e.getEmail());
		m.setIntroduction(e.getIntroduction());
		m.setJobDescription(e.getJobDescription());
		m.setAccessCode(e.getAccessCode());
		m.setDateOfBirth(e.getDateOfBirth());
		return m;
	}
	private User mapper(User e, DefaultUserModel m) {
		e.setType(DefaultUserType.fromString(m.getType()));
		e.setFirstName(m.getFirstName());
		e.setLastName(m.getLastName());
		e.setIntroduction(m.getIntroduction());
		e.setEmail(m.getEmail());
		if (e.getType() == DefaultUserType.ADMIN) {
			e.setAccessCode(m.getAccessCode());
			e.setJobDescription(m.getJobDescription());
			e.setDateOfBirth(null);
		}
		if (e.getType() == DefaultUserType.NORMAL) {
			e.setAccessCode(null);
			e.setJobDescription(null);
			e.setDateOfBirth(m.getDateOfBirth());
		}
		
		return e;
	}
}
 