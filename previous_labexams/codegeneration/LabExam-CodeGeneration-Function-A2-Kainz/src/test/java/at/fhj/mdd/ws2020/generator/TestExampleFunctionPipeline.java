package at.fhj.mdd.ws2020.generator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import org.junit.Assert;
import org.junit.Test;

import at.fhj.mdd.ws2020.ExampleFunctionPipeline;

public class TestExampleFunctionPipeline extends ExampleFunctionPipeline {

	private Queue<BigDecimal> inputQueue = new LinkedBlockingDeque<>();

	@Override
	protected BigDecimal input() {
		return inputQueue.poll();
	}

	@Override
	protected BigDecimal square(BigDecimal base) {
		return base.multiply(base);
	}

	@Override
	protected BigDecimal add(BigDecimal summand1, BigDecimal summand2) {
		return summand1.add(summand2);
	}

	@Override
	protected BigDecimal sqrt(BigDecimal square) {
		return square.sqrt(MathContext.DECIMAL128);
	}

	@Test
	public void testExamplePipeline() {
		inputQueue.add(new BigDecimal(3));
		inputQueue.add(new BigDecimal(4));
		Assert.assertEquals(new BigDecimal(5), this.calculate());
	}

}
