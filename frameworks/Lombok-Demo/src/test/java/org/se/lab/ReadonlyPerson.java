package org.se.lab;

import lombok.Data;
import lombok.Value;
import lombok.With;

@Data
@Value
public class ReadonlyPerson {
	private String firstname;
	private @With String lastname;
}
