package at.fhj.mdd.ws2020.dsl.builder;

import at.fhj.mdd.ws2020.dsl.metamodel.MInstaller;

public class InstallerBuilder {
    private MInstaller installer = new MInstaller();
    public PreSetupBuilder preSetup() {
        return new PreSetupBuilder(this,installer);
    }

    public SetupBuilder setup() {
        return new SetupBuilder(this,installer);
    }

    public CleanupBuilder cleanup() {
        return new CleanupBuilder(this,installer);
    }

    public MInstaller toInstaller() {
        return installer;
    }
}
