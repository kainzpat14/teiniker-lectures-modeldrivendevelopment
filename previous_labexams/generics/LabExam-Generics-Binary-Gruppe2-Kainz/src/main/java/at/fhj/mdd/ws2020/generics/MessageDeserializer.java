package at.fhj.mdd.ws2020.generics;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class MessageDeserializer<T> {

	private Class<T> clazz;

	public MessageDeserializer(Class<T> clazz) {
		this.clazz = clazz;
	}

	public T deserialize(byte[] buffer) {
		try {
			ByteBuffer readBuffer = getValidatedBuffer(buffer, ReflectionUtil.getMessageSize(clazz));
			T instance = clazz.getConstructor().newInstance();
			for (Field field : ReflectionUtil.getReadableSortedFields(clazz)) {
				field.set(instance, read(readBuffer, ReflectionUtil.getOffset(field), ReflectionUtil.getType(field)));
			}
			return instance;
		} catch (IllegalAccessException | InstantiationException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException ex) {
			throw new RuntimeException(ex);
		}
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
