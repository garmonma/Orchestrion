package com.nni.gamevate.orchestrion.entities.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Pool.Poolable;

public class TransformComponent implements Component, Poolable {
	public final Vector3 pos = new Vector3();
	public final Vector3 scale = new Vector3(1.0f, 1.0f, 0.0f);
	public float rotation = 0.0f;
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
}