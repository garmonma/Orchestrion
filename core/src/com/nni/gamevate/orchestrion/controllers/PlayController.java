package com.nni.gamevate.orchestrion.controllers;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector3;
import com.nni.gamevate.orchestrion.entities.Player;
import com.nni.gamevate.orchestrion.entities.components.TransformComponent;
import com.nni.gamevate.orchestrion.maps.Map;
import com.nni.gamevate.orchestrion.screens.GamePlayScreen;
import com.nni.gamevate.orchestrion.utils.Logger;

public class PlayController extends AbstractController {
	private Vector3 camPos;
	private Map map;
	private Player player;

	private List<Entity> entities = new ArrayList<Entity>();

	public PlayController(Map map) {
		this.map = map;
		init();
	}

	@Override
	protected void init() {
		Logger.log("init World");

		entities = map.getEntities();
		player = map.getPlayer();

		camPos = new Vector3(player.getComponent(TransformComponent.class).pos);
	}

	@Override
	public void update(float delta) {
		if (GamePlayScreen.gameOver == true) {
			return;
		}

		updateCamera(delta);
	}

	private void updateCamera(float delta) {
		camPos = new Vector3(player.getComponent(TransformComponent.class).pos);
	}

	public Map getMap() {
		return map;
	}

	public List<Entity> getEntities() {
		return entities;
	}

	public Vector3 getCamPosition() {
		return camPos;
	}

}
