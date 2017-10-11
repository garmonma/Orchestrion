package com.nni.gamevate.orchestrion.entities.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.nni.gamevate.orchestrion.entities.components.StateComponent;
import com.nni.gamevate.orchestrion.entities.UserState;
import com.nni.gamevate.orchestrion.entities.components.InputComponent;

public class InputSystem extends IteratingSystem {
	private ComponentMapper<InputComponent> ic = ComponentMapper.getFor(InputComponent.class);
	private ComponentMapper<StateComponent> usc = ComponentMapper.getFor(StateComponent.class);

	public InputSystem() {
		super(Family.all(StateComponent.class, InputComponent.class).get());

	}

	@Override
	public void processEntity(Entity entity, float deltaTime) {
	    InputComponent userInput = ic.get(entity);
	    StateComponent userState = usc.get(entity);
	    // TODO after user jumps, how to set him as grounded when he lands on surface?
	    if(Gdx.input.isKeyPressed(Keys.SPACE)){
	    	
	    }
	    
	}
}