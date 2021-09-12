package at.fhj.mdd.ws2020.metamodel;

public class MInstallerStep {
	private MStep installStep;
	private MStep cleanupStep;

	public MInstallerStep(MStep installStep, MStep cleanupStep) {
		super();
		this.installStep = installStep;
		this.cleanupStep = cleanupStep;
	}

	public MStep getInstallStep() {
		return installStep;
	}

	public void setInstallStep(MStep installStep) {
		this.installStep = installStep;
	}

	public MStep getCleanupStep() {
		return cleanupStep;
	}

	public void setCleanupStep(MStep cleanupStep) {
		this.cleanupStep = cleanupStep;
	}

}
