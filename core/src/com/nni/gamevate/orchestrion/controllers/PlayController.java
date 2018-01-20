package com.nni.gamevate.orchestrion.controllers;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.nni.gamevate.orchestrion.CharacterConstants;
import com.nni.gamevate.orchestrion.GameData;
import com.nni.gamevate.orchestrion.Orchestrion;
import com.nni.gamevate.orchestrion.assets.AssetDescriptors;
import com.nni.gamevate.orchestrion.entitysystem.objects.DataObject;
import com.nni.gamevate.orchestrion.entitysystem.objects.PlayerData;
import com.nni.gamevate.orchestrion.entitysystem.components.TransformComponent;
import com.nni.gamevate.orchestrion.maps.Map;
import com.nni.gamevate.orchestrion.screens.GamePlayScreen;
import com.nni.gamevate.orchestrion.utils.Logger;

public class PlayController extends AbstractController {
	private Vector3 camPos;
	private Map map;
	private PlayerData playerData;
	private Entity player;

	private List<DataObject> dataObjects = new ArrayList<DataObject>();

	public PlayController(GameData gameData) {
		this.map = gameData.map;
		dataObjects = map.getObjects();
		this.playerData = gameData.player;
		init();
	}

	@Override
	protected void init() {
		Logger.log("init World");
		
		switch(playerData.getCharacter()){
		case CharacterConstants.RY:
			initRy();
			break;
		case CharacterConstants.TEMPI:
			initTempi();
			break;
		}
	}
	
	private void initRy(){
		TextureRegion texRy = new TextureRegion(Orchestrion.assetManager.get(AssetDescriptors.RY).findRegion("ryRun"));

		Animation ryRunAnimation = new Animation(0.1f,
				Orchestrion.assetManager.get(AssetDescriptors.RY).findRegions("ryRun"), PlayMode.LOOP);
		
		if (ryRunAnimation != null)
			Logger.log("Run Annimation : " + ryRunAnimation);
		
		if (texRy != null)
			Logger.log("Texture Region : " + texRy);
		
		playerData.setRunAnimation(ryRunAnimation);
		playerData.setTextureRegion(texRy);
		
	}
	
	private void initTempi(){
		TextureRegion tex = new TextureRegion(Orchestrion.assetManager.get(AssetDescriptors.TEMPI).findRegion("tempiRun"));
		
		Animation tempiRunAnimation = new Animation(0.1f,
				Orchestrion.assetManager.get(AssetDescriptors.TEMPI).findRegions("tempiRun"), PlayMode.LOOP);
		
		if (tempiRunAnimation != null)
			Logger.log("Run Annimation Tempi : " + tempiRunAnimation);
		
		if (tex != null)
			Logger.log("Texture Region : " + tex);
		
		playerData.setRunAnimation(tempiRunAnimation);
		playerData.setTextureRegion(tex);
		
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
