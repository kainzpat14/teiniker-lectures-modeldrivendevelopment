package at.fhj.mdd.ws2020.metamodel;

import java.util.ArrayList;
import java.util.List;

public class MRoom extends MDescribedItem {

	private List<MObject> objects = new ArrayList<>();

	public MRoom(String name, String description) {
		super(name, description);
	}

	public List<MObject> getObjects() {
		return objects;
	}

	public void setObjects(List<MObject> objects) {
		this.objects = objects;
	}

}
