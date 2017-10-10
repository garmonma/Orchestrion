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
import com.nni.gamevate.orchestrion.entities.components.UserStateComponent;
import com.nni.gamevate.orchestrion.entities.components.GravityComponent;
import com.nni.gamevate.orchestrion.entities.components.InputComponent;

public class Player extends Entity {

	public Player(float x, float y, float width, float height) {

		TextureComponent texture = new TextureComponent();
		TransformComponent transform = new TransformComponent();
		SizeComponent size = new SizeComponent();
		MovementComponent movement = new MovementComponent();
		GravityComponent gravity = new GravityComponent();
		InputComponent input = new InputComponent();
		UserStateComponent userState = new UserStateComponent();
		JumpComponent jump = new JumpComponent();

		// TODO How to initialize multiple animations?
		texture.region = new TextureRegion(new Texture(Gdx.files.internal("caveman.png")));
		size.width = width;
		size.height = height;
		transform.pos.set(x, y);
		movement.velocity.set(5.0f, 0);
		userState.state = UserState.Standing;
		userState.stateTime = 0;
		gravity.gravity.set(0, -2.0f);
		jump.jumpVelocity.set(0, 10.0f);
		jump.maxJumpHeight.set(0, 15.0f);

		add(texture);
		add(transform);
		add(size);
		add(movement);
		add(gravity);
		add(input);
		add(userState);
		add(jump);
	}

}
