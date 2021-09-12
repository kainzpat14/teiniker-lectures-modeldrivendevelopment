package at.fhj.mdd.ws2020.generator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import at.fhj.mdd.ws2020.FunctionPipeline;

public class TestFunctionPipeline extends FunctionPipeline {

	@Override
	protected BigDecimal multiply(BigDecimal factor1, BigDecimal factor2) {
		return factor1.multiply(factor2);
	}

	@Override
	protected BigDecimal square(BigDecimal base) {
		return base.multiply(base);
	}

	@Override
	protected BigDecimal input() {
		return BigDecimal.valueOf(4);
	}

	@Override
	protected BigDecimal pi() {
		return BigDecimal.valueOf(Math.PI);
	}

	@Test
	public void testFunctionPipeline() {
		Assert.assertEquals(Math.PI * 4 * 4, this.calculate().doubleValue(), 0.01);
	}

}
