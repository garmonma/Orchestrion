package com.nni.gamevate.orchestrion.entitysystem.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.utils.IntMap;
import com.badlogic.gdx.utils.Pool.Poolable;

public class AnimationComponent implements Component, Poolable {
    public IntMap<Animation> animations = new IntMap<Animation>();

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

}
