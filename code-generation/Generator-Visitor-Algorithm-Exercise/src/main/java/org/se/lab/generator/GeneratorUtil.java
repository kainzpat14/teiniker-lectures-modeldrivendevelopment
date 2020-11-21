package org.se.lab.generator;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GeneratorUtil {
	public PrintWriter generateFile(String filename) {
		try {
			Path parentPath = Paths.get("src/gen/java/org/se/lab");
			if (!Files.exists(parentPath)) {
				Files.createDirectories(parentPath);
			}
			Path filePath = parentPath.resolve(filename);
			PrintWriter writer = new PrintWriter(Files.newBufferedWriter(filePath));
			writer.println("package org.se.lab;");
			writer.println();
			return writer;
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
}
