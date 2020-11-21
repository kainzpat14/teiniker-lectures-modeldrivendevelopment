package org.se.lab.application;

public class UserDTO {
	private String username;

	public UserDTO(String username) {
		this.username = username;
	}

	public UserDTO(User user) {
		this(user.getUsername());
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "UserDTO [username=" + username + "]";
	}

}
