package at.fhj.mdd.ws2020.dsl;

import at.fhj.mdd.ws2020.dsl.metamodel.MCopyStep;
import at.fhj.mdd.ws2020.dsl.metamodel.MCreateFolderStep;
import at.fhj.mdd.ws2020.dsl.metamodel.MOutputStep;
import at.fhj.mdd.ws2020.dsl.metamodel.MShellStep;
import at.fhj.mdd.ws2020.dsl.metamodel.MStep;

public abstract class GeneralStepBuilder<T> {
	protected abstract void addStep(MStep step);

	protected abstract T getObject();

	public T copy(String source, String destination) {
		MCopyStep step = new MCopyStep(source, destination);
		addStep(step);
		return getObject();
	}

	public T execute(String script) {
		MShellStep step = new MShellStep(script);
		addStep(step);
		return getObject();
	}

	public T mkdir(String folder) {
		MCreateFolderStep step = new MCreateFolderStep(folder);
		addStep(step);
		return getObject();
	}

	public T print(String header, String text) {
		MOutputStep step = new MOutputStep(header, text);
		addStep(step);
		return getObject();
	}
}
