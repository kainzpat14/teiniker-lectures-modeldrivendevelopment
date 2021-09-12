package at.fhj.mdd.ws2020.generator;

import org.junit.Test;

import at.fhj.mdd.ws2020.GameBuilder;
import at.fhj.mdd.ws2020.metamodel.MGame;

public class TestGenerator {

	@Test
	public void testGenerator() {
		// @formatter:off
		MGame game = new GameBuilder()
				.item("Lighter","Used to set fire to things")
				.item("Trap Door Key","Used to open the trap door in the attic")
				.room("Attic","You look around and find yourself in what looks like an attic, "
						+ "light enters the room via holes in the roof and the entire room is covered in dust. "
						+ "In the middle of the room there is a candle and a trap door is on the floor.")
					.object("Candle","A large candle stands in the middle of the room")
						.interaction("Light","Light the candle")
							.requires(1,"Lighter")
							.text("The candle throws light around the room. In one of the corners you see a key.")
					.object("Trap door", "A trap door")
						.interaction("Open","Open the trap door")
							.requires(1,"Trap Door Key")
							.text("The trap door opens and you go down to a different room")
							.transport("Hall")
					.object("Key","A rusty key")
						.interaction("Pick Up", "Pick up the key")
							.add(1, "Trap Door Key")
				.room("Hall","You find yourself in a corridor with two doors at either end and a drap door above you.")
					.object("Trap Door","The trap door you just came through")
						.interaction("Climp", "Climp thorugh the trap door")
							.transport("Attic")
				.toGame();	
		// @formatter:on
		new GameGeneratorVisitor().visit(game);
	}

}
