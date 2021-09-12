package at.fhj.mdd.ss2020.dsl.metamodel;

import java.util.ArrayList;
import java.util.List;

public class MTelegram extends MMappedElement {
	private List<MField> fields = new ArrayList<>();

	public MTelegram(String name, String mapping) {
		super(name, mapping);
	}

	public List<MField> getFields() {
		return fields;
	}

	public void setFields(List<MField> fields) {
		this.fields = fields;
	}

}
