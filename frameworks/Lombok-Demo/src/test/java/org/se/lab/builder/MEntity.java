package org.se.lab.builder;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

@Data
@Builder
public class MEntity {
	private String name;
	@Singular
	private List<MProperty> properties;
}
