package at.fhj.mdd.ws2020.generics.model;

import at.fhj.mdd.ws2020.generics.annotations.FieldBinaryMapping;
import at.fhj.mdd.ws2020.generics.annotations.MessageBinaryMapping;

@MessageBinaryMapping(totalSize = 60)
public class SetRadioStationMessage {
	@FieldBinaryMapping(offset = 0)
	private String radioStation;

	public SetRadioStationMessage(String radioStation) {
		super();
		this.radioStation = radioStation;
	}

	// default constructor for reflection constructions
	public SetRadioStationMessage() {

	}

	public String getRadioStation() {
		return radioStation;
	}

	public void setRadioStation(String radioStation) {
		this.radioStation = radioStation;
	}

}
