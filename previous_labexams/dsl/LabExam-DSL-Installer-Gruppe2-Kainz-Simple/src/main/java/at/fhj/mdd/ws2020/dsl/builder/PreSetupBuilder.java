package at.fhj.mdd.ws2020.dsl.builder;

import at.fhj.mdd.ws2020.dsl.metamodel.MInstaller;
import at.fhj.mdd.ws2020.dsl.metamodel.MOutputStep;
import at.fhj.mdd.ws2020.dsl.metamodel.MShellStep;

public class PreSetupBuilder {
    private InstallerBuilder parent;
    private MInstaller installer;

    public PreSetupBuilder(InstallerBuilder installerBuilder, MInstaller installer) {
        this.parent = installerBuilder;
        this.installer = installer;
    }

    public PreSetupBuilder print(String title, String text) {
        installer.getPreSetupSteps().add(new MOutputStep(title, text));
        return this;
    }

    public PreSetupBuilder execute(String shellScript) {
        installer.getPreSetupSteps().add(new MShellStep(shellScript));
        return this;
    }

    public SetupBuilder setup() {
        return parent.setup();
    }
}
