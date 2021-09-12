package at.fhj.mdd.ws2020.dsl;

import java.util.ArrayList;
import java.util.List;

import at.fhj.mdd.ws2020.dsl.metamodel.MInstaller;
import at.fhj.mdd.ws2020.dsl.metamodel.MStep;

public class MainInstallerStepBuilder extends GeneralStepBuilder<MainInstallerStepBuilder> {

	private InstallerBuilder parent;
	private List<MStep> steps = new ArrayList<>();

	public MainInstallerStepBuilder(InstallerBuilder parent) {
		super();
		this.parent = parent;
	}

	public List<MStep> toSteps() {
		return steps;
	}

	@Override
	protected void addStep(MStep step) {
		steps.add(step);
	}

	@Override
	protected MainInstallerStepBuilder getObject() {
		return this;
	}

	public MainInstallerStepBuilder preSetup() {
		return parent.preSetup();
	}

	public BuildBuilder setup() {
		return parent.setup();
	}

	public MainInstallerStepBuilder cleanup() {
		return parent.cleanup();
	}

	public MInstaller toInstaller() {
		return parent.toInstaller();
	}

}
