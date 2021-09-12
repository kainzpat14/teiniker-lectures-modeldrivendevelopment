package at.fhj.mdd.ss2020.generator;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import at.fhj.mdd.ss2020.CircuitSimulationExample;
import at.fhj.mdd.ss2020.CircuitSimulator;
import at.fhj.mdd.ss2020.metamodel.MAnd;
import at.fhj.mdd.ss2020.metamodel.MCircuit;
import at.fhj.mdd.ss2020.metamodel.MCircuitReuse;
import at.fhj.mdd.ss2020.metamodel.MInput;
import at.fhj.mdd.ss2020.metamodel.MModel;
import at.fhj.mdd.ss2020.metamodel.MNot;
import at.fhj.mdd.ss2020.metamodel.MOr;

public class TestSimulator {
	@Test
	public void testSimulationExample() throws InterruptedException {
		CircuitSimulationExample simulator = new CircuitSimulationExample();
		Assert.assertTrue(simulator.circuit1(true, true, false));
		Assert.assertTrue(simulator.circuit1(true, false, false));
		Assert.assertFalse(simulator.circuit1(true, true, true));
		Assert.assertFalse(simulator.circuit1(false, true, false));
	}

	@Test
	public void testGenerator() {
		MModel model = new MModel();
		MInput source1 = new MInput("source1");
		MInput source2 = new MInput("source2");
		MAnd and1 = new MAnd(source1, source2);
		MNot not = new MNot(and1);
		MOr or = new MOr(source1, source2);
		MAnd and2 = new MAnd(or, not);
		MCircuit xor = new MCircuit("xor", and2, Arrays.asList(source1, source2));
		model.getCircuits().add(xor);

		MInput power = new MInput("power");
		MInput switch1 = new MInput("flipSwitch1");
		MInput switch2 = new MInput("flipSwitch2");
		MCircuitReuse xorCall = new MCircuitReuse(xor, Arrays.asList(switch1, switch2));
		MAnd and3 = new MAnd(power, xorCall);
		MCircuit homeSwitch = new MCircuit("homeSwitch", and3, Arrays.asList(power, switch1, switch2));
		model.getCircuits().add(homeSwitch);

		SimulatorGeneratorVisitor visitor = new SimulatorGeneratorVisitor();
		visitor.visit(model);
	}

	@Test
	public void testHomeSwitch() {
		CircuitSimulator simulator = new CircuitSimulator();
		Assert.assertTrue(simulator.homeSwitch(true, true, false));
		Assert.assertTrue(simulator.homeSwitch(true, false, true));
		Assert.assertFalse(simulator.homeSwitch(true, true, true));
		Assert.assertFalse(simulator.homeSwitch(false, true, false));
	}

}
