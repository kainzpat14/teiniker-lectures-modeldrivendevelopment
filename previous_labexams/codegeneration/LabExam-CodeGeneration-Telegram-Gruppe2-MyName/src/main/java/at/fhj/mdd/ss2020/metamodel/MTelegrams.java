package at.fhj.mdd.ss2020.metamodel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MTelegrams {
	private List<MTelegram> inputTelegrams = new ArrayList<>();
	private List<MTelegram> outputTelegrams = new ArrayList<>();

	public List<MTelegram> getInputTelegrams() {
		return inputTelegrams;
	}

	public void setInputTelegrams(List<MTelegram> inputTelegrams) {
		this.inputTelegrams = inputTelegrams;
	}

	public List<MTelegram> getOutputTelegrams() {
		return outputTelegrams;
	}

	public void setOutputTelegrams(List<MTelegram> outputTelegrams) {
		this.outputTelegrams = outputTelegrams;
	}

	public void generate(String pkg, String basePath) {
		try {
			String targetString = pkg.replace(".", "/");
			Path target = Paths.get(basePath).resolve(targetString);
			if (!Files.exists(target)) {
				Files.createDirectories(target);
			}
			Set<MTelegram> telegrams = new HashSet<>();
			telegrams.addAll(inputTelegrams);
			telegrams.addAll(outputTelegrams);
			for (MTelegram telegram : telegrams) {
				// TODO: implement
			}
		} catch (IOException ex) {
			throw new RuntimeException("Error generating", ex);
		}
	}
}
