package at.fhj.mdd.ws2020.generator;

import org.junit.Test;

import at.fhj.mdd.ws2020.dsl.PipelineBuilder;
import at.fhj.mdd.ws2020.dsl.metamodel.MPipeline;

public class TestGenerator {

	@Test
	public void testGenerator() {
		// @formatter:off
		MPipeline pipeline = new PipelineBuilder()
				.function("input")
				.function("pi")
				.function("square")
					.parameter("base")
				.function("multiply")
					.parameter("factor1")
					.parameter("factor2")
				.end("multiply")
					.input("square")
						.input("input").done()
						.done()
					.input("pi").done()
					.done()
				.toPipeline();
		// @formatter:on
		new PipelineGeneratorVisitor().visit(pipeline);
	}

}
