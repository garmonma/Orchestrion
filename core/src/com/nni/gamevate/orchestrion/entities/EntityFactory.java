package com.nni.gamevate.orchestrion.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.nni.gamevate.orchestrion.BodyFactory;
import com.nni.gamevate.orchestrion.entities.components.B2dBodyComponent;
import com.nni.gamevate.orchestrion.entities.components.TextureComponent;
import com.nni.gamevate.orchestrion.entities.components.TypeComponent;

public class EntityFactory {
	
	private PooledEngine engine;
	private BodyFactory bodyFactory;
	
	public EntityFactory(PooledEngine engine, BodyFactory bod2dFactory){
		this.engine  = engine;
		bodyFactory = bod2dFactory;
	}
	
	
	public void createPlatform(float x, float y){
		Entity entity = engine.createEntity();
		
		B2dBodyComponent b2dbody = engine.createComponent(B2dBodyComponent.class);
		TypeComponent type = engine.createComponent(TypeComponent.class);
		type.type = TypeComponent.SCENERY;
		b2dbody.body.setUserData(entity);
		
		entity.add(b2dbody);
		//entity.add(texture);
		entity.add(type);
		
		engine.addEntity(entity);
		
	}
	
	public void createFloor(){
		Entity entity = engine.createEntity();
		B2dBodyComponent b2dbody = engine.createComponent(B2dBodyComponent.class);
		b2dbody.body = bodyFactory.makeBoxPolyBody(0, 0, 100, 0.2f, BodyFactory.STONE, BodyType.StaticBody);
		TextureComponent texture = engine.createComponent(TextureComponent.class);
		texture.region = new TextureRegion(new Texture(Gdx.files.internal("caveman.png")));
		TypeComponent type = engine.createComponent(TypeComponent.class);
		type.type = TypeComponent.SCENERY;
		
		b2dbody.body.setUserData(entity);
	 
		entity.add(b2dbody);
		entity.add(texture);
		entity.add(type);
		
		engine.addEntity(entity);
	}
}
