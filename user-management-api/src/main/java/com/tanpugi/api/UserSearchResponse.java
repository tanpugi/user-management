package com.tanpugi.api;

import java.util.List;

import com.tanpugi.api.shared.DefaultResponse;

public class UserSearchResponse extends DefaultResponse {

	private List<UserResponse> users;
	private int pages;

	public List<UserResponse> getUsers() {
		return users;
	}
	public void setUsers(List<UserResponse> users) {
		this.users = users;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
}
