package at.fhj.mdd.game;

public abstract class Interaction {

	public abstract boolean canExecute(Inventory inventory);

	public abstract void execute(Game game);

}
