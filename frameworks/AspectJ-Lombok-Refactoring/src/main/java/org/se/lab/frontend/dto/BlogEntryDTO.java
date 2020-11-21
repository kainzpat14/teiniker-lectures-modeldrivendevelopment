package org.se.lab.frontend.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class BlogEntryDTO {
	private final int id;
	private @NonNull UserDTO user;
	private @NonNull String heading;
	private @NonNull String message;

}
