package org.se.lab;

public abstract class PhoneAlgorithmTemplate {
	public void runAlgorithm() {
		announceNumbers();
		takeNumber();
		if(enteredNumber1()) {
			connectToDoctor();
		}
		else {
			if(enteredNumber2()) {
				connectToAdministration();
			}
			else {
				disconnect();
			}
		}
	}

	protected abstract void announceNumbers();
	protected abstract void takeNumber();
	protected abstract boolean enteredNumber1();
	protected abstract void connectToDoctor();
	protected abstract boolean enteredNumber2();
	protected abstract void connectToAdministration();
	protected abstract void disconnect();
}
