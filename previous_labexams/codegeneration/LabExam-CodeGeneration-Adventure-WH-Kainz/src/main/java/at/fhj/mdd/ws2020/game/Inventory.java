package at.fhj.mdd.ws2020.game;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
	private Map<String, Integer> items = new HashMap<>();

	public boolean hasItem(String name, int count) {
		if (items.containsKey(name)) {
			return items.get(name) >= count;
		}
		return false;
	}

	public void addItem(String name, int count) {
		int existing = 0;
		if (items.containsKey(name)) {
			existing = items.get(name);
		}
		items.put(name, existing + count);
	}
}
