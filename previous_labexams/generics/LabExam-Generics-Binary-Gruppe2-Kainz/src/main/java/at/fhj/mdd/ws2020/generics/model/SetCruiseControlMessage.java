package at.fhj.mdd.ws2020.generics.model;

import at.fhj.mdd.ws2020.generics.annotations.FieldBinaryMapping;
import at.fhj.mdd.ws2020.generics.annotations.MessageBinaryMapping;

@MessageBinaryMapping(totalSize = 24)
public class SetCruiseControlMessage {
	@FieldBinaryMapping(offset = 0)
	private float minDistance;
	@FieldBinaryMapping(offset = 8)
	private int maxSpeed;

	public SetCruiseControlMessage(float minDistance, int maxSpeed) {
		super();
		this.minDistance = minDistance;
		this.maxSpeed = maxSpeed;
	}

	// default constructor for reflection constructions
	public SetCruiseControlMessage() {

	}

	public float getMinDistance() {
		return minDistance;
	}

	public void setMinDistance(float minDistance) {
		this.minDistance = minDistance;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

}
