package com.nni.gamevate.orchestrion.entitysystem.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.utils.Pool.Poolable;
/*
 *  Stores collision data such as entity that this entity has collided with
 */
public class CollisionComponent implements Component, Poolable {
	public Entity collisionEntity;

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}; 
 
}