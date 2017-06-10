package com.tanpugi.cqrs.shared;

public enum DefaultUserType {

	ADMIN("admin"),
	NORMAL("normal");
	
	private String text;

	private DefaultUserType(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	public static DefaultUserType fromString(String text) {
		for (DefaultUserType b : DefaultUserType.values()) {
			if (b.getText().equalsIgnoreCase(text)) {
				return b;
			}
	    }

		throw new DefaultServiceException("Invalid user type");
	}
}
