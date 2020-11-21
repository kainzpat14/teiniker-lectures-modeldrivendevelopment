package org.se.lab.business.model;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
public class BlogEntry {
	@EqualsAndHashCode.Include
	private final int id;
	private @NonNull User user;
	private @NonNull Date timestamp;
	private @NonNull String heading;
	private @NonNull String message;

}
