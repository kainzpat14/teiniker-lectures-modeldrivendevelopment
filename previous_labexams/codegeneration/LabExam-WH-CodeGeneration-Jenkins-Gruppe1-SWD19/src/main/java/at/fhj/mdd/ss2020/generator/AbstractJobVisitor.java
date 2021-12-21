package at.fhj.mdd.ss2020.generator;

import at.fhj.mdd.ss2020.metamodel.*;

import java.util.List;

public abstract class AbstractJobVisitor implements JobVisitor {

    @Override
    public void visit(MTrigger trigger) {
        if (trigger instanceof MCronTrigger) {
            visit((MCronTrigger) trigger);
        } else if (trigger instanceof MJobTrigger) {
            visit((MJobTrigger) trigger);
        } else if (trigger instanceof MVersioningTrigger) {
            visit((MVersioningTrigger) trigger);
        }
    }

    @Override
    public void visit(MTask task) {
        if (task instanceof MMavenTask) {
            visit((MMavenTask) task);
        } else if (task instanceof MMailTask) {
            visit((MMailTask) task);
        } else if (task instanceof MShellTask) {
            visit((MShellTask) task);
        }
    }

    protected void visitPreBuildTasks(MJob job) {
        List<MPreBuildTask> preBuildTasks = job.getPreBuildTasks();

        for (MPreBuildTask preBuildTask : preBuildTasks) {
            visit(preBuildTask);
        }
    }

    protected void visitBuildTasks(MJob job) {
        List<MBuildTask> buildTasks = job.getBuildTasks();

        for (MBuildTask buildTask : buildTasks) {
            visit(buildTask);
        }
    }

    protected void visitPostBuildTasks(MJob job) {
        List<MPostBuildTask> postBuildTasks = job.getPostBuildTasks();

        for (MPostBuildTask postBuildTask : postBuildTasks) {
            visit(postBuildTask);
        }
    }
}
