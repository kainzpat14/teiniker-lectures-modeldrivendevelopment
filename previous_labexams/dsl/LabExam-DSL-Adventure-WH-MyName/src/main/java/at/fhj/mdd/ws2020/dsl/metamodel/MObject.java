package at.fhj.mdd.ws2020.dsl.metamodel;

import java.util.ArrayList;
import java.util.List;

public class MObject extends MDescribedItem {

	private List<MInteraction> interactions = new ArrayList<>();

	public MObject(String name, String description) {
		super(name, description);
	}

	public List<MInteraction> getInteractions() {
		return interactions;
	}

	public void setInteractions(List<MInteraction> interactions) {
		this.interactions = interactions;
	}

}
