package at.fhj.mdd.ws2020.dsl;

import at.fhj.mdd.ws2020.dsl.metamodel.MGame;
import at.fhj.mdd.ws2020.dsl.metamodel.MNumberedEntityStep;
import at.fhj.mdd.ws2020.dsl.metamodel.MQuest;

public abstract class StepBuilder<T extends MNumberedEntityStep> {
	private int count;
	private String entity;
	private String shortDescription;
	private String description;
	private boolean optional = false;
	private QuestBuilder parent;

	public StepBuilder(QuestBuilder parent, int count, String entity) {
		super();
		this.count = count;
		this.entity = entity;
		this.parent = parent;
	}

	public StepBuilder<T> shortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
		return this;
	}

	public StepBuilder<T> description(String description) {
		this.description = description;
		return this;
	}

	protected abstract T createStep(String shortDescription, String description, boolean optional, int count,
			String entity);

	public T toStep() {
		return createStep(shortDescription, description, optional, count, entity);
	}

	public KillStepBuilder kill(int count, String entity) {
		return parent.kill(count, entity);
	}

	public ProtectStepBuilder protect(int count, String entity) {
		return parent.protect(count, entity);
	}

	public GatherStepBuilder gather(int count, String entity) {
		return parent.gather(count, entity);
	}

	public MQuest toQuest() {
		return parent.toQuest();
	}

	public QuestBuilder quest(String shortDescription, String description) {
		return parent.quest(shortDescription, description);
	}

	public MGame toGame() {
		return parent.toGame();
	}

}
