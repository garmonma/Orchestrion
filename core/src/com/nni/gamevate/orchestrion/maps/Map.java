package com.nni.gamevate.orchestrion.maps;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.nni.gamevate.orchestrion.GameConfig;
import com.nni.gamevate.orchestrion.entities.Player;
import com.nni.gamevate.orchestrion.entities.objects.Cannon;

public class Map {
    private TiledMap map;
    private TiledMapTileLayer tileLayer;
    private MapLayer objectLayer;
    private TmxMapLoader loader;
    private OrthogonalTiledMapRenderer renderer;
    private List<Entity> entities;

    public Map(String map) {
	init(map);
    }

    private void init(String mapUrl) {
	loader = new TmxMapLoader();
	map = loader.load(mapUrl);
	renderer = new OrthogonalTiledMapRenderer(map, GameConfig.MAP_SCALE);
	entities = new ArrayList<Entity>();

	tileLayer = (TiledMapTileLayer) map.getLayers().get(0);
	objectLayer = map.getLayers().get("objectLayer");

	int columns = tileLayer.getWidth();
	int rows = tileLayer.getHeight();

	System.out.println("Columns : " + columns);
	System.out.println("Rows : " + rows);

	MapObjects objects = objectLayer.getObjects();
	System.out.println("Objects Counts : " + objects.getCount());

	for (MapObject obj : objects) {
	    entities.add(processMapObjects(obj));
	}

    }

    public void render(OrthographicCamera camera) {
	renderer.setView(camera);
	renderer.render();
    }

    public void dispose() {
	map.dispose();
    }
    
    public List<Entity> getEntities(){
	return entities;
    }

    private Entity processMapObjects(MapObject obj) {
	float x = Float.parseFloat(obj.getProperties().get(MapConstants.X_KEY).toString());
	float y = Float.parseFloat(obj.getProperties().get(MapConstants.Y_KEY).toString());
	float width = Float.parseFloat(obj.getProperties().get(MapConstants.WIDTH_KEY).toString());
	float height = Float.parseFloat(obj.getProperties().get(MapConstants.WIDTH_KEY).toString());

	if(obj.getName() == null){
	    obj.setName("MISC");
	}
	
	switch (obj.getName()) {
	case MapConstants.PLAYER:
	    return new Player(x, y, width, height);
	}

	return new Cannon(x, y, width, height);
    }

}
