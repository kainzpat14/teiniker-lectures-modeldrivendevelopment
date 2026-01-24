package at.fhj.mdd.dsl.builder;

import at.fhj.mdd.dsl.metamodel.MInstallerStep;
import at.fhj.mdd.dsl.metamodel.MShellStep;

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
