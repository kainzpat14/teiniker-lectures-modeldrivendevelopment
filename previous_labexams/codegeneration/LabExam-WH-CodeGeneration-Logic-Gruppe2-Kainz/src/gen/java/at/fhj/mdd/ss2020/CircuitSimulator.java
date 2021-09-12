package at.fhj.mdd.ss2020;

public class CircuitSimulator {
	public boolean xor(boolean source1, boolean source2) {
		return ((source1)||(source2))&&(!((source1)&&(source2)));
	}
	public boolean homeSwitch(boolean power, boolean flipSwitch1, boolean flipSwitch2) {
		return (power)&&(xor(flipSwitch1, flipSwitch2));
	}
}
