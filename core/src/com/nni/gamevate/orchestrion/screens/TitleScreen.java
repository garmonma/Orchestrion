package com.nni.gamevate.orchestrion.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nni.gamevate.orchestrion.Orchestrion;
import com.nni.gamevate.orchestrion.controllers.TitleScreenController;
import com.nni.gamevate.orchestrion.renderers.TitleScreenRenderer;

public class TitleScreen extends ScreenAdapter{
	
	private Orchestrion orchestrion;
	
	private TitleScreenRenderer renderer;
	
	private TitleScreenController controller;
	
	private AssetManager assetManager;

	private OrthographicCamera camera;
	private Viewport viewport;
	private ShapeRenderer shapeRenderer;
	
	public TitleScreen(Orchestrion orchestrion){
		this.orchestrion = orchestrion;
		assetManager = Orchestrion.assetManager;
	}
	
	
}
