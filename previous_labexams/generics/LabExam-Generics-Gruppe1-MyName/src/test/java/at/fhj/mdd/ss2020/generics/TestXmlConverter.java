package at.fhj.mdd.ss2020.generics;

import org.junit.Assert;
import org.junit.Test;

import at.fhj.mdd.ss2020.generics.model.AliveTelegram;
import at.fhj.mdd.ss2020.generics.model.TransportTelegram;

public class TestXmlConverter {
	private static final String TRANSPORT_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><TRANSPORT><BARCODE>4711</BARCODE><TARGET_ID>1234</TARGET_ID></TRANSPORT>";
	private static final String ALIVE_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><ALIVE/>";

	@Test
	public void testAliveToXML() {
		Assert.assertEquals(ALIVE_XML, new AliveXmlConverter().toXML(new AliveTelegram()));
	}

	@Test
	public void testTransportToXML() {
		Assert.assertEquals(TRANSPORT_XML, new TransportXmlConverter().toXML(new TransportTelegram("4711", 1234)));
	}
}
