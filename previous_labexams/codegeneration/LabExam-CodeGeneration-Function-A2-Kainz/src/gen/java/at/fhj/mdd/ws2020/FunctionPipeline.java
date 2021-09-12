package at.fhj.mdd.ws2020;

import java.math.BigDecimal;

public abstract class FunctionPipeline {

	protected abstract BigDecimal multiply(BigDecimal factor1, BigDecimal factor2);
	protected abstract BigDecimal square(BigDecimal base);
	protected abstract BigDecimal input();
	protected abstract BigDecimal pi();

	public BigDecimal calculate() {
		return multiply(square(input()), pi());
	}
}
