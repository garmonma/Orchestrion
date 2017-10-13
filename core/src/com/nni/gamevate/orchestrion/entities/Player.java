package com.nni.gamevate.orchestrion.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.nni.gamevate.orchestrion.entities.components.MovementComponent;
import com.nni.gamevate.orchestrion.entities.components.PlayerComponent;
import com.nni.gamevate.orchestrion.entities.components.SizeComponent;
import com.nni.gamevate.orchestrion.entities.components.TextureComponent;
import com.nni.gamevate.orchestrion.entities.components.TransformComponent;
import com.nni.gamevate.orchestrion.entities.components.TypeComponent;
import com.nni.gamevate.orchestrion.entities.components.StateComponent;
import com.nni.gamevate.orchestrion.entities.components.B2dBodyComponent;
import com.nni.gamevate.orchestrion.entities.components.CollisionComponent;

public class Player extends Entity {

	public Player(float x, float y, float width, float height) {

		B2dBodyComponent b2dbody = new B2dBodyComponent();
		TextureComponent texture = new TextureComponent();
		PlayerComponent player = new PlayerComponent();
		CollisionComponent collision = new CollisionComponent();
		TransformComponent transform = new TransformComponent();
		SizeComponent size = new SizeComponent();
		TypeComponent type = new TypeComponent();
		MovementComponent movement = new MovementComponent();
		StateComponent userState = new StateComponent();

		texture.region = new TextureRegion(new Texture(Gdx.files.internal("caveman.png")));
		size.width = width;
		size.height = height;
		transform.pos.set(x, y, 0);
		movement.velocity.set(5.0f, 0);
		userState.set(StateComponent.STATE_NORMAL);
		type.type = TypeComponent.PLAYER;
		b2dbody.body.setUserData(this);

		add(texture);
		add(transform);
		add(size);
		add(movement);
		add(userState);
		add(player);
		add(b2dbody);
		add(collision);
		add(type);
	}

}
