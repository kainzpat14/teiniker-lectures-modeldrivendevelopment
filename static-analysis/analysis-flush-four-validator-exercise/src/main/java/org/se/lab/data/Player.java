package org.se.lab.data;

import java.util.LinkedList;
import java.util.List;

public class Player {
	private final String name;
	private final List<Card> hand;
	private long stack;  
	 
	public Player(String name, long stack) {
		this.name = name;
		this.stack = stack;
		this.hand = new LinkedList<Card>();
	}

	public long getStack() {
		return stack;
	}

	public void setStack(long stack) {
		this.stack = stack;
	}

	public String getName() {
		return name;
	}

	public List<Card> getHand() {
		return hand;
	}
	
public String toString()
{
	return this.getName() + " (" + this.getStack() + ")";
}
}
