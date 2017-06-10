package com.tanpugi.cqrs.command;

import com.tanpugi.cqrs.shared.DefaultServiceException;
import com.tanpugi.cqrs.shared.DefaultUserModel;

public interface UserService {

	void addUser(DefaultUserModel model) throws DefaultServiceException;
}
 