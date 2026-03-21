package org.se.lab;

import java.util.Map;

import org.se.lab.metamodel.MState;
import org.se.lab.metamodel.MStateMachine;
import org.se.lab.metamodel.MTransition;

public class TransitionBuilder {
	private String targetName;
	private StateBuilder parent;
	private String trigger;
	private String activity;

	public TransitionBuilder(String targetName, StateBuilder parent) {
		super();
		this.targetName = targetName;
		this.parent = parent;
	}

	public TransitionBuilder upon(String trigger) {
		this.trigger = trigger;
		return this;
	}

	public TransitionBuilder via(String activity) {
		this.activity = activity;
		return this;
	}

	public StateBuilder state(String name) {
		return parent.state(name);
	}

	public TransitionBuilder transitionTo(String targetName) {
		return parent.transitionTo(targetName);
	}

	public TransitionBuilder transitionToEnd() {
		return parent.transitionToEnd();
	}

	public MTransition toTransition(Map<String, MState> stateByName) {
		MState nextstate = stateByName.get(targetName);
		if (nextstate == null) {
			throw new IllegalStateException("State with name " + targetName + " is not defined");
		}
		return toTransition(nextstate);
	}

	public MTransition toTransition(MState nextState) {
		MTransition transition = new MTransition(trigger, activity);
		transition.setTarget(nextState);
		return transition;
	}

	public MState toState() {
		return parent.toState();
	}

	public void populateTransitions(MState endState, Map<String, MState> stateByName) {
		parent.populateTransitions(endState, stateByName);
	}

	public MStateMachine toMachine() {
		return parent.toMachine();
	}

}
