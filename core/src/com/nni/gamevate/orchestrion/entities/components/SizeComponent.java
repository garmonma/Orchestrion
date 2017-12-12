package com.nni.gamevate.orchestrion.entities.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Pool.Poolable;

public class SizeComponent implements Component, Poolable {
	public float width;
	public float height;
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
}