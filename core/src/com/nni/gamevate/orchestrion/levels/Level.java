package com.nni.gamevate.orchestrion.levels;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.nni.gamevate.orchestrion.GameConfig;
import com.nni.gamevate.orchestrion.utils.Logger;

public class Level {
	private TiledMap map;
	private TmxMapLoader loader;
	private OrthogonalTiledMapRenderer renderer;
	
	public Level(String map){
		init(map);
	}
	
	private void init(String mapUrl){
		loader = new TmxMapLoader();
		map = loader.load(mapUrl);
		renderer = new OrthogonalTiledMapRenderer(map, GameConfig.MAP_SCALE);
		
	}
	
	public void render(OrthographicCamera camera){
		renderer.setView(camera);
		renderer.render();
	}

}
