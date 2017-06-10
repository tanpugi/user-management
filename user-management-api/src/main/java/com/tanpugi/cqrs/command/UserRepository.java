package com.tanpugi.cqrs.command;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
	
	int countByEmail(String email);
}
