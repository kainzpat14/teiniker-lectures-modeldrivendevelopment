package org.se.lab;

public abstract class ClusterAlgorithmTemplate {
	public void runAlgorithm() {
		if(isNode1Available()) {
			dispatchToNode1();
		}
		else {
			if(isNode2Available()) {
				dispatchToNode2();
			}
			else {
				sendError503();
			}
		}
	}

	protected abstract boolean isNode1Available();
	protected abstract void dispatchToNode1();
	protected abstract boolean isNode2Available();
	protected abstract void dispatchToNode2();
	protected abstract void sendError503();
}
