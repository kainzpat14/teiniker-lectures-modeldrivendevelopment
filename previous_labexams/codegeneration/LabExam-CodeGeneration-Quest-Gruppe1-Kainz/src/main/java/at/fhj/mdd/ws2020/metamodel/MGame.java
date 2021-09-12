package at.fhj.mdd.ws2020.metamodel;

import java.util.ArrayList;
import java.util.List;

public class MGame {
	private List<MQuest> quests = new ArrayList<>();

	public List<MQuest> getQuests() {
		return quests;
	}

	public void setQuests(List<MQuest> quests) {
		this.quests = quests;
	}

}
