package org.se.lab.builder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MProperty {
	private String name;
	private MType type;
}
