package com.nni.gamevate.orchestrion.renderers;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nni.gamevate.orchestrion.GameConfig;
import com.nni.gamevate.orchestrion.controllers.WorldController;
import com.nni.gamevate.orchestrion.entities.systems.JumpSystem;
import com.nni.gamevate.orchestrion.entities.systems.MovementSystem;
import com.nni.gamevate.orchestrion.entities.systems.RenderSystem;
import com.nni.gamevate.orchestrion.entities.systems.UserControlledSystem;

public class WorldRenderer implements Renderer {
	
	private WorldController controller;
	
	private Engine engine;
	private MovementSystem movementSystem;
	private RenderSystem renderSystem;
	private UserControlledSystem userControlledSystem;
	private JumpSystem jumpSystem;
	
	private OrthographicCamera camera;
	private Viewport viewport;
	
	public  WorldRenderer(WorldController controller) {
		this.controller = controller;
		init();
	}

	@Override
	public void init() {
		camera = new OrthographicCamera();
		viewport = new ExtendViewport(GameConfig.WORLD_WIDTH, GameConfig.WORLD_HEIGHT, camera);
		
		viewport.getCamera().position.set(1f, 1f,0);
		viewport.getCamera().update();
		viewport.update((int)GameConfig.WORLD_WIDTH, (int)GameConfig.WORLD_HEIGHT);
		camera.update();
		
		engine = new Engine();
		movementSystem = new MovementSystem();
		renderSystem = new RenderSystem(camera);
		jumpSystem = new JumpSystem();
		userControlledSystem = new UserControlledSystem();
		
		engine.addSystem(movementSystem);
		engine.addSystem(renderSystem);
		engine.addSystem(jumpSystem);
		engine.addSystem(userControlledSystem);
		
		for(Entity e: controller.getEntities()){
			engine.addEntity(e);
		}
		
		renderSystem.addedToEngine(engine);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		updateCamera();
		engine.update(delta);	
		
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
	}
	
	public void updateCamera(){
		camera.position.x = controller.getCamXPosition();
		camera.update();
	}
}