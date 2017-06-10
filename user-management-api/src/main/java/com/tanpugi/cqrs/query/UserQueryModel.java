package com.tanpugi.cqrs.query;

import java.util.List;

import com.tanpugi.cqrs.shared.DefaultUserModel;

public class UserQueryModel {

	private List<DefaultUserModel> userModels;
	private int totalPages;

	public List<DefaultUserModel> getUserModels() {
		return userModels;
	}
	public void setUserModels(List<DefaultUserModel> userModels) {
		this.userModels = userModels;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	
	
}
