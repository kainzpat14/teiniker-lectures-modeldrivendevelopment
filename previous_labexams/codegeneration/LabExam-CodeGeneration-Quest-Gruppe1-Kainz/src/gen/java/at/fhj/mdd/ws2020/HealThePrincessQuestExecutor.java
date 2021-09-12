package at.fhj.mdd.ws2020;

import at.fhj.mdd.ws2020.game.Player;
import at.fhj.mdd.ws2020.game.QuestExecutor;

public class HealThePrincessQuestExecutor implements QuestExecutor {

	@Override
	public void executeQuest(Player player) {
		player.startQuest("Heal the princess","The princess has been poisened, save her");
		player.logStep("Gather herbs for the antidote","Thankfully the sage knows how to brew an antidote, for this he needs herbs!");
		player.gather("Herbs",10);
		player.logStep("Slay the monster","A monster is attacking the sage, slay it!");
		player.kill("Monster",1);
		player.logStep("Protect the sage","More monsters are on their way, protect the sage while he brews the elixir");
		player.protect("Sage",1);
		player.endQuest("Heal the princess");
	}
}
