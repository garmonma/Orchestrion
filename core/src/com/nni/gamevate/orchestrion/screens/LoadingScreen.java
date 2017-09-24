package com.nni.gamevate.orchestrion.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nni.gamevate.orchestrion.GameConfig;
import com.nni.gamevate.orchestrion.Orchestrion;
import com.nni.gamevate.orchestrion.assets.AssetDescriptors;

public class LoadingScreen extends ScreenAdapter {
	
	private static final float PROGRESS_BAR_WIDTH = GameConfig.UI_SCREEN_WIDTH / 2f; 
    private static final float PROGRESS_BAR_HEIGHT = 60; 

	private Orchestrion orchestrion;
	private AssetManager assetManager;
	
	private OrthographicCamera camera;
	private Viewport viewport;
	private ShapeRenderer renderer;
	
	private float progress;
    private float waitTime = 0.75f;
    private boolean changeScreen;
	
	public LoadingScreen(Orchestrion orchestrion) {
		this.orchestrion = orchestrion;
		assetManager = Orchestrion.assetManager;
	}
	
	@Override
	public void show() {
		camera = new OrthographicCamera();
		viewport = new FitViewport(GameConfig.SCREEN_WIDTH, GameConfig.SCREEN_HEIGHT, camera);
		renderer = new ShapeRenderer();
		
		assetManager.load(AssetDescriptors.FUR_ELISE);
		//assetManager.load(AssetDescriptors.SPLASH_BACKGROUND);
	}

	@Override
	public void render(float delta) {
		update(delta);
		
		Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        viewport.apply();
        renderer.setProjectionMatrix(camera.combined);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        
        draw();
        
        renderer.end();
        
        if(changeScreen){
        	orchestrion.setScreen(new MapSelectScreen(orchestrion));
        }
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}
	
	private void update(float delta){
		progress = assetManager.getProgress();
		
		if(assetManager.update()){
			waitTime -= delta;
			
			if(waitTime <= 0){
				changeScreen = true;
			}
		}
	}
	
	private void draw(){
		float progressBarX = (GameConfig.UI_SCREEN_WIDTH - PROGRESS_BAR_WIDTH) / 2f;
        float progressBarY = (GameConfig.UI_SCREEN_HEIGHT - PROGRESS_BAR_HEIGHT) / 2f;

        renderer.rect(progressBarX, progressBarY,
                progress * PROGRESS_BAR_WIDTH, PROGRESS_BAR_HEIGHT
        );
	}

}
