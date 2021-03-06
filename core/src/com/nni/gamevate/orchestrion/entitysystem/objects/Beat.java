package com.nni.gamevate.orchestrion.entitysystem.objects;

import com.badlogic.ashley.core.Entity;
import com.nni.gamevate.orchestrion.entitysystem.components.SizeComponent;
import com.nni.gamevate.orchestrion.entitysystem.components.TextureComponent;
import com.nni.gamevate.orchestrion.entitysystem.components.TransformComponent;

public class Beat extends Entity {

    public Beat(String type, float x, float y, float width, float height){
	TextureComponent texture = new TextureComponent();
	TransformComponent transform = new TransformComponent();
	SizeComponent size = new SizeComponent();
	
	size.width = width;
	size.height = height;
	transform.pos.set(x, y, 0);
	
	add(size);
	add(transform);
    }
}
