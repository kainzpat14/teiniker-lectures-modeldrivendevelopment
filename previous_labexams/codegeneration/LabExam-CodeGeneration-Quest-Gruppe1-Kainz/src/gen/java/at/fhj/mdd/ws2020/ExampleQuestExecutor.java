package at.fhj.mdd.ws2020;

import at.fhj.mdd.ws2020.game.Player;
import at.fhj.mdd.ws2020.game.QuestExecutor;

public class ExampleQuestExecutor implements QuestExecutor {

	@Override
	public void executeQuest(Player player) {
		player.startQuest("Rescue the princess", "The princess has been kidnapped to a tower, save her");
		player.logStep("Find the key", "There must be a key for the tower somewhere, find it");
		player.gather("key", 1);
		player.logStep("Kill the ghost", "A ghost stands between you and the princess, kill it!");
		player.kill("ghost", 1);
		player.logStep("Protect the princess on her way home", "The way home is dangerous, protect the princess on it");
		player.protect("princess", 1);
		player.endQuest("Rescue the princess");
	}

}
