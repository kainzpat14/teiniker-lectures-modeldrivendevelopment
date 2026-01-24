package at.fhj.mdd.dsl;

import at.fhj.mdd.dsl.metamodel.MProtectStep;

public class ProtectStepBuilder extends StepBuilder<MProtectStep> {

	public ProtectStepBuilder(QuestBuilder parent, int count, String entity) {
		super(parent, count, entity);
	}

	@Override
	protected MProtectStep createStep(String shortDescription, String description, boolean optional, int count,
			String entity) {
		return new MProtectStep(shortDescription, description, optional, entity, count);
	}

}
