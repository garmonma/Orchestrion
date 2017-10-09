package com.nni.gamevate.orchestrion.maps;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.objects.TiledMapTileMapObject;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.nni.gamevate.orchestrion.GameConfig;
import com.nni.gamevate.orchestrion.utils.Logger;

public class Map {
	private TiledMap map;
	private TiledMapTileMapObject object;
	private TiledMapTileLayer layer;
	private TmxMapLoader loader;
	private OrthogonalTiledMapRenderer renderer;

	public Map(String map){
		init(map);
	}
	
	private void init(String mapUrl){
		loader = new TmxMapLoader();
		map = loader.load(mapUrl);
		renderer = new OrthogonalTiledMapRenderer(map, GameConfig.MAP_SCALE);
		
		layer = (TiledMapTileLayer)map.getLayers().get(0);
		
		int columns = layer.getWidth();
		int rows = layer.getHeight();
		MapObjects mapObjects = layer.getObjects();

		System.out.println("Columns : " + columns);
		System.out.println("Rows : " + rows);
	}
	
	public void render(OrthographicCamera camera){
		renderer.setView(camera);
		renderer.render();
	}
	
	public void dispose(){
		map.dispose();
	}

}
