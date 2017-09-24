package com.nni.gamevate.orchestrion.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nni.gamevate.orchestrion.Orchestrion;
import com.nni.gamevate.orchestrion.assets.AssetDescriptors;
import com.nni.gamevate.orchestrion.controllers.MapSelectController;
import com.nni.gamevate.orchestrion.renderers.MapSelectRenderer;

import maps.Map;
import maps.MapConstants;

public class MapSelectScreen extends ScreenAdapter {
	private static final String TAG = MapSelectScreen.class.getSimpleName();
	
	private Orchestrion orchestrion;
	public static MapSelectController controller;
	private MapSelectRenderer renderer;
	
	private SpriteBatch batch;
	private AssetManager assetManager;
	
	private Music backgroundMusic;
		
	public MapSelectScreen(Orchestrion orchestrion) {
		this.orchestrion = orchestrion;
		batch = Orchestrion.spriteBatch;
		assetManager = Orchestrion.assetManager;
	}

	@Override
	public void show() {
		controller = new MapSelectController();
		renderer = new MapSelectRenderer();
		
//		backgroundMusic = assetManager.get(AssetDescriptors.LEVEL_SELECTOR_MUSIC);
//		backgroundMusic.setLooping(true);
//		backgroundMusic.play();	
	}

	@Override
	public void render(float delta) {
		controller.update(delta);
		renderer.render(delta);
		
		orchestrion.setScreen(new GamePlayScreen(orchestrion, new Map(MapConstants.TEST_MAP)));
	}
	
	@Override
	public void resize(int width, int height) {
		renderer.resize(width, height);
	}

	@Override
	public void hide() {

		//backgroundMusic.stop();
		
	}
	
	@Override
	public void dispose() {
		super.dispose();
		
		//backgroundMusic.dispose();
	}

}