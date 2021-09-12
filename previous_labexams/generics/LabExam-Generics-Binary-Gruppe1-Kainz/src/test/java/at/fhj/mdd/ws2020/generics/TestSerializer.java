package at.fhj.mdd.ws2020.generics;

import org.junit.Assert;
import org.junit.Test;

import at.fhj.mdd.ws2020.generics.model.SetCruiseControlMessage;
import at.fhj.mdd.ws2020.generics.model.SetRadioStationMessage;
import at.fhj.mdd.ws2020.generics.model.StatusMessage;

public class TestSerializer {
	@Test
	public void testStatusMessageSerializer() {
		byte[] message = new StatusMessageSerializer().serialize(new StatusMessage(100, 9.0));
		Assert.assertArrayEquals(new byte[] { 0x00, 0x00, 0x00, 0x64, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x40, 0x22,
				0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 }, message);
	}

	@Test
	public void testStatusMessageCommonSerializer() {
		byte[] message = new MessageSerializer<StatusMessage>().serialize(new StatusMessage(100, 9.0));
		Assert.assertArrayEquals(new byte[] { 0x00, 0x00, 0x00, 0x64, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x40, 0x22,
				0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 }, message);
	}

	@Test
	public void testSetCruiseControlMessageCommonSerializer() {
		byte[] message = new MessageSerializer<SetCruiseControlMessage>()
				.serialize(new SetCruiseControlMessage(10.5f, 100));
		Assert.assertArrayEquals(new byte[] { 0x41, 0x28, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x64,
				0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 }, message);
	}

	@Test
	public void testSetRadioStatusCommonSerializer() {
		byte[] message = new MessageSerializer<SetRadioStationMessage>()
				.serialize(new SetRadioStationMessage("Rockstar Radio"));
		Assert.assertArrayEquals(new byte[] { 0x52, 0x6f, 0x63, 0x6b, 0x73, 0x74, 0x61, 0x72, 0x20, 0x52, 0x61, 0x64,
				0x69, 0x6f, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
				0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
				0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 }, message);
	}

	private void printMessage(byte[] message) {
		System.out.print("new byte[] {");
		boolean first = true;
		for (byte byt : message) {
			if (!first) {
				System.out.print(",");
			}
			first = false;
			System.out.print(String.format("0x%02x", byt));
		}
		System.out.println("}");
	}
}
