package at.fhj.mdd.ws2020.generator;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import at.fhj.mdd.ws2020.dsl.metamodel.MPipeline;

public class PipelineGeneratorVisitor extends AbstractPipelineVisitor {

	private PrintWriter functionWriter;
	private PrintWriter pipelineWriter;

	@Override
	public void visit(MPipeline pipeline) {
		try {

			StringWriter functionString = new StringWriter();
			functionWriter = new PrintWriter(functionString);
			StringWriter pipelineString = new StringWriter();
			pipelineWriter = new PrintWriter(pipelineString);
			super.visit(pipeline);
			functionWriter.close();
			pipelineWriter.close();

			PrintWriter writer = new PrintWriter(
					Files.newBufferedWriter(Paths.get("src/gen/java/at/fhj/mdd/ws2020/FunctionPipeline.java")));
			writer.println("package at.fhj.mdd.ws2020;");
			writer.println();
			writer.println("import java.math.BigDecimal;");
			writer.println();
			writer.println("public abstract class FunctionPipeline {");
			writer.println();
			writer.print(functionString.toString());
			writer.println();
			writer.println("\tpublic BigDecimal calculate() {");
			writer.print("\t\treturn ");
			writer.print(pipelineString.toString());
			writer.println(";");
			writer.println("\t}");
			writer.println("}");
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	// TODO: implement

}
