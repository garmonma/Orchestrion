package com.nni.gamevate.orchestrion.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.nni.gamevate.orchestrion.BodyFactory;
import com.nni.gamevate.orchestrion.entities.components.B2dBodyComponent;
import com.nni.gamevate.orchestrion.entities.components.CollisionComponent;
import com.nni.gamevate.orchestrion.entities.components.MovementComponent;
import com.nni.gamevate.orchestrion.entities.components.PlayerComponent;
import com.nni.gamevate.orchestrion.entities.components.SizeComponent;
import com.nni.gamevate.orchestrion.entities.components.StateComponent;
import com.nni.gamevate.orchestrion.entities.components.TextureComponent;
import com.nni.gamevate.orchestrion.entities.components.TransformComponent;
import com.nni.gamevate.orchestrion.entities.components.TypeComponent;

public class EntityFactory {
	
	private PooledEngine engine;
	private BodyFactory bodyFactory;
	
	public EntityFactory(PooledEngine engine, BodyFactory bod2dFactory){
		this.engine  = engine;
		bodyFactory = bod2dFactory;
	}
	
	public Entity createPlayer(PlayerData playerData){
		Entity entity = engine.createEntity();
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
		b2dbody.body = bodyFactory.makeCirclePolyBody(10,10,1, BodyFactory.STONE, BodyType.DynamicBody,true);
		size.width = playerData.getWidth();
		size.height = playerData.getHeight();
		transform.pos.set(playerData.getxPos(), playerData.getyPos(), 0);
		movement.velocity.set(5.0f, 0);
		userState.set(StateComponent.STATE_NORMAL);
		type.type = TypeComponent.PLAYER;
		b2dbody.body.setUserData(this);

		entity.add(texture);
		entity.add(transform);
		entity.add(size);
		entity.add(movement);
		entity.add(userState);
		entity.add(player);
		entity.add(b2dbody);
		entity.add(collision);
		entity.add(type);
		
		return entity;
		
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
