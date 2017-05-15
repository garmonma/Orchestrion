package com.nni.gamevate.orchestrion.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nni.gamevate.orchestrion.GameConfig;
import com.nni.gamevate.orchestrion.Orchestrion;
import com.nni.gamevate.orchestrion.assets.AssetDescriptors;

public class SplashScreen extends ScreenAdapter {
	
	private Orchestrion orchestrion;
	private OrthographicCamera camera;
	private Viewport viewport;
	private Texture splashBackground;
	private long startTime;
	private AssetManager assetManager;
	private SpriteBatch batch;
	
	public SplashScreen(Orchestrion orchestrion) {
		this.orchestrion = orchestrion;
		batch = Orchestrion.spriteBatch;
		assetManager = Orchestrion.assetManager;
	}

	@Override
	public void show() {
		camera = new OrthographicCamera();
		viewport = new FitViewport(GameConfig.SCREEN_WIDTH, GameConfig.SCREEN_HEIGHT, camera);
		startTime = TimeUtils.millis();
		
		assetManager.load(AssetDescriptors.SPLASH_BACKGROUND);
		assetManager.finishLoading();
		
		splashBackground = assetManager.get(AssetDescriptors.SPLASH_BACKGROUND);	
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(splashBackground, 0, 0, 800, 480);
		batch.end();
		
		if(TimeUtils.millis() - startTime > 3000){
			orchestrion.setScreen(new LoadingScreen(orchestrion));	
		}	
	}

	@Override
	public void hide() {
		dispose();
		
	}
	
	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, true);
	}
	
	@Override
	public void dispose() {
		
	}
}