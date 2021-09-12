package at.fhj.mdd.ws2020;

import java.math.BigDecimal;

public abstract class ExampleFunctionPipeline {
	protected abstract BigDecimal input();
	protected abstract BigDecimal square(BigDecimal base);
	protected abstract BigDecimal add(BigDecimal summand1, BigDecimal summand2);
	protected abstract BigDecimal sqrt(BigDecimal square);

	public BigDecimal calculate() {
		return sqrt(add(square(input()), square(input())));
	}
}
