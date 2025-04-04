package at.fhj.mdd.ws2020.dsl.builder;

import at.fhj.mdd.ws2020.dsl.metamodel.MInstallerStep;

public class InstallStepBuilder {
    private SetupBuilder parent;
    private MInstallerStep step;

    public InstallStepBuilder(SetupBuilder setupBuilder, MInstallerStep step) {
        this.parent = setupBuilder;
        this.step = step;
    }


    public StepCleanupBuilder cleanup() {
        return new StepCleanupBuilder(parent,step);
    }
}
