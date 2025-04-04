package at.fhj.mdd.ws2020.dsl.builder;

import at.fhj.mdd.ws2020.dsl.metamodel.MInstallerStep;
import at.fhj.mdd.ws2020.dsl.metamodel.MShellStep;

public class StepCleanupBuilder {
    private MInstallerStep step;
    private SetupBuilder parent;

    public StepCleanupBuilder(SetupBuilder setupBuilder, MInstallerStep step) {
        this.parent = setupBuilder;
        this.step = step;
    }


    public SetupBuilder execute(String shellScripts) {
        step.setCleanupStep(new MShellStep(shellScripts));
        return parent;
    }
}
