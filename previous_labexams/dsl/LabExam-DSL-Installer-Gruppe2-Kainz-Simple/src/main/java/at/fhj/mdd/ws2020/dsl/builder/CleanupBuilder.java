package at.fhj.mdd.ws2020.dsl.builder;

import at.fhj.mdd.ws2020.dsl.metamodel.MInstaller;
import at.fhj.mdd.ws2020.dsl.metamodel.MOutputStep;
import at.fhj.mdd.ws2020.dsl.metamodel.MShellStep;

public class CleanupBuilder {
    private MInstaller installer;
    private InstallerBuilder parent;

    public CleanupBuilder(InstallerBuilder installerBuilder, MInstaller installer) {
        this.parent = installerBuilder;
        this.installer = installer;
    }


    public CleanupBuilder execute(String shellScript) {
        installer.getCleanupSteps().add(new MShellStep(shellScript));
        return this;
    }

    public CleanupBuilder print(String title, String text) {
        installer.getCleanupSteps().add(new MOutputStep(title,text));
        return this;
    }

    public MInstaller toInstaller() {
        return parent.toInstaller();
    }
}
