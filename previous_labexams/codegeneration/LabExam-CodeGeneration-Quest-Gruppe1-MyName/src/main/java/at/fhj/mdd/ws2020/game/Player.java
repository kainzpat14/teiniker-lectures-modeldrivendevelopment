package at.fhj.mdd.ws2020.game;

public interface Player {
	void startQuest(String shortDescription, String description);

	void endQuest(String shortDescription);

	void logStep(String shortDescription, String description);

	void gather(String entity, int count);

	void kill(String entity, int count);

	void protect(String entity, int count);
}
