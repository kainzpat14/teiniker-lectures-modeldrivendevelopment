package org.se.lab.business.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

@Data
public class User {
	@EqualsAndHashCode.Include
	private @NonNull String username;
	@ToString.Exclude
	private @NonNull String password;

}
