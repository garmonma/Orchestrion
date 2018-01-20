package com.nni.gamevate.orchestrion.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nni.gamevate.orchestrion.GameData;
import com.nni.gamevate.orchestrion.Orchestrion;
import com.nni.gamevate.orchestrion.assets.AssetDescriptors;
import com.nni.gamevate.orchestrion.controllers.MapSelectController;
import com.nni.gamevate.orchestrion.maps.Map;
import com.nni.gamevate.orchestrion.maps.MapConstants;
import com.nni.gamevate.orchestrion.renderers.MapSelectRenderer;

public class MapSelectScreen extends ScreenAdapter {
	private static final String TAG = MapSelectScreen.class.getSimpleName();
	
	private Orchestrion orchestrion;
	public static MapSelectController controller;
	private MapSelectRenderer renderer;
	
	private SpriteBatch batch;
	private AssetManager assetManager;
	
	private Music backgroundMusic;
	
	public boolean mapSelected = true;
	
	public String selectedMap = MapConstants.TEST_MAP;
		
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
		
		if(mapSelected){
			GameData gameData = new GameData();
			gameData.map = new Map(selectedMap);
			gameData.player = gameData.map.getPlayer();
			orchestrion.setScreen(
					new CharacterSelectScreen(orchestrion, gameData));
		}
		
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