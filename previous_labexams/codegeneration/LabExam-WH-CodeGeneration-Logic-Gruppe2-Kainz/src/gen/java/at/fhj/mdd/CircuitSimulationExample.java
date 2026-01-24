package at.fhj.mdd;

public class CircuitSimulationExample {
	public boolean nand(boolean source1, boolean source2) {
		return !((source1) && (source2));
	}

	public boolean circuit1(boolean power, boolean consumer1, boolean consumer2) {
		return (power) && (nand(consumer1, consumer2));
	}
}
