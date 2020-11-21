package org.se.lab;

public class ClusterAlgorithm {
	public void runAlgorithm(IClusterAlgorithm delegate) {
		if(delegate.isNode1Available()) {
			delegate.dispatchToNode1();
		}
		else {
			if(delegate.isNode2Available()) {
				delegate.dispatchToNode2();
			}
			else {
				delegate.sendError503();
			}
		}
	}
}
