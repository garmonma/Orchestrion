package com.nni.gamevate.orchestrion.entities.systems;

import javax.swing.plaf.synth.SynthSpinnerUI;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.nni.gamevate.orchestrion.entities.UserState;
import com.nni.gamevate.orchestrion.entities.components.GravityComponent;
import com.nni.gamevate.orchestrion.entities.components.JumpComponent;
import com.nni.gamevate.orchestrion.entities.components.MovementComponent;
import com.nni.gamevate.orchestrion.entities.components.StateComponent;
import com.nni.gamevate.orchestrion.entities.components.TransformComponent;

public class MovementSystem extends IteratingSystem {
	private ComponentMapper<TransformComponent> tm = ComponentMapper.getFor(TransformComponent.class);
	private ComponentMapper<MovementComponent> mm = ComponentMapper.getFor(MovementComponent.class);
	private ComponentMapper<GravityComponent> gm = ComponentMapper.getFor(GravityComponent.class);
	private ComponentMapper<JumpComponent> jm = ComponentMapper.getFor(JumpComponent.class);
	
	public MovementSystem() {
		super(Family.all(TransformComponent.class, MovementComponent.class).get());
	}

	@Override
	public void processEntity(Entity entity, float deltaTime) {
		TransformComponent transform = tm.get(entity);
		MovementComponent movement = mm.get(entity);
		GravityComponent gravity = gm.get(entity);
		JumpComponent jump = jm.get(entity);
		
		transform.pos.x += movement.velocity.x * deltaTime;
		transform.pos.y += movement.velocity.y * deltaTime;

	
		
	}
}