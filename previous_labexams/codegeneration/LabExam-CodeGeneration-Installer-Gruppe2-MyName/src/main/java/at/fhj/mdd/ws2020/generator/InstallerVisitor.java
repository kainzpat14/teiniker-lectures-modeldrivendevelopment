package at.fhj.mdd.ws2020.generator;

import at.fhj.mdd.ws2020.metamodel.MCopyStep;
import at.fhj.mdd.ws2020.metamodel.MCreateFolderStep;
import at.fhj.mdd.ws2020.metamodel.MInstaller;
import at.fhj.mdd.ws2020.metamodel.MInstallerStep;
import at.fhj.mdd.ws2020.metamodel.MOutputStep;
import at.fhj.mdd.ws2020.metamodel.MShellStep;
import at.fhj.mdd.ws2020.metamodel.MStep;

public interface InstallerVisitor {
	void visit(MInstaller installer);

	void visit(MInstallerStep installerStep);

	void visit(MStep step);

	void visit(MOutputStep step);

	void visit(MCreateFolderStep step);

	void visit(MShellStep step);

	void visit(MCopyStep step);
}
