package at.fhj.mdd.ws2020.generics;

import org.junit.Assert;
import org.junit.Test;

import at.fhj.mdd.ws2020.generics.model.ClientSettings;
import at.fhj.mdd.ws2020.generics.model.ServerSettings;

public class TestSerializer {

	private static final String EXPECTED_CLIENT = "" + //
			"client:\n" + //
			" - serverAddress: 10.0.0.138\n" + //
			" - port: 8080\n";

	private static final String EXPECTED_SERVER = "" + //
			"server:\n" + //
			" - bindAddress: 0.0.0.0\n" + //
			" - port: 8080\n";

	@Test
	public void testClientSettingsSerializer() {
		String message = new ClientSettingsSerializer().serialize(new ClientSettings("10.0.0.138", 8080));
		Assert.assertEquals(EXPECTED_CLIENT, normalize(message));
	}

	@Test
	public void testClientSettingsGenericSerializer() {
		String message = new SettingsSerializer<ClientSettings>().serialize(new ClientSettings("10.0.0.138", 8080));
		Assert.assertEquals(EXPECTED_CLIENT, normalize(message));
	}

	@Test
	public void testServerSettingsGenericSerializer() {
		String message = new SettingsSerializer<ServerSettings>().serialize(new ServerSettings("0.0.0.0", 8080));
		Assert.assertEquals(EXPECTED_SERVER, normalize(message));
	}

	private String normalize(String message) {
		return message.replace("\r", "");
	}

}
