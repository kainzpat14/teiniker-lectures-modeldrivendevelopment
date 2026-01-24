package at.fhj.mdd.generics;

import at.fhj.mdd.generics.model.AliveTelegram;

public class AliveXmlConverter extends GenericXmlConverter<AliveTelegram> {

	public AliveXmlConverter() {
		super(AliveTelegram.class);
	}
}
