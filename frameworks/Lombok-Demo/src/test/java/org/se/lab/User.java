package org.se.lab;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private @Getter @Setter String name;
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private @Setter String password;
}
