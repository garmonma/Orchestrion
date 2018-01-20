package com.nni.gamevate.orchestrion;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.nni.gamevate.orchestrion.entitysystem.components.AnimationComponent;
import com.nni.gamevate.orchestrion.entitysystem.components.B2dBodyComponent;
import com.nni.gamevate.orchestrion.entitysystem.components.BeatComponent;
import com.nni.gamevate.orchestrion.entitysystem.components.CollisionComponent;
import com.nni.gamevate.orchestrion.entitysystem.components.PlayerComponent;
import com.nni.gamevate.orchestrion.entitysystem.components.SizeComponent;
import com.nni.gamevate.orchestrion.entitysystem.components.StateComponent;
import com.nni.gamevate.orchestrion.entitysystem.components.TextureComponent;
import com.nni.gamevate.orchestrion.entitysystem.components.TransformComponent;
import com.nni.gamevate.orchestrion.entitysystem.components.TypeComponent;
import com.nni.gamevate.orchestrion.entitysystem.objects.PlayerData;

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
		AnimationComponent animCom = new AnimationComponent();
		TextureComponent texCom = new TextureComponent();
		texCom.region = playerData.getTextureRegion();
		
		
		Animation tempiRun = playerData.getRunAnimation();
		
		
//		animCom.animations.put(StateComponent.STATE_NORMAL, tempiRun);
//		animCom.animations.put(StateComponent.STATE_JUMPING, tempiRun);
//		animCom.animations.put(StateComponent.STATE_FALLING, tempiRun);
//		animCom.animations.put(StateComponent.STATE_HIT, tempiRun);
		animCom.animations.put(StateComponent.STATE_MOVING, tempiRun);

		b2dbody.body = bodyFactory.makeCirclePolyBody(
				playerData.getxPos(),playerData.getyPos(), playerData.getHeight(), 
				BodyFactory.STONE, BodyType.DynamicBody,true);
		
		size.width = playerData.getWidth();
		size.height = playerData.getHeight();
		transform.pos.set(playerData.getxPos(), playerData.getyPos(), 0);
		userState.set(StateComponent.STATE_NORMAL);
		type.type = TypeComponent.PLAYER;
		b2dbody.body.setUserData(entity);

		entity.add(transform);
		entity.add(animCom);
		entity.add(size);
		entity.add(userState);
		entity.add(player);
		entity.add(b2dbody);
		entity.add(collision);
		entity.add(type);
		entity.add(texCom);
		
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
