package com.nni.gamevate.orchestrion.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.nni.gamevate.orchestrion.entities.components.MovementComponent;
import com.nni.gamevate.orchestrion.entities.components.SizeComponent;
import com.nni.gamevate.orchestrion.entities.components.TextureComponent;
import com.nni.gamevate.orchestrion.entities.components.TransformComponent;
import com.nni.gamevate.orchestrion.entities.components.UserControlledComponent;

public class Ry extends Entity{
	
	private static final String TAG = Ry.class.getSimpleName();
	
	public Ry(float x, float y){
		TextureComponent texture = new TextureComponent();
		TransformComponent transform = new TransformComponent();
		SizeComponent size = new SizeComponent();
		MovementComponent movement = new MovementComponent();
		UserControlledComponent userControlled = new UserControlledComponent();
		
		texture.region = new TextureRegion(new Texture(Gdx.files.internal("caveman.png")));
		size.width = 1f;
		size.height = 1.5f;
		transform.pos.set(x, y);

		add(texture);
		add(transform);
		add(size);
		add(movement);
		add(userControlled);
	}
}
