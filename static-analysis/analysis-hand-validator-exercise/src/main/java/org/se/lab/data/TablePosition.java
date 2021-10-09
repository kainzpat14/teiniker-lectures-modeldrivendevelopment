package org.se.lab.data;

public class TablePosition {
private boolean dealer;
private final Player player;
private TablePosition left;

public TablePosition(Player player)
{
	this.player = player;
	this.dealer = false;
this.left = null;
}

public boolean isDealer() {
	return dealer;
}

public void setDealer(boolean dealer) {
	this.dealer = dealer;
}

public TablePosition getLeft() {
	return left;
}

public void setLeftPlayer(TablePosition left) {
	this.left = left;
}

public Player getPlayer() {
	return player;
}
}


