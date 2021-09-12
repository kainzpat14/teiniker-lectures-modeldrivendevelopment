package at.fhj.mdd.ws2020.generics;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import at.fhj.mdd.ws2020.generics.model.StatusMessage;

public class StatusMessageSerializer {
	public byte[] serialize(StatusMessage message) {
		ByteBuffer buffer = allocate(24);
		writeToBuffer(buffer, 0, SerializationType.INT, message.getSpeed());
		writeToBuffer(buffer, 10, SerializationType.DOUBLE, message.getBatteryVoltage());
		return buffer.array();
	}

	private ByteBuffer allocate(int size) {
		ByteBuffer buffer = ByteBuffer.allocate(size);
		buffer.order(ByteOrder.BIG_ENDIAN);
		return buffer;
	}

	private void writeToBuffer(ByteBuffer buffer, int offset, SerializationType type, Object value) {
		switch (type) {
		case INT:
			buffer.putInt(offset, (int) value);
			break;
		case LONG:
			buffer.putLong(offset, (long) value);
			break;
		case FLOAT:
			buffer.putFloat(offset, (float) value);
			break;
		case DOUBLE:
			buffer.putDouble(offset, (double) value);
			break;
		case STRING:
			buffer.put(offset, ((String) value).getBytes());
			break;
		default:
			throw new UnsupportedOperationException("Invalid serialization type: " + type);
		}
	}

}
