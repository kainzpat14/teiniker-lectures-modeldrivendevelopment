package org.se.lab;

public interface IClusterAlgorithm {
	boolean isNode1Available();
	void dispatchToNode1();
	boolean isNode2Available();
	void dispatchToNode2();
	void sendError503();
}
