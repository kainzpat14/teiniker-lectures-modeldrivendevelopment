package at.fhj.mdd.ss2020.dsl.metamodel;

import java.util.ArrayList;
import java.util.List;

public class MListElement implements MElement {
	private List<MListEntry> entries = new ArrayList<>();

	public List<MListEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<MListEntry> entries) {
		this.entries = entries;
	}

}
