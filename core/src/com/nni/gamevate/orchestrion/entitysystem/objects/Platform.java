package com.nni.gamevate.orchestrion.entitysystem.objects;

import com.badlogic.ashley.core.Entity;
import com.nni.gamevate.orchestrion.entitysystem.components.SizeComponent;
import com.nni.gamevate.orchestrion.entitysystem.components.TextureComponent;
import com.nni.gamevate.orchestrion.entitysystem.components.TransformComponent;

public class Platform extends Entity {
	public Platform(float x, float y, float width, float height){
	TextureComponent texture = new TextureComponent();
	TransformComponent transform = new TransformComponent();
	SizeComponent size = new SizeComponent();
	
	size.width = 1f;
	size.height = 1.5f;
	transform.pos.set(x, y, 0);
	
	add(size);
	add(transform);
	}
}
