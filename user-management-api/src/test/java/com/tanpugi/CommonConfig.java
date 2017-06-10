package com.tanpugi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tanpugi.cqrs.command.UserService;
import com.tanpugi.cqrs.command.UserServiceImpl;

@Configuration
public class CommonConfig{

	@Bean
	public UserService getUserService() {
		return new UserServiceImpl();
	};
}
