package at.fhj.mdd.generator;

import at.fhj.mdd.metamodel.MCopyStep;
import at.fhj.mdd.metamodel.MCreateFolderStep;
import at.fhj.mdd.metamodel.MInstaller;
import at.fhj.mdd.metamodel.MInstallerStep;
import at.fhj.mdd.metamodel.MOutputStep;
import at.fhj.mdd.metamodel.MShellStep;
import at.fhj.mdd.metamodel.MStep;

public abstract class AbstractInstallerVisitor implements InstallerVisitor {

	@Override
	public void visit(MInstaller installer) {
		for (MStep step : installer.getPreSetupSteps()) {
			visit(step);
		}
		for (MInstallerStep step : installer.getSetupSteps()) {
			visit(step);
		}
		for (MStep step : installer.getCleanupSteps()) {
			visit(step);
		}
	}

	@Override
	public void visit(MInstallerStep installerStep) {
		visit(installerStep.getInstallStep());
		visit(installerStep.getCleanupStep());
	}

	@Override
	public void visit(MStep step) {
		if (step instanceof MOutputStep) {
			visit((MOutputStep) step);
		} else if (step instanceof MCreateFolderStep) {
			visit((MCreateFolderStep) step);
		} else if (step instanceof MShellStep) {
			visit((MShellStep) step);
		} else if (step instanceof MCopyStep) {
			visit((MCopyStep) step);
		} else {
			throw new IllegalArgumentException("Invalid step class " + step.getClass().getName());
		}
	}

	@Override
	public void visit(MOutputStep step) {

	}

	@Override
	public void visit(MCreateFolderStep step) {

	}

	@Override
	public void visit(MShellStep step) {

	}

	@Override
	public void visit(MCopyStep step) {

	}

}
