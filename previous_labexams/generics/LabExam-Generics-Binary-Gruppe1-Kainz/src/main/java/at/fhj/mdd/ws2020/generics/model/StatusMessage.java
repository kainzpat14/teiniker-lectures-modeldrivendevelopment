package at.fhj.mdd.ws2020.generics.model;

import at.fhj.mdd.ws2020.generics.annotations.FieldBinaryMapping;
import at.fhj.mdd.ws2020.generics.annotations.MessageBinaryMapping;

@MessageBinaryMapping(totalSize = 24)
public class StatusMessage {
	@FieldBinaryMapping(offset = 0)
	private int speed;
	@FieldBinaryMapping(offset = 10)
	private double batteryVoltage;

	public StatusMessage(int speed, double batteryVoltage) {
		super();
		this.speed = speed;
		this.batteryVoltage = batteryVoltage;
	}

	// default constructor for reflection constructions
	public StatusMessage() {

	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public double getBatteryVoltage() {
		return batteryVoltage;
	}

	public void setBatteryVoltage(double batteryVoltage) {
		this.batteryVoltage = batteryVoltage;
	}

}
