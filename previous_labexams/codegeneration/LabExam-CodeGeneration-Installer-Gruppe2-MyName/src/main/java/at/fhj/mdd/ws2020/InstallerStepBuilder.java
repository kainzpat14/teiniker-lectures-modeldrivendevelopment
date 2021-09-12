package at.fhj.mdd.ws2020;

import at.fhj.mdd.ws2020.metamodel.MInstallerStep;
import at.fhj.mdd.ws2020.metamodel.MStep;

public class InstallerStepBuilder {
	private MStep installStep;
	private SingleStepBuilder<BuildBuilder> cleanupStep;
	private BuildBuilder parent;

	public InstallerStepBuilder(BuildBuilder parent, MStep installStep) {
		super();
		this.installStep = installStep;
		this.parent = parent;
	}

	public SingleStepBuilder<BuildBuilder> cleanup() {
		cleanupStep = new SingleStepBuilder<BuildBuilder>(parent);
		return cleanupStep;
	}

	public MInstallerStep toInstallerStep() {
		return new MInstallerStep(installStep, cleanupStep.getStep());
	}

}
