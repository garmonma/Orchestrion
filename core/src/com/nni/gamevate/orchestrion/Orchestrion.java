package com.nni.gamevate.orchestrion;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nni.gamevate.orchestrion.screens.SplashScreen;

public class Orchestrion extends Game {
	public static SpriteBatch spriteBatch;
	public static AssetManager assetManager;
	
	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		assetManager = new AssetManager();
		this.setScreen(new SplashScreen(this));
	}
	
	@Override
	public void dispose () {
		assetManager.dispose();
		spriteBatch.dispose();
	}
}
