package com.nni.gamevate.orchestrion.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nni.gamevate.orchestrion.Orchestrion;
import com.nni.gamevate.orchestrion.controllers.WorldController;
import com.nni.gamevate.orchestrion.levels.Level;
import com.nni.gamevate.orchestrion.renderers.WorldRenderer;
import com.nni.gamevate.orchestrion.utils.WorldInputHandler;

public class WorldScreen extends ScreenAdapter {
	
	private static final String TAG = WorldScreen.class.getSimpleName();
	
	public WorldController controller;	
	public static boolean gameOver;
	public static boolean victory;
	
	private Orchestrion orchestrion;
	
	private WorldRenderer renderer;
	
	private SpriteBatch batch;
	private AssetManager assetManager;
	private WorldInputHandler inputHandler;
	
	public WorldScreen(Orchestrion orchestrion, Level level){
		this.orchestrion = orchestrion;
		batch = Orchestrion.spriteBatch;
		assetManager = Orchestrion.assetManager;
		
		gameOver = false;
		victory = false;
		
		controller = new WorldController(level);
	}
	
	@Override
	public void show() {
		Gdx.app.log(TAG, "Strarting World Screeen");
		inputHandler = new WorldInputHandler();		
		renderer = new WorldRenderer(controller);
		Gdx.input.setInputProcessor(inputHandler);
	}
	
	@Override
	public void render(float delta) {			
		controller.update(delta);
		inputHandler.update(delta);

		renderer.render(delta);
		
		if((gameOver || victory) && inputHandler.jump == true){
			orchestrion.setScreen(new LevelScreen(orchestrion));
		}
	}

	@Override
	public void resize(int width, int height) {		
		renderer.resize(width, height);
	}
}