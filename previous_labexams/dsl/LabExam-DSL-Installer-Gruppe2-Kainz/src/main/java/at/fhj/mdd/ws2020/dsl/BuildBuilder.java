package at.fhj.mdd.ws2020.dsl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import at.fhj.mdd.ws2020.dsl.metamodel.MInstaller;
import at.fhj.mdd.ws2020.dsl.metamodel.MInstallerStep;
import at.fhj.mdd.ws2020.dsl.metamodel.MStep;

public class BuildBuilder extends GeneralStepBuilder<InstallerStepBuilder> {

	private InstallerBuilder parent;
	private List<InstallerStepBuilder> installerSteps = new ArrayList<>();

	public BuildBuilder(InstallerBuilder parent) {
		super();
		this.parent = parent;
	}

	@Override
	protected void addStep(MStep step) {
		installerSteps.add(new InstallerStepBuilder(this, step));
	}

	@Override
	protected InstallerStepBuilder getObject() {
		return installerSteps.get(installerSteps.size() - 1);
	}

	public List<MInstallerStep> toSteps() {
		return installerSteps.stream().map(InstallerStepBuilder::toInstallerStep).collect(Collectors.toList());
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
