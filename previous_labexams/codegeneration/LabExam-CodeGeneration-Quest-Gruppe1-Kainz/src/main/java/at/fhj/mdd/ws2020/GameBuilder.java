package at.fhj.mdd.ws2020;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import at.fhj.mdd.ws2020.metamodel.MGame;

public class GameBuilder {
	private List<QuestBuilder> quests = new ArrayList<>();

	public QuestBuilder quest(String shortDescription, String description) {
		QuestBuilder builder = new QuestBuilder(this, shortDescription, description);
		quests.add(builder);
		return builder;
	}

	public MGame toGame() {
		MGame game = new MGame();
		game.setQuests(quests.stream().map(QuestBuilder::toQuest).collect(Collectors.toList()));
		return game;
	}
}
