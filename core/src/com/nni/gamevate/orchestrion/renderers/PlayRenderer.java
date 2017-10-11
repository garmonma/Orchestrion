package com.nni.gamevate.orchestrion.renderers;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nni.gamevate.orchestrion.GameConfig;
import com.nni.gamevate.orchestrion.Orchestrion;
import com.nni.gamevate.orchestrion.assets.AssetDescriptors;
import com.nni.gamevate.orchestrion.controllers.PlayController;
import com.nni.gamevate.orchestrion.entities.systems.JumpSystem;
import com.nni.gamevate.orchestrion.entities.systems.MovementSystem;
import com.nni.gamevate.orchestrion.entities.systems.RenderSystem;
import com.nni.gamevate.orchestrion.maps.Map;

public class PlayRenderer implements Renderer {
	
	private PlayController controller;
	
	private Engine engine;
	private MovementSystem movementSystem;
	private RenderSystem renderSystem;
	private JumpSystem jumpSystem;
	
	private OrthographicCamera camera;
	private Viewport viewport;
	
	public  PlayRenderer(PlayController controller) {
		this.controller = controller;
		init();
	}

	@Override
	public void init() {
		camera = new OrthographicCamera();
		viewport = new ExtendViewport(GameConfig.WORLD_WIDTH, GameConfig.WORLD_HEIGHT, camera);
		
		viewport.getCamera().position.set(0f, 2f,0);
		viewport.getCamera().update();
		viewport.update((int)GameConfig.WORLD_WIDTH, (int)GameConfig.WORLD_HEIGHT, false);
		camera.update();
		
		engine = new Engine();
		movementSystem = new MovementSystem();
		renderSystem = new RenderSystem(camera);
		jumpSystem = new JumpSystem();
		
		engine.addSystem(movementSystem);
		engine.addSystem(renderSystem);
		engine.addSystem(jumpSystem);
		
		for(Entity e: controller.getEntities()){
			engine.addEntity(e);
		}
		
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
		camera.update();
	}
}