package org.se.lab.frontend.dto;

public class BlogEntryDTO {
	private UserDTO user;
	private String heading;
	private String message;
	private int id;

	public BlogEntryDTO(int id, UserDTO user, String heading, String message) {
		super();
		this.user = user;
		this.heading = heading;
		this.message = message;
		this.id = id;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "BlogEntryDTO [user=" + user + ", heading=" + heading + ", message=" + message + ", id=" + id + "]";
	}

}
