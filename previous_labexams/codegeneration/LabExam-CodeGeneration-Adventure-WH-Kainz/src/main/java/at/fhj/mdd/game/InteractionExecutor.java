package at.fhj.mdd.game;

public interface InteractionExecutor {
	void execute(Game game, String roomName, String objectName, String interactionName);

	boolean canExecute(Inventory inventory, String roomName, String objectName, String interactionName);
}
