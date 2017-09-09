package com.nni.gamevate.orchestrion.entities.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.nni.gamevate.orchestrion.entities.components.JumpComponent;
import com.nni.gamevate.orchestrion.entities.components.MovementComponent;
import com.nni.gamevate.orchestrion.entities.components.TransformComponent;
import com.nni.gamevate.orchestrion.entities.components.UserControlledComponent;

public class UserControlledSystem extends IteratingSystem {
	private ComponentMapper<UserControlledComponent> um = ComponentMapper.getFor(UserControlledComponent.class);
	
	public UserControlledSystem() {
		super(Family.all(JumpComponent.class, UserControlledComponent.class).get());

	}

	@Override
	public void processEntity(Entity entity, float deltaTime) {
	    UserControlledComponent userInput = um.get(entity);
	    
	    if(Gdx.input.isKeyPressed(Keys.SPACE)){
		userInput.jump = true;
	    }
	    
	}
}