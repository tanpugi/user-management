package com.tanpugi.cqrs.query;

import com.tanpugi.cqrs.shared.DefaultServiceException;
import com.tanpugi.cqrs.shared.DefaultUserModel;

public interface UserQueryService {
	void addQUser(DefaultUserModel m) throws DefaultServiceException;
	UserQueryModel search(String keywords, int page) throws DefaultServiceException;
}
