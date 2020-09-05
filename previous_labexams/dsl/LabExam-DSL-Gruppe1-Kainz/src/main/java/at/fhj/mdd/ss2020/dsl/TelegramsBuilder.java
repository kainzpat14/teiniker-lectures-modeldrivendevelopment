package at.fhj.mdd.ss2020.dsl;

import at.fhj.mdd.ss2020.dsl.metamodel.MTelegram;
import at.fhj.mdd.ss2020.dsl.metamodel.MTelegrams;

public class TelegramsBuilder {
	private MTelegrams telegrams = new MTelegrams();

	public TelegramBuilder inOutTelegram(String name, String mapping) {
		MTelegram telegram = new MTelegram(name, mapping);
		telegrams.getInputTelegrams().add(telegram);
		telegrams.getOutputTelegrams().add(telegram);
		return new TelegramBuilder(this, telegram);
	}

	public TelegramBuilder inTelegram(String name, String mapping) {
		MTelegram telegram = new MTelegram(name, mapping);
		telegrams.getInputTelegrams().add(telegram);
		return new TelegramBuilder(this, telegram);
	}

	public TelegramBuilder outTelegram(String name, String mapping) {
		MTelegram telegram = new MTelegram(name, mapping);
		telegrams.getOutputTelegrams().add(telegram);
		return new TelegramBuilder(this, telegram);
	}

	public MTelegrams toTelegrams() {
		return telegrams;
	}
}
