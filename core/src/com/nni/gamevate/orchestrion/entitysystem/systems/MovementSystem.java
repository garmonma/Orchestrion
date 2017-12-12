package com.nni.gamevate.orchestrion.entitysystem.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.nni.gamevate.orchestrion.entitysystem.components.MovementComponent;
import com.nni.gamevate.orchestrion.entitysystem.components.TransformComponent;

public class MovementSystem extends IteratingSystem {
	private ComponentMapper<TransformComponent> tm = ComponentMapper.getFor(TransformComponent.class);
	private ComponentMapper<MovementComponent> mm = ComponentMapper.getFor(MovementComponent.class);
	
	public MovementSystem() {
		super(Family.all(TransformComponent.class, MovementComponent.class).get());
	}

	@Override
	public void processEntity(Entity entity, float deltaTime) {
		TransformComponent transform = tm.get(entity);
		MovementComponent movement = mm.get(entity);
		
		transform.pos.x += movement.velocity.x * deltaTime;
		transform.pos.y += movement.velocity.y * deltaTime;

	
		
	}
}