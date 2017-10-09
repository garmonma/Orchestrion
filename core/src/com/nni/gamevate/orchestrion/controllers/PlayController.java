package com.nni.gamevate.orchestrion.controllers;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.ashley.core.Entity;
import com.nni.gamevate.orchestrion.maps.Map;
import com.nni.gamevate.orchestrion.screens.GamePlayScreen;
import com.nni.gamevate.orchestrion.utils.Logger;

public class PlayController extends AbstractController {
    private float camXPos;
    private Map map;

    private List<Entity> entities = new ArrayList<Entity>();

    public PlayController(Map map) {
	this.map = map;
	init();
    }

    @Override
    protected void init() {
	Logger.log("init World");
	entities = map.getEntities();
    }

    @Override
    public void update(float delta) {
	if (GamePlayScreen.gameOver == true) {
	    return;
	}

	updateCamera(delta);
    }

    private void updateCamera(float delta) {
	// camXPos = ry.getComponent(TransformComponent.class).pos.x;
    }

    public Map getMap() {
	return map;
    }

    public List<Entity> getEntities() {
	return entities;
    }

    public float getCamXPosition() {
	return camXPos;
    }

}
