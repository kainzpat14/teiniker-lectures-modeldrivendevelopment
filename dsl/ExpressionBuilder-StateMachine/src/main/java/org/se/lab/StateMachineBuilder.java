package org.se.lab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.se.lab.metamodel.MState;
import org.se.lab.metamodel.MStateMachine;

public class StateMachineBuilder {

	private StateBuilder initialState;
	private List<StateBuilder> stateBuilders = new ArrayList<>();

	public StateBuilder initial(String name) {
		initialState = state(name);
		return initialState;
	}

	public StateBuilder state(String name) {
		StateBuilder state = new StateBuilder(name, this);
		stateBuilders.add(state);
		return state;
	}

	public MStateMachine toMachine() {
		MStateMachine stateMachine = new MStateMachine();

		MState endState = initializeStateMachine(stateMachine);

		Map<String, MState> stateByName = convertStatesWithoutTransitions(stateMachine);

		populateTransitionsInStates(endState, stateByName);

		stateMachine.setInitState(stateByName.get(initialState.toState().getName()));

		return stateMachine;
	}

	private MState initializeStateMachine(MStateMachine stateMachine) {
		MState endState = new MState("END");
		stateMachine.getFinalStates().add(endState);
		stateMachine.getStates().add(endState);
		if (initialState == null) {
			throw new IllegalStateException("No initial state defined");
		}
		return endState;
	}

	private void populateTransitionsInStates(MState endState, Map<String, MState> stateByName) {
		for (StateBuilder stateBuilder : stateBuilders) {
			stateBuilder.populateTransitions(endState, stateByName);
		}
	}

	private Map<String, MState> convertStatesWithoutTransitions(MStateMachine stateMachine) {
		Map<String, MState> stateByName = new HashMap<>();
		for (StateBuilder stateBuilder : stateBuilders) {
			MState state = stateBuilder.toState();
			stateByName.put(state.getName(), state);
			stateMachine.getStates().add(state);
		}
		return stateByName;
	}

}
