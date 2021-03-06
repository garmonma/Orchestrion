package com.nni.gamevate.orchestrion.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nni.gamevate.orchestrion.GameData;
import com.nni.gamevate.orchestrion.KeyboardController;
import com.nni.gamevate.orchestrion.Orchestrion;
import com.nni.gamevate.orchestrion.controllers.PlayController;
import com.nni.gamevate.orchestrion.renderers.PlayRenderer;

public class GamePlayScreen extends ScreenAdapter {
	
	private static final String TAG = GamePlayScreen.class.getSimpleName();
	
	public PlayController controller;	
	public static boolean gameOver;
	public static boolean victory;
	
	private Orchestrion orchestrion;
	
	private PlayRenderer renderer;
	
	private SpriteBatch batch;
	private AssetManager assetManager;
	private KeyboardController inputHandler;
	
	public GamePlayScreen(Orchestrion orchestrion, GameData gameData){
		this.orchestrion = orchestrion;
		batch = Orchestrion.spriteBatch;
		assetManager = Orchestrion.assetManager;
		
		gameOver = false;
		victory = false;
		
		controller = new PlayController(gameData);
	}
	
	@Override
	public void show() {
		Gdx.app.log(TAG, "Strarting World Screeen");
		inputHandler = new KeyboardController();		
		renderer = new PlayRenderer(controller, inputHandler);
		Gdx.input.setInputProcessor(inputHandler);
	}
	
	@Override
	public void render(float delta) {			
		controller.update(delta);

		renderer.render(delta);
		
		if((gameOver || victory) ){
			orchestrion.setScreen(new MapSelectScreen(orchestrion));
		}
	}

	@Override
	public void resize(int width, int height) {		
		renderer.resize(width, height);
	}
}