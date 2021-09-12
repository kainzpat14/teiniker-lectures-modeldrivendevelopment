package at.fhj.mdd.ws2020.generator;

import org.junit.Assert;
import org.junit.Test;

import at.fhj.mdd.ws2020.GameBuilder;
import at.fhj.mdd.ws2020.HealThePrincessQuestExecutor;
import at.fhj.mdd.ws2020.game.VirtualPlayer;
import at.fhj.mdd.ws2020.metamodel.MGame;

public class TestGenerator {

	// @formatter:off
	private static final String EXPECTED_OUTPUT = ""+
			"Starting Quest Heal the princess\n" + 
			"Performing step Gather herbs for the antidote\n" + 
			"Gathering 10 of Herbs\n" + 
			"Performing step Slay the monster\n" + 
			"Killing 1 of Monster\n" + 
			"Performing step Protect the sage\n" + 
			"Protecting 1 of Sage\n" + 
			"Quest Heal the princess finished\n";
	// @formatter:on

	@Test
	public void testGenerator() {
		// @formatter:off
		MGame game = new GameBuilder()
				.quest("Heal the princess", "The princess has been poisened, save her")
					.gather(10, "Herbs")
						.shortDescription("Gather herbs for the antidote")
						.description("Thankfully the sage knows how to brew an antidote, for this he needs herbs!")
					.kill(1, "Monster")
					 	.shortDescription("Slay the monster")
					 	.description("A monster is attacking the sage, slay it!")
					.protect(1, "Sage")
						.shortDescription("Protect the sage")
						.description("More monsters are on their way, protect the sage while he brews the elixir")
					.toGame();
		// @formatter:on
		new QuestExecutorGeneratorVisitor().visit(game);
	}

	@Test
	public void testGeneratedExecutor() {
		VirtualPlayer player = new VirtualPlayer();
		new HealThePrincessQuestExecutor().executeQuest(player);
		Assert.assertEquals(normalize(EXPECTED_OUTPUT), normalize(player.getOutput()));
	}

	private String normalize(String text) {
		return text.trim().replaceAll("\r", "");
	}

}
