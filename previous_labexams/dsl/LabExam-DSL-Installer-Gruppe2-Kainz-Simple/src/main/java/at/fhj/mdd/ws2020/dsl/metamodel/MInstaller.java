package at.fhj.mdd.ws2020.dsl.metamodel;

import java.util.ArrayList;
import java.util.List;

public class MInstaller {
	private List<MStep> preSetupSteps = new ArrayList<>();
	private List<MInstallerStep> setupSteps = new ArrayList<>();
	private List<MStep> cleanupSteps = new ArrayList<>();

	public List<MStep> getPreSetupSteps() {
		return preSetupSteps;
	}

	public void setPreSetupSteps(List<MStep> preSetupSteps) {
		this.preSetupSteps = preSetupSteps;
	}

	public List<MInstallerStep> getSetupSteps() {
		return setupSteps;
	}

	public void setSetupSteps(List<MInstallerStep> setupSteps) {
		this.setupSteps = setupSteps;
	}

	public List<MStep> getCleanupSteps() {
		return cleanupSteps;
	}

	public void setCleanupSteps(List<MStep> cleanupSteps) {
		this.cleanupSteps = cleanupSteps;
	}

}
