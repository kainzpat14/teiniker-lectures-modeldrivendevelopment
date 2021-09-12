package at.fhj.mdd.ws2020;

import at.fhj.mdd.ws2020.metamodel.MKillStep;

public class KillStepBuilder extends StepBuilder<MKillStep> {

	public KillStepBuilder(QuestBuilder parent, int count, String entity) {
		super(parent, count, entity);
	}

	@Override
	protected MKillStep createStep(String shortDescription, String description, boolean optional, int count,
			String entity) {
		return new MKillStep(shortDescription, description, optional, entity, count);
	}

}
