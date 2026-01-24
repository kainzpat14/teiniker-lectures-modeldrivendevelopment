package at.fhj.mdd.generator;

import at.fhj.mdd.metamodel.MCopyStep;
import at.fhj.mdd.metamodel.MCreateFolderStep;
import at.fhj.mdd.metamodel.MInstaller;
import at.fhj.mdd.metamodel.MInstallerStep;
import at.fhj.mdd.metamodel.MOutputStep;
import at.fhj.mdd.metamodel.MShellStep;
import at.fhj.mdd.metamodel.MStep;

public interface InstallerVisitor {
	void visit(MInstaller installer);

	void visit(MInstallerStep installerStep);

	void visit(MStep step);

	void visit(MOutputStep step);

	void visit(MCreateFolderStep step);

	void visit(MShellStep step);

	void visit(MCopyStep step);
}
