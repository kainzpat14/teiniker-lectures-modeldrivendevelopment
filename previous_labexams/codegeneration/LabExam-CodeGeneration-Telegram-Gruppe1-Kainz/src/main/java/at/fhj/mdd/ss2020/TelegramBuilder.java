package at.fhj.mdd.ss2020;

import at.fhj.mdd.ss2020.metamodel.MIntField;
import at.fhj.mdd.ss2020.metamodel.MStringField;
import at.fhj.mdd.ss2020.metamodel.MTelegram;
import at.fhj.mdd.ss2020.metamodel.MTelegrams;

public class TelegramBuilder {

	private TelegramsBuilder parent;
	private MTelegram telegram;

	public TelegramBuilder(TelegramsBuilder parent, MTelegram telegram) {
		this.parent = parent;
		this.telegram = telegram;
	}

	public TelegramBuilder stringField(String name, String mapping) {
		telegram.getFields().add(new MStringField(name, mapping));
		return this;
	}

	public TelegramBuilder intField(String name, String mapping) {
		telegram.getFields().add(new MIntField(name, mapping));
		return this;
	}

	public TelegramBuilder inOutTelegram(String name, String mapping) {
		return parent.inOutTelegram(name, mapping);
	}

	public TelegramBuilder inTelegram(String name, String mapping) {
		return parent.inTelegram(name, mapping);
	}

	public TelegramBuilder outTelegram(String name, String mapping) {
		return parent.outTelegram(name, mapping);
	}

	public MTelegrams toTelegrams() {
		return parent.toTelegrams();
	}

}
