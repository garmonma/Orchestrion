package com.nni.gamevate.orchestrion.entities.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.nni.gamevate.orchestrion.entities.components.UserStateComponent;
import com.nni.gamevate.orchestrion.entities.UserState;
import com.nni.gamevate.orchestrion.entities.components.InputComponent;

public class InputSystem extends IteratingSystem {
	private ComponentMapper<UserStateComponent> usc = ComponentMapper.getFor(UserStateComponent.class);

	public InputSystem() {
		super(Family.all(UserStateComponent.class, InputComponent.class).get());

	}

	@Override
	public void processEntity(Entity entity, float deltaTime) {
	    UserStateComponent userState = usc.get(entity);
	    
	    if(Gdx.input.isKeyPressed(Keys.SPACE) && userState.state != UserState.Jumping){
	    	userState.state = UserState.Jumping;
	    	userState.stateTime = 0;
	    	System.out.println("User State Jumping : " + userState.stateTime);
	    }
	    
	}
}