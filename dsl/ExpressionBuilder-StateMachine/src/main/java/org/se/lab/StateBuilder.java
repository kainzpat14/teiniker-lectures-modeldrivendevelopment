package org.se.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.se.lab.metamodel.MState;
import org.se.lab.metamodel.MStateMachine;

public class StateBuilder {
	private String name;
	private StateMachineBuilder parent;
	private List<TransitionBuilder> transitions = new ArrayList<TransitionBuilder>();
	private List<TransitionBuilder> endTransitions = new ArrayList<TransitionBuilder>();

	public StateBuilder(String name, StateMachineBuilder parent) {
		super();
		this.name = name;
		this.parent = parent;
	}

	public TransitionBuilder transitionTo(String targetName) {
		TransitionBuilder transition = new TransitionBuilder(targetName, this);
		transitions.add(transition);
		return transition;
	}

	public StateBuilder state(String name) {
		return parent.state(name);
	}

	public TransitionBuilder transitionToEnd() {
		TransitionBuilder transition = new TransitionBuilder(null, this);
		endTransitions.add(transition);
		return transition;
	}

	public MState toState() {
		return new MState(name);
	}

	public void populateTransitions(MState endState, Map<String, MState> stateByName) {
		MState mystate = stateByName.get(name);
		if (mystate == null) {
			throw new IllegalStateException("State with name " + name + " was not defined");
		}
		for (TransitionBuilder transitionBuilder : transitions) {
			mystate.getTransitions().add(transitionBuilder.toTransition(stateByName));
		}
		for (TransitionBuilder endTransition : endTransitions) {
			mystate.getTransitions().add(endTransition.toTransition(endState));
		}

	}

	public MStateMachine toMachine() {
		return parent.toMachine();
	}

}
