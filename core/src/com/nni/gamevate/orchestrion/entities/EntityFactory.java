package com.nni.gamevate.orchestrion.entities;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.nni.gamevate.orchestrion.BodyFactory;
import com.nni.gamevate.orchestrion.entities.components.B2dBodyComponent;
import com.nni.gamevate.orchestrion.entities.components.BeatComponent;
import com.nni.gamevate.orchestrion.entities.components.CollisionComponent;
import com.nni.gamevate.orchestrion.entities.components.MovementComponent;
import com.nni.gamevate.orchestrion.entities.components.PlayerComponent;
import com.nni.gamevate.orchestrion.entities.components.SizeComponent;
import com.nni.gamevate.orchestrion.entities.components.StateComponent;
import com.nni.gamevate.orchestrion.entities.components.TextureComponent;
import com.nni.gamevate.orchestrion.entities.components.TransformComponent;
import com.nni.gamevate.orchestrion.entities.components.TypeComponent;
import com.nni.gamevate.orchestrion.entities.objects.Beat;

public class EntityFactory {
	private BodyFactory bodyFactory;
	
	public EntityFactory(BodyFactory bod2dFactory){
		bodyFactory = bod2dFactory;
	}
	
	public Entity createPlayer(PlayerData playerData){
		Entity entity = new Entity();
		B2dBodyComponent b2dbody = new B2dBodyComponent();
		PlayerComponent player = new PlayerComponent();
		CollisionComponent collision = new CollisionComponent();
		TransformComponent transform = new TransformComponent();
		SizeComponent size = new SizeComponent();
		TypeComponent type = new TypeComponent();
		StateComponent userState = new StateComponent();

		//texture.region = new TextureRegion(new Texture(Gdx.files.internal("caveman.png")));
		b2dbody.body = bodyFactory.makeCirclePolyBody(10,10,1, BodyFactory.STONE, BodyType.DynamicBody,true);
		size.width = playerData.getWidth();
		size.height = playerData.getHeight();
		transform.pos.set(playerData.getxPos(), playerData.getyPos(), 0);
		userState.set(StateComponent.STATE_NORMAL);
		type.type = TypeComponent.PLAYER;
		b2dbody.body.setUserData(entity);

		entity.add(transform);
		entity.add(size);
		entity.add(userState);
		entity.add(player);
		entity.add(b2dbody);
		entity.add(collision);
		entity.add(type);
		
		return entity;
		
	}
	
	
	public Entity createPlatform(float x, float y){
		Entity entity = new Entity();
		
		B2dBodyComponent b2dbody = new B2dBodyComponent();
		TypeComponent type = new TypeComponent();
		
		b2dbody.body = bodyFactory.makeBoxPolyBody(x, y, 3, 0.2f, BodyFactory.STONE, BodyType.StaticBody);
		type.type = TypeComponent.SCENERY;
		b2dbody.body.setUserData(entity);
		
		entity.add(b2dbody);
		//entity.add(texture);
		entity.add(type);
		
		return entity;
		
	}
	
	public Entity createFloor(){
		Entity entity = new Entity();
		B2dBodyComponent b2dbody = new B2dBodyComponent();
		TypeComponent type = new TypeComponent();
		
		//TextureComponent texture = engine.createComponent(TextureComponent.class);
		//texture.region = new TextureRegion(new Texture(Gdx.files.internal("caveman.png")));
		
		b2dbody.body = bodyFactory.makeBoxPolyBody(0, 0, 100, 0.2f, BodyFactory.STONE, BodyType.StaticBody);
		type.type = TypeComponent.SCENERY;
		b2dbody.body.setUserData(entity);
	 
		entity.add(b2dbody);
		//entity.add(texture);
		entity.add(type);
		
		return entity;
	}
	
	public Entity createBeat(float x, float y){
		
		Entity entity = new Entity();
		B2dBodyComponent b2dbody = new B2dBodyComponent();
		TypeComponent type = new TypeComponent();
		BeatComponent beat = new BeatComponent();
		
		b2dbody.body = bodyFactory.makeCirclePolyBody(x, y, .75f, BodyFactory.RUBBER, BodyType.StaticBody, true);
		type.type = TypeComponent.BEAT;
		b2dbody.body.setUserData(entity);
		
		entity.add(b2dbody);
		entity.add(type);
		entity.add(beat);
		
		
		return entity;
	}
	
	public Entity createEnemy(float x, float y){
		
		return new Entity();
	}
	
	public Entity createChoas(float x, float y){
		
		return new Entity();
	}


}
