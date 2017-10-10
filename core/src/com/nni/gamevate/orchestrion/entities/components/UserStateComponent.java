package com.nni.gamevate.orchestrion.entities.components;

import com.badlogic.ashley.core.Component;
import com.nni.gamevate.orchestrion.entities.UserState;

public class UserStateComponent implements Component {
	public UserState state;
	public float stateTime = 0;
}
