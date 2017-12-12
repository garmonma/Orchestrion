package com.nni.gamevate.orchestrion.renderers;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nni.gamevate.orchestrion.B2dContactListener;
import com.nni.gamevate.orchestrion.BodyFactory;
import com.nni.gamevate.orchestrion.GameConfig;
import com.nni.gamevate.orchestrion.KeyboardController;
import com.nni.gamevate.orchestrion.Orchestrion;
import com.nni.gamevate.orchestrion.assets.AssetDescriptors;
import com.nni.gamevate.orchestrion.controllers.PlayController;
import com.nni.gamevate.orchestrion.entitysystem.EntityFactory;
import com.nni.gamevate.orchestrion.entitysystem.systems.AnimationSystem;
import com.nni.gamevate.orchestrion.entitysystem.systems.CollisionSystem;
import com.nni.gamevate.orchestrion.entitysystem.systems.MovementSystem;
import com.nni.gamevate.orchestrion.entitysystem.systems.PhysicsDebugSystem;
import com.nni.gamevate.orchestrion.entitysystem.systems.PhysicsSystem;
import com.nni.gamevate.orchestrion.entitysystem.systems.PlayerControlSystem;
import com.nni.gamevate.orchestrion.entitysystem.systems.RenderingSystem;

public class PlayRenderer implements Renderer {
	
	private PlayController controller;
	
	private Engine engine;
	private MovementSystem movementSystem;
	private RenderingSystem renderSystem;
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
	
	private SpriteBatch batch;
	
	public  PlayRenderer(PlayController controller, KeyboardController kc) {
		this.controller = controller;
		this.kc = kc;
		
		init();
	}
	
	

	@Override
	public void init() {
		camera = new OrthographicCamera();
		viewport = new ExtendViewport(GameConfig.WORLD_WIDTH, GameConfig.WORLD_HEIGHT, camera);
		batch = new SpriteBatch();
		world = new World(new Vector2(0, -10f), true);
		world.setContactListener(new B2dContactListener());
		
		viewport.getCamera().position.set(0f, 2f,0);
		viewport.getCamera().update();
		viewport.update((int)GameConfig.WORLD_WIDTH, (int)GameConfig.WORLD_HEIGHT, false);
		camera.update();
		
		engine = new Engine();
		movementSystem = new MovementSystem();
		renderSystem = new RenderingSystem(batch);
		animationSystem = new AnimationSystem();
		collisionSystem = new CollisionSystem();
		pDebugSystem = new PhysicsDebugSystem(world, camera);
		pSystem = new PhysicsSystem(world, engine);
		playerControlSystem = new PlayerControlSystem(kc);
			
		engine.addSystem(movementSystem);
		engine.addSystem(renderSystem);
		engine.addSystem(animationSystem);
		engine.addSystem(collisionSystem);
		engine.addSystem(pDebugSystem);
		engine.addSystem(pSystem);
		engine.addSystem(playerControlSystem);
		
		bodyFactory = BodyFactory.getInstance(world);
		entityFactory = new EntityFactory(bodyFactory);
		
		Entity player = entityFactory.createPlayer(controller.getPlayer());
		engine.addEntity(player);
		controller.setPlayer(player);
		
		Entity floor = entityFactory.createFloor();
		engine.addEntity(floor);
		
		Entity platform = entityFactory.createPlatform(35, 3);
		engine.addEntity(platform);
		
		Entity platform2 = entityFactory.createPlatform(42, 6);
		engine.addEntity(platform2);
		
		Entity platform3 = entityFactory.createPlatform(49, 9);
		engine.addEntity(platform3);
		
		Entity beat = entityFactory.createBeat(50,  10);
		engine.addEntity(beat);
		
		renderSystem.addedToEngine(engine);
		
		Music music = Orchestrion.assetManager.get(AssetDescriptors.FUR_ELISE);
		music.setLooping(false);
		music.play();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
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
		
//		System.out.printf("Player Pos : X = %f, Y= %f, Z=%f \n", 
//				camera.position.x, camera.position.y, camera.position.z);
		
		camera.update();
	}
}