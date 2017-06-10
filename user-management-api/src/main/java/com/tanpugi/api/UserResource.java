package com.tanpugi.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tanpugi.cqrs.command.UserService;
import com.tanpugi.cqrs.query.UserQueryModel;
import com.tanpugi.cqrs.query.UserQueryService;
import com.tanpugi.cqrs.shared.DefaultUserModel;

@RestController
@RequestMapping("/user")
public class UserResource {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserQueryService userQueryService;

	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public UserAddResponse add(@Valid @RequestBody UserAddRequest request) {
		DefaultUserModel m = mapper(new DefaultUserModel(), request);
		userService.addUser(m);

		return new UserAddResponse();
	}

	@ResponseBody
	@RequestMapping(value="/search", method={ RequestMethod.GET, RequestMethod.POST })
	public UserSearchResponse search(
		@Valid @NotNull @RequestParam String keywords,
		@Valid @RequestParam int page) {
		UserQueryModel m = userQueryService.search(keywords, page);
		List<UserResponse> users =
			m.getUserModels()
				.stream()
				.map((u) -> mapper(new UserResponse(), u))
				.collect(Collectors.toList());
		
		UserSearchResponse response = new UserSearchResponse();
		response.setPages(m.getTotalPages());
		response.setUsers(users);
		
		return response;
	}
	
	private DefaultUserModel mapper(DefaultUserModel m, UserAddRequest request) {
		m.setType(request.getType());
		m.setFirstName(request.getFirstName());
		m.setLastName(request.getLastName());
		m.setEmail(request.getEmail());
		m.setIntroduction(request.getIntroduction());
		m.setJobDescription(request.getJobDescription());
		m.setAccessCode(request.getAccessCode());
		m.setDateOfBirth(request.getDateOfBirth());
		return m;
	}

	private UserResponse mapper(UserResponse r, DefaultUserModel u) {
		r.setUserId(u.getUserId());
		r.setType(u.getType());
		r.setFirstName(u.getFirstName());
		r.setLastName(u.getLastName());
		r.setEmail(u.getEmail());
		r.setIntroduction(u.getIntroduction());
		r.setAccessCode(u.getAccessCode());
		r.setJobDescription(u.getJobDescription());
		r.setDateOfBirth(u.getDateOfBirth());
		return r;
	}
}
