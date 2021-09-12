package at.fhj.mdd.ws2020.dsl;

import at.fhj.mdd.ws2020.dsl.metamodel.MFunction;

public interface IParentBuilder {
	MFunction getFunctionByName(String name);
}
