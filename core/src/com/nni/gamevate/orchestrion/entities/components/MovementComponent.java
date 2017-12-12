package com.nni.gamevate.orchestrion.entities.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool.Poolable;

public class MovementComponent implements Component, Poolable {
	public final Vector2 velocity = new Vector2();

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
}