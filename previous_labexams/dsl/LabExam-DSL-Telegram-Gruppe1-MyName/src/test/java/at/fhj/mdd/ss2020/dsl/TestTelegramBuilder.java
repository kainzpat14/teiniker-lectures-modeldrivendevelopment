package at.fhj.mdd.ss2020.dsl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

import at.fhj.mdd.ss2020.dsl.metamodel.MIntField;
import at.fhj.mdd.ss2020.dsl.metamodel.MStringField;
import at.fhj.mdd.ss2020.dsl.metamodel.MTelegram;
import at.fhj.mdd.ss2020.dsl.metamodel.MTelegrams;

public class TestTelegramBuilder {

	@Test
	public void testBuilder() {
		// @formatter:off
		MTelegrams telegrams = new TelegramsBuilder()
				.inOutTelegram("Alive","ALIVE")
				.outTelegram("Transport","TRANSPORT")
					.stringField("barcode","BARCODE")
					.intField("target","TARGET")
				.inTelegram("TransportComplete","TRANSPORT_COMPLETE")
					.stringField("barcode","BARCODE")
					.intField("target","TARGET")
					.intField("status","STATUS")
			.toTelegrams();
		// @formatter:on

		assertGraph(telegrams);
	}

	@Test
	public void testObjectGraph() {
		MTelegrams telegrams = new MTelegrams();

		MTelegram aliveTelegram = new MTelegram("Alive", "ALIVE");

		MTelegram transportTelegram = new MTelegram("Transport", "TRANSPORT");
		transportTelegram.getFields().add(new MStringField("barcode", "BARCODE"));
		transportTelegram.getFields().add(new MIntField("target", "TARGET"));

		MTelegram transportCompleteTelegram = new MTelegram("TransportComplete", "TRANSPORT_COMPLETE");
		transportCompleteTelegram.getFields().add(new MStringField("barcode", "BARCODE"));
		transportCompleteTelegram.getFields().add(new MIntField("target", "TARGET"));
		transportCompleteTelegram.getFields().add(new MIntField("status", "STATUS"));

		telegrams.getInputTelegrams().add(aliveTelegram);
		telegrams.getInputTelegrams().add(transportCompleteTelegram);

		telegrams.getOutputTelegrams().add(aliveTelegram);
		telegrams.getOutputTelegrams().add(transportTelegram);

		assertGraph(telegrams);
	}

	private void assertGraph(MTelegrams telegrams) {
		String graph = new ModelToObjectDiagram().toDiagram(telegrams);

		System.out.println(graph);

		String expected = readExpectedFile();
		Assert.assertEquals(expected, graph);
	}

	private String readExpectedFile() {
		try {
			return new String(Files.readAllBytes(Paths.get(this.getClass().getClassLoader().getResource("expected.uml").toURI())));
		} catch (IOException | URISyntaxException e) {
			throw new RuntimeException("Error reading expected file", e);
		}
	}
}
