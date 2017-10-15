package com.nni.gamevate.orchestrion.controllers;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.nni.gamevate.orchestrion.entities.DataObject;
import com.nni.gamevate.orchestrion.entities.PlayerData;
import com.nni.gamevate.orchestrion.entities.components.TransformComponent;
import com.nni.gamevate.orchestrion.maps.Map;
import com.nni.gamevate.orchestrion.screens.GamePlayScreen;
import com.nni.gamevate.orchestrion.utils.Logger;

public class PlayController extends AbstractController {
	private Vector3 camPos;
	private Map map;
	private PlayerData playerData;
	private Entity player;

	private List<DataObject> dataObjects = new ArrayList<DataObject>();

	public PlayController(Map map) {
		this.map = map;
		init();
	}

	@Override
	protected void init() {
		Logger.log("init World");

		dataObjects = map.getObjects();
		playerData = map.getPlayer();

	}

	@Override
	public void update(float delta) {
		if (camPos == null && player != null) {
			camPos = new Vector3(player.getComponent(TransformComponent.class).pos);
		}

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

	public List<DataObject> getObjects() {
		return dataObjects;
	}

	public Vector3 getCamPosition() {
		return camPos;
	}

	public PlayerData getPlayer() {
		return playerData;
	}

	public void setPlayer(Entity e) {
		this.player = e;
	}

}
