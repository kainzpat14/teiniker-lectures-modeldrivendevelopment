package at.fhj.mdd;

import at.fhj.mdd.annotations.FieldMapping;
import at.fhj.mdd.annotations.TelegramMapping;

@TelegramMapping(elementName = "TRANSPORT")
public class TransportTelegram {

	public TransportTelegram() {

	}

	@FieldMapping(elementName = "BARCODE")
	private String barcode;

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	@FieldMapping(elementName = "TARGET")
	private int target;

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

}
