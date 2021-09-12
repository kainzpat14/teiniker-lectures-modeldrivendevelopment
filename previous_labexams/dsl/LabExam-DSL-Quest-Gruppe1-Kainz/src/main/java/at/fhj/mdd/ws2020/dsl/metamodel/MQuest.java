package at.fhj.mdd.ws2020.dsl.metamodel;

import java.util.ArrayList;
import java.util.List;

public class MQuest extends MDescribedElement {

	private List<MStep> steps = new ArrayList<>();

	public MQuest(String shortDescription, String description) {
		super(shortDescription, description);
	}

	public List<MStep> getSteps() {
		return steps;
	}

	public void setSteps(List<MStep> steps) {
		this.steps = steps;
	}

}
