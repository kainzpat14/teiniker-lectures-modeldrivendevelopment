package at.fhj.mdd.ss2020.generator;

import at.fhj.mdd.ss2020.metamodel.MBuildTask;
import at.fhj.mdd.ss2020.metamodel.MCronTrigger;
import at.fhj.mdd.ss2020.metamodel.MJob;
import at.fhj.mdd.ss2020.metamodel.MJobTrigger;
import at.fhj.mdd.ss2020.metamodel.MMailTask;
import at.fhj.mdd.ss2020.metamodel.MMavenTask;
import at.fhj.mdd.ss2020.metamodel.MPostBuildTask;
import at.fhj.mdd.ss2020.metamodel.MPreBuildTask;
import at.fhj.mdd.ss2020.metamodel.MShellTask;
import at.fhj.mdd.ss2020.metamodel.MTask;
import at.fhj.mdd.ss2020.metamodel.MTrigger;
import at.fhj.mdd.ss2020.metamodel.MVersioningTrigger;

public abstract class AbstractJobVisitor implements JobVisitor {

	@Override
	public void visit(MJob job) {
		visit(job.getTrigger());
		visitPre(job);
		visitBuild(job);
		visitPost(job);
	}

	protected void visitPost(MJob job) {
		for (MPostBuildTask task : job.getPostBuildTasks()) {
			visit(task);
		}
	}

	protected void visitBuild(MJob job) {
		for (MBuildTask task : job.getBuildTasks()) {
			visit(task);
		}
	}

	protected void visitPre(MJob job) {
		for (MPreBuildTask task : job.getPreBuildTasks()) {
			visit(task);
		}
	}

	@Override
	public void visit(MTrigger trigger) {
		if (trigger instanceof MCronTrigger) {
			visit((MCronTrigger) trigger);
		} else if (trigger instanceof MJobTrigger) {
			visit((MJobTrigger) trigger);
		} else if (trigger instanceof MVersioningTrigger) {
			visit((MVersioningTrigger) trigger);
		} else {
			throw new UnsupportedOperationException("Invalid trigger type: " + trigger.getClass().getName());
		}
	}

	@Override
	public void visit(MVersioningTrigger trigger) {

	}

	@Override
	public void visit(MCronTrigger trigger) {

	}

	@Override
	public void visit(MJobTrigger trigger) {

	}

	@Override
	public void visit(MTask task) {
		if (task instanceof MShellTask) {
			visit((MShellTask) task);
		} else if (task instanceof MMailTask) {
			visit((MMailTask) task);
		} else if (task instanceof MMavenTask) {
			visit((MMavenTask) task);
		} else {
			throw new UnsupportedOperationException("Invalid task type: " + task.getClass().getName());
		}
	}

	@Override
	public void visit(MShellTask task) {

	}

	@Override
	public void visit(MMavenTask task) {

	}

	@Override
	public void visit(MMailTask task) {

	}

}
