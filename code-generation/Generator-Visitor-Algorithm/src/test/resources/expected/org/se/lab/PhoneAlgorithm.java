package org.se.lab;

public class PhoneAlgorithm {
	public void runAlgorithm(IPhoneAlgorithm delegate) {
		delegate.announceNumbers();
		delegate.takeNumber();
		if(delegate.enteredNumber1()) {
			delegate.connectToDoctor();
		}
		else {
			if(delegate.enteredNumber2()) {
				delegate.connectToAdministration();
			}
			else {
				delegate.disconnect();
			}
		}
	}
}
