package at.fhj.mdd.dsl;

import at.fhj.mdd.dsl.metamodel.MFunction;

public interface IParentBuilder {
	MFunction getFunctionByName(String name);
}
