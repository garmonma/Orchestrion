package com.nni.gamevate.orchestrion.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.nni.gamevate.orchestrion.entities.components.JumpComponent;
import com.nni.gamevate.orchestrion.entities.components.MovementComponent;
import com.nni.gamevate.orchestrion.entities.components.SizeComponent;
import com.nni.gamevate.orchestrion.entities.components.TextureComponent;
import com.nni.gamevate.orchestrion.entities.components.TransformComponent;
import com.nni.gamevate.orchestrion.entities.components.StateComponent;
import com.nni.gamevate.orchestrion.entities.components.InputComponent;

public class Player extends Entity {

    public Player(float x, float y, float width, float height) {

	TextureComponent texture = new TextureComponent();
	TransformComponent transform = new TransformComponent();
	SizeComponent size = new SizeComponent();
	MovementComponent movement = new MovementComponent();
	JumpComponent jump = new JumpComponent();
	InputComponent input = new InputComponent();
	StateComponent userState = new StateComponent();

	// TODO How to initialize multiple animations?
	texture.region = new TextureRegion(new Texture(Gdx.files.internal("caveman.png")));
	size.width = width;
	size.height = height;
	transform.pos.set(x, y);
	movement.velocity.set(5.0f, 0);
	userState.set(StateComponent.STATE_NORMAL);
	userState.time = 0;

	add(texture);
	add(transform);
	add(size);
	add(movement);
	add(jump);
	add(input);
	add(userState);
    }

}
