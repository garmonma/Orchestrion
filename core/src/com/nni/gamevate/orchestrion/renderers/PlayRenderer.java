package com.nni.gamevate.orchestrion.renderers;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nni.gamevate.orchestrion.BodyFactory;
import com.nni.gamevate.orchestrion.GameConfig;
import com.nni.gamevate.orchestrion.KeyboardController;
import com.nni.gamevate.orchestrion.Orchestrion;
import com.nni.gamevate.orchestrion.assets.AssetDescriptors;
import com.nni.gamevate.orchestrion.controllers.PlayController;
import com.nni.gamevate.orchestrion.entities.EntityFactory;
import com.nni.gamevate.orchestrion.entities.systems.AnimationSystem;
import com.nni.gamevate.orchestrion.entities.systems.CollisionSystem;
import com.nni.gamevate.orchestrion.entities.systems.MovementSystem;
import com.nni.gamevate.orchestrion.entities.systems.PhysicsDebugSystem;
import com.nni.gamevate.orchestrion.entities.systems.PhysicsSystem;
import com.nni.gamevate.orchestrion.entities.systems.PlayerControlSystem;
import com.nni.gamevate.orchestrion.entities.systems.RenderSystem;

public class PlayRenderer implements Renderer {
	
	private PlayController controller;
	
	private Engine engine;
	private MovementSystem movementSystem;
	private RenderSystem renderSystem;
	private AnimationSystem animationSystem;
	private CollisionSystem collisionSystem;
	private PhysicsDebugSystem pDebugSystem;
	private PhysicsSystem pSystem;
	private PlayerControlSystem playerControlSystem;
	
	private OrthographicCamera camera;
	private Viewport viewport;
	private World world;
	private KeyboardController kc;
	private EntityFactory entityFactory;
	private BodyFactory bodyFactory;
	
	public  PlayRenderer(PlayController controller) {
		this.controller = controller;
		init();
	}

	@Override
	public void init() {
		camera = new OrthographicCamera();
		viewport = new ExtendViewport(GameConfig.WORLD_WIDTH, GameConfig.WORLD_HEIGHT, camera);
		world = new World(new Vector2(0, -10f), true);
		kc = new KeyboardController();
		
		
		
		viewport.getCamera().position.set(0f, 2f,0);
		viewport.getCamera().update();
		viewport.update((int)GameConfig.WORLD_WIDTH, (int)GameConfig.WORLD_HEIGHT, false);
		camera.update();
		
		engine = new PooledEngine();
		movementSystem = new MovementSystem();
		renderSystem = new RenderSystem(camera);
		animationSystem = new AnimationSystem();
		collisionSystem = new CollisionSystem();
		pDebugSystem = new PhysicsDebugSystem(world, camera);
		pSystem = new PhysicsSystem(world);
		playerControlSystem = new PlayerControlSystem(kc);
			
		engine.addSystem(movementSystem);
		engine.addSystem(renderSystem);
		engine.addSystem(animationSystem);
		engine.addSystem(collisionSystem);
		engine.addSystem(pDebugSystem);
		engine.addSystem(pSystem);
		engine.addSystem(playerControlSystem);
		
		bodyFactory = BodyFactory.getInstance(world);
		entityFactory = new EntityFactory((PooledEngine)engine, bodyFactory);
		
		Entity player = entityFactory.createPlayer(controller.getPlayer());
		engine.addEntity(player);
		controller.setPlayer(player);
		
		
//		for(Entity e: controller.getEntities()){
//			engine.addEntity(e);
//			
//		}
		
		renderSystem.addedToEngine(engine);
		
		Music music = Orchestrion.assetManager.get(AssetDescriptors.FUR_ELISE);
		music.setLooping(false);
		music.play();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.8f, 0.8f, 0.8f, 1.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		updateCamera();
		controller.getMap().render(camera);
		engine.update(delta);	
		
		
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, false);
	}
	
	public void updateCamera(){
		camera.position.x = controller.getCamPosition().x;
		camera.position.y = controller.getCamPosition().y;
		camera.position.z = controller.getCamPosition().z;
		
		System.out.printf("Player Pos : X = %f, Y= %f, Z=%f \n", 
				camera.position.x, camera.position.y, camera.position.z);
		
		camera.update();
	}
}