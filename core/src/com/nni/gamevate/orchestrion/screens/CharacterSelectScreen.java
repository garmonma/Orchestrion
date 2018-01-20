package com.nni.gamevate.orchestrion.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nni.gamevate.orchestrion.CharacterConstants;
import com.nni.gamevate.orchestrion.GameData;
import com.nni.gamevate.orchestrion.Orchestrion;
import com.nni.gamevate.orchestrion.controllers.CharacterSelectController;
import com.nni.gamevate.orchestrion.controllers.MapSelectController;
import com.nni.gamevate.orchestrion.entitysystem.objects.PlayerData;
import com.nni.gamevate.orchestrion.maps.Map;
import com.nni.gamevate.orchestrion.maps.MapConstants;
import com.nni.gamevate.orchestrion.renderers.CharacterSelectRenderer;
import com.nni.gamevate.orchestrion.renderers.MapSelectRenderer;

public class CharacterSelectScreen extends ScreenAdapter {

	private Orchestrion orchestrion;
	private CharacterSelectController controller;
	private CharacterSelectRenderer renderer;

	private SpriteBatch batch;
	private AssetManager assetManager;

	private Music backgroundMusic;

	public boolean characterSelected = true;

	public int selectedCharacter = CharacterConstants.TEMPI;

	private GameData gameData;

	public CharacterSelectScreen(Orchestrion orchestrion, GameData gameData) {
		this.orchestrion = orchestrion;
		this.batch = Orchestrion.spriteBatch;
		this.assetManager = Orchestrion.assetManager;
		this.gameData = gameData;
	}

	@Override
	public void show() {
		controller = new CharacterSelectController();
		renderer = new CharacterSelectRenderer();

		// backgroundMusic =
		// assetManager.get(AssetDescriptors.LEVEL_SELECTOR_MUSIC);
		// backgroundMusic.setLooping(true);
		// backgroundMusic.play();
	}

	@Override
	public void render(float delta) {
		controller.update(delta);
		renderer.render(delta);

		if (characterSelected) {
			gameData.player.setCharacter(selectedCharacter);
			orchestrion.setScreen(new GamePlayScreen(orchestrion, gameData));
		}

	}

	@Override
	public void resize(int width, int height) {
		renderer.resize(width, height);
	}

	@Override
	public void hide() {

		// backgroundMusic.stop();

	}

	@Override
	public void dispose() {
		super.dispose();

		// backgroundMusic.dispose();
	}

}