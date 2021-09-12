package at.fhj.mdd.ws2020.dsl.metamodel;

import java.util.ArrayList;
import java.util.List;

public class MInteraction extends MDescribedItem {

	private MPrecondition precondition = null;
	private List<MOccurence> occurences = new ArrayList<>();

	public MInteraction(String name, String description) {
		super(name, description);
	}

	public MPrecondition getPrecondition() {
		return precondition;
	}

	public void setPrecondition(MPrecondition precondition) {
		this.precondition = precondition;
	}

	public List<MOccurence> getOccurences() {
		return occurences;
	}

	public void setOccurences(List<MOccurence> occurences) {
		this.occurences = occurences;
	}

}
