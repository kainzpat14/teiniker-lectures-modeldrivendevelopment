package at.fhj.mdd.ws2020.dsl.builder;

import at.fhj.mdd.ws2020.dsl.metamodel.MCopyStep;
import at.fhj.mdd.ws2020.dsl.metamodel.MCreateFolderStep;
import at.fhj.mdd.ws2020.dsl.metamodel.MInstaller;
import at.fhj.mdd.ws2020.dsl.metamodel.MInstallerStep;

public class SetupBuilder {
    private InstallerBuilder parent;
    private MInstaller installer;

    public SetupBuilder(InstallerBuilder installerBuilder, MInstaller installer) {
        this.parent = installerBuilder;
        this.installer = installer;
    }


    public InstallStepBuilder mkdir(String path) {
        MInstallerStep step = new MInstallerStep(new MCreateFolderStep(path), null);
        installer.getSetupSteps().add(step);
        return new InstallStepBuilder(this, step);
    }

    public InstallStepBuilder copy(String source, String target) {
        MInstallerStep step = new MInstallerStep(new MCopyStep(source,target), null);
        installer.getSetupSteps().add(step);
        return new InstallStepBuilder(this, step);
    }

    public CleanupBuilder cleanup() {
        return parent.cleanup();
    }
}
