package at.fhj.mdd.ws2020.metamodel;

import java.util.ArrayList;
import java.util.List;

public class MGame {
	private List<MItem> items = new ArrayList<>();
	private List<MRoom> rooms = new ArrayList<>();

	public List<MItem> getItems() {
		return items;
	}

	public void setItems(List<MItem> items) {
		this.items = items;
	}

	public List<MRoom> getRooms() {
		return rooms;
	}

	public void setRooms(List<MRoom> rooms) {
		this.rooms = rooms;
	}

}
