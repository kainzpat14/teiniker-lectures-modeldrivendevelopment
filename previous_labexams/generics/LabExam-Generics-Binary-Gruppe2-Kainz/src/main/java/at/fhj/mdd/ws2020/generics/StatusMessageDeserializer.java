package at.fhj.mdd.ws2020.generics;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import at.fhj.mdd.ws2020.generics.model.StatusMessage;

public class StatusMessageDeserializer {
	public StatusMessage deserialize(byte[] buffer) {
		ByteBuffer readBuffer = getValidatedBuffer(buffer, 24);
		int speed = (int) read(readBuffer, 0, SerializationType.INT);
		double batteryVoltage = (double) read(readBuffer, 10, SerializationType.DOUBLE);
		return new StatusMessage(speed, batteryVoltage);
	}

	private ByteBuffer getValidatedBuffer(byte[] buffer, int size) {
		validateLength(buffer, size);
		ByteBuffer readBuffer = ByteBuffer.wrap(buffer, 0, size);
		readBuffer.order(ByteOrder.BIG_ENDIAN);
		return readBuffer;
	}

	private Object read(ByteBuffer buffer, int offset, SerializationType type) {
		switch (type) {
		case INT:
			return buffer.getInt(offset);
		case LONG:
			return buffer.getLong(offset);
		case FLOAT:
			return buffer.getFloat(offset);
		case DOUBLE:
			return buffer.getDouble(offset);
		case STRING:
			return readString(buffer, offset);
		default:
			throw new UnsupportedOperationException("Invalid serialization type: " + type);
		}
	}

	private String readString(ByteBuffer buffer, int offset) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		for (int i = offset; i < buffer.capacity(); i++) {
			byte byt = buffer.get(i);
			if (byt == 0) {
				break;
			}
			stream.write(byt);

		}
		return new String(stream.toByteArray());
	}

	private void validateLength(byte[] buffer, int expected) {
		if (buffer.length < expected) {
			throw new IllegalArgumentException(
					"Invalid buffer size: " + buffer.length + " minimum expected: " + expected);
		}
	}
}
