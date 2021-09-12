package at.fhj.mdd.ws2020.generics;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class MessageSerializer<T> {
	public byte[] serialize(T message) {
		try {
			ByteBuffer buffer = allocate(ReflectionUtil.getMessageSize(message.getClass()));
			for (Field field : ReflectionUtil.getReadableSortedFields(message.getClass())) {
				writeToBuffer(buffer, ReflectionUtil.getOffset(field), ReflectionUtil.getType(field),
						field.get(message));
			}
			return buffer.array();
		} catch (IllegalAccessException ex) {
			throw new RuntimeException(ex);
		}
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
