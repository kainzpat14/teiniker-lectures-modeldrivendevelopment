package at.fhj.mdd.ss2020.generics.model;

import at.fhj.mdd.ss2020.generics.annotations.FieldMapping;
import at.fhj.mdd.ss2020.generics.annotations.TelegramMapping;

@TelegramMapping(elementName = "TRANSPORT")
public class TransportTelegram {
	@FieldMapping(elementName = "BARCODE")
	private String barcode;
	@FieldMapping(elementName = "TARGET_ID")
	private int targetId;

	public TransportTelegram(String barcode, int targetId) {
		this.barcode = barcode;
		this.targetId = targetId;
	}

	public TransportTelegram() {

	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public int getTargetId() {
		return targetId;
	}

	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}

}
