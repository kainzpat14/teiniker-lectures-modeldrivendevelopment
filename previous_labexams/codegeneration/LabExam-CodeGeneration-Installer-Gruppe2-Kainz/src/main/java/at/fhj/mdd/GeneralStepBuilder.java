package at.fhj.mdd;

import at.fhj.mdd.metamodel.MCopyStep;
import at.fhj.mdd.metamodel.MCreateFolderStep;
import at.fhj.mdd.metamodel.MOutputStep;
import at.fhj.mdd.metamodel.MShellStep;
import at.fhj.mdd.metamodel.MStep;

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
