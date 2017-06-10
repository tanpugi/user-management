package com.tanpugi.api;

import javax.validation.constraints.NotNull;

public class UserSearchRequest {

	@NotNull
	private String keywords;
	private int page;

	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	
}
