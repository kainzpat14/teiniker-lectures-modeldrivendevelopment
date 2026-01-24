package at.fhj.mdd.generator;

import at.fhj.mdd.metamodel.MCronTrigger;
import at.fhj.mdd.metamodel.MJob;
import at.fhj.mdd.metamodel.MJobTrigger;
import at.fhj.mdd.metamodel.MMailTask;
import at.fhj.mdd.metamodel.MMavenTask;
import at.fhj.mdd.metamodel.MShellTask;
import at.fhj.mdd.metamodel.MTask;
import at.fhj.mdd.metamodel.MTrigger;
import at.fhj.mdd.metamodel.MVersioningTrigger;

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
