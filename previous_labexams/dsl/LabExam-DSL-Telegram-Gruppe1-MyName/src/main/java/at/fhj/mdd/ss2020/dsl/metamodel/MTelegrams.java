package at.fhj.mdd.ss2020.dsl.metamodel;

import java.util.ArrayList;
import java.util.List;

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

}
