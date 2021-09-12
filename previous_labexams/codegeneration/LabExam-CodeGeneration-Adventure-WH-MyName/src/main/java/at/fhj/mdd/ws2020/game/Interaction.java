package at.fhj.mdd.ws2020.game;

public abstract class Interaction {

	public abstract boolean canExecute(Inventory inventory);

	public abstract void execute(Game game);

}
