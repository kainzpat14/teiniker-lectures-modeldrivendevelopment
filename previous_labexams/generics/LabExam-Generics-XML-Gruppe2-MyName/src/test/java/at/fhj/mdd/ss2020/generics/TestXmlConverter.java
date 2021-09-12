package at.fhj.mdd.ss2020.generics;

import org.junit.Assert;
import org.junit.Test;

import at.fhj.mdd.ss2020.generics.model.AliveTelegram;
import at.fhj.mdd.ss2020.generics.model.TransportTelegram;

public class TestXmlConverter {
	private static final String TRANSPORT_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><TRANSPORT><BARCODE>4711</BARCODE><TARGET_ID>1234</TARGET_ID></TRANSPORT>";
	private static final String ALIVE_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><ALIVE/>";

	@Test
	public void testAliveFromXML() {
		AliveTelegram telegram = new AliveXmlConverter().fromXml(ALIVE_XML);
		Assert.assertNotNull(telegram);
	}

	@Test
	public void testTransportFromXML() {
		TransportTelegram telegram = new TransportXmlConverter().fromXml(TRANSPORT_XML);
		Assert.assertNotNull(telegram);
		Assert.assertEquals("4711", telegram.getBarcode());
		Assert.assertEquals(1234, telegram.getTargetId());
	}
}
