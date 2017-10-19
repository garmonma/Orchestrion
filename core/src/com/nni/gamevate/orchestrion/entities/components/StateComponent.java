package com.nni.gamevate.orchestrion.entities.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Pool.Poolable;
import com.nni.gamevate.orchestrion.entities.UserState;

public class StateComponent implements Component, Poolable {
	public static final int STATE_NORMAL = 0;
	public static final int STATE_JUMPING = 1;
	public static final int STATE_FALLING = 2;
	public static final int STATE_MOVING = 3;
	public static final int STATE_HIT = 4;

	private int state = 0;
	public float time = 0.0f;
	public boolean isLooping = false;

	public void set(int newState) {
		state = newState;
		time = 0.0f;
	}

	public int get() {
		return state;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
}
