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
import com.nni.gamevate.orchestrion.entities.components.TransformComponent;
import com.nni.gamevate.orchestrion.entities.components.UserStateComponent;

public class MovementSystem extends IteratingSystem {
	private ComponentMapper<TransformComponent> tm = ComponentMapper.getFor(TransformComponent.class);
	private ComponentMapper<MovementComponent> mm = ComponentMapper.getFor(MovementComponent.class);
	private ComponentMapper<UserStateComponent> um = ComponentMapper.getFor(UserStateComponent.class);
	private ComponentMapper<GravityComponent> gm = ComponentMapper.getFor(GravityComponent.class);
	private ComponentMapper<JumpComponent> jm = ComponentMapper.getFor(JumpComponent.class);
	
	public MovementSystem() {
		super(Family.all(TransformComponent.class, MovementComponent.class).get());
	}

	@Override
	public void processEntity(Entity entity, float deltaTime) {
		TransformComponent transform = tm.get(entity);
		MovementComponent movement = mm.get(entity);
		UserStateComponent state = um.get(entity);
		GravityComponent gravity = gm.get(entity);
		JumpComponent jump = jm.get(entity);
		
		if(transform.pos.y > 1)
			state.state = UserState.Jumping;
		
		if(state.state == UserState.Jumping  && !jump.maxJumpHeightReached){
			transform.pos.y += jump.jumpVelocity.y * deltaTime;
			transform.pos.x += movement.velocity.x * deltaTime;
			System.out.println("User Jumped : " + state.stateTime);
			
			if(transform.pos.y >= jump.maxJumpHeight.y){
				jump.maxJumpHeightReached = true;
			}
			
		} else if(state.state == UserState.Jumping && jump.maxJumpHeightReached && transform.pos.y > 1){
			transform.pos.y += gravity.gravity.y * deltaTime;
			transform.pos.x += movement.velocity.x * deltaTime;
			if(transform.pos.y <=1)
				state.state = UserState.Running;
				
		}
		
		if(state.state == UserState.Running){
			transform.pos.x += movement.velocity.x * deltaTime;
			transform.pos.y += movement.velocity.y * deltaTime;
		} 

	
		
	}
}