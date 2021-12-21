package at.fhj.mdd.ss2020.generator;

import at.fhj.mdd.ss2020.metamodel.MCronTrigger;
import at.fhj.mdd.ss2020.metamodel.MJob;
import at.fhj.mdd.ss2020.metamodel.MJobTrigger;
import at.fhj.mdd.ss2020.metamodel.MMailTask;
import at.fhj.mdd.ss2020.metamodel.MMavenTask;
import at.fhj.mdd.ss2020.metamodel.MShellTask;
import at.fhj.mdd.ss2020.metamodel.MTask;
import at.fhj.mdd.ss2020.metamodel.MTrigger;
import at.fhj.mdd.ss2020.metamodel.MVersioningTrigger;

public interface JobVisitor {
	void visit(MJob job);

	void visit(MTrigger trigger);

	void visit(MVersioningTrigger trigger);

	void visit(MCronTrigger trigger);

	void visit(MJobTrigger trigger);

	void visit(MTask task);

	void visit(MShellTask task);

	void visit(MMavenTask task);

	void visit(MMailTask task);
}
