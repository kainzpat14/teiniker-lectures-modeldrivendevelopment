package org.se.lab;

import lombok.Data;
import lombok.NonNull;

@Data
public class Person {
	private @NonNull String firstname;
	private @NonNull String lastname;
}
