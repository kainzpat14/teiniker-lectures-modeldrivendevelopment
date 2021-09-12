package at.fhj.mdd.ws2020.generics;

import org.junit.Assert;
import org.junit.Test;

import at.fhj.mdd.ws2020.generics.model.ConnectionSettings;
import at.fhj.mdd.ws2020.generics.model.ServerSettings;

public class TestStorage {

	private static final String EXPECTED_CONNECTION = "" + //
			"[connection]\n" + //
			"serverAddress=192.168.1.1\n" + //
			"port=8080\n";

	private static final String EXPECTED_SERVER = "" + //
			"[server]\n" + //
			"bindAddress=0.0.0.0\n" + //
			"port=8080\n";

	@Test
	public void testClientSettingsSerializer() {
		String message = new ConnectionSettingsStorage().serialize(new ConnectionSettings("192.168.1.1", 8080));
		Assert.assertEquals(EXPECTED_CONNECTION, normalize(message));
	}

	@Test
	public void testClientSettingsGenericSerializer() {
		String message = new SettingsStorage<ConnectionSettings>()
				.serialize(new ConnectionSettings("192.168.1.1", 8080));
		Assert.assertEquals(EXPECTED_CONNECTION, normalize(message));
	}

	@Test
	public void testServerSettingsGenericSerializer() {
		String message = new SettingsStorage<ServerSettings>().serialize(new ServerSettings("0.0.0.0", 8080));
		Assert.assertEquals(EXPECTED_SERVER, normalize(message));
	}

	private String normalize(String message) {
		return message.replace("\r", "");
	}

}
