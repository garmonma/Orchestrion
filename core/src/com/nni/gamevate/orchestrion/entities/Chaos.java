package com.nni.gamevate.orchestrion.entities;

import com.badlogic.ashley.core.Entity;
import com.nni.gamevate.orchestrion.entities.components.SizeComponent;
import com.nni.gamevate.orchestrion.entities.components.TextureComponent;
import com.nni.gamevate.orchestrion.entities.components.TransformComponent;

public class Chaos extends Entity{
	
	public Chaos(float x, float y, float width, float height){
		TextureComponent texture = new TextureComponent();
		TransformComponent transform = new TransformComponent();
		SizeComponent size = new SizeComponent();
		
		size.width = width;
		size.height = height;
		transform.pos.set(x, y);
		
		add(size);
		add(transform);
	}
}
