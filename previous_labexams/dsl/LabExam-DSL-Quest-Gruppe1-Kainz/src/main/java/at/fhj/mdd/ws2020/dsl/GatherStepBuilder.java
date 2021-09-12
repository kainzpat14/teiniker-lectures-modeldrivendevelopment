package at.fhj.mdd.ws2020.dsl;

import at.fhj.mdd.ws2020.dsl.metamodel.MGatherStep;

public class GatherStepBuilder extends StepBuilder<MGatherStep> {

	public GatherStepBuilder(QuestBuilder parent, int count, String entity) {
		super(parent, count, entity);
	}

	@Override
	protected MGatherStep createStep(String shortDescription, String description, boolean optional, int count,
			String entity) {
		return new MGatherStep(shortDescription, description, optional, entity, count);
	}

}
