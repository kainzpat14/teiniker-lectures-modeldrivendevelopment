package at.fhj.mdd.ws2020;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import at.fhj.mdd.ws2020.metamodel.MGame;
import at.fhj.mdd.ws2020.metamodel.MQuest;

public class QuestBuilder {
	private List<StepBuilder<?>> steps = new ArrayList<>();
	private String shortDescription;
	private String description;
	private GameBuilder parent;

	public QuestBuilder(GameBuilder parent, String shortDescription, String description) {
		this.parent = parent;
		this.shortDescription = shortDescription;
		this.description = description;
	}

	public KillStepBuilder kill(int count, String entity) {
		KillStepBuilder builder = new KillStepBuilder(this, count, entity);
		steps.add(builder);
		return builder;
	}

	public ProtectStepBuilder protect(int count, String entity) {
		ProtectStepBuilder builder = new ProtectStepBuilder(this, count, entity);
		steps.add(builder);
		return builder;
	}

	public GatherStepBuilder gather(int count, String entity) {
		GatherStepBuilder builder = new GatherStepBuilder(this, count, entity);
		steps.add(builder);
		return builder;
	}

	public MQuest toQuest() {
		MQuest quest = new MQuest(shortDescription, description);
		quest.setSteps(steps.stream().map(StepBuilder::toStep).collect(Collectors.toList()));
		return quest;
	}

	public QuestBuilder quest(String shortDescription, String description) {
		return parent.quest(shortDescription, description);
	}

	public MGame toGame() {
		return parent.toGame();
	}

}
