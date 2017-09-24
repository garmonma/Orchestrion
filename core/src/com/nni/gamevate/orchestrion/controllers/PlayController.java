package com.nni.gamevate.orchestrion.controllers;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.ashley.core.Entity;
import com.nni.gamevate.orchestrion.entities.Ry;
import com.nni.gamevate.orchestrion.entities.components.MovementComponent;
import com.nni.gamevate.orchestrion.entities.components.TransformComponent;
import com.nni.gamevate.orchestrion.screens.GamePlayScreen;
import com.nni.gamevate.orchestrion.utils.Logger;

import maps.Map;

public class PlayController extends AbstractController{
	private Ry ry;

	private float lastCamDelta;
	private float camXPos;
	private Map map;
	
	private List<Entity> entities = new ArrayList<Entity>();
	
	public PlayController(Map map){
		this.map = map;
		init();
	}

	@Override
	protected void init() {
		Logger.log("init World");
		
		ry = new Ry(1, 1);
		
		entities.add(ry);
	}

	@Override
	public void update(float delta) {
		if(GamePlayScreen.gameOver == true){
			return;
		}
		
		updateCamera(delta);
	}
	
	private void updateCamera(float delta){
	//	lastCamDelta = ry.getComponent(MovementComponent.class).velocity.x * delta;
	//	camXPos += lastCamDelta;
		
		camXPos = ry.getComponent(TransformComponent.class).pos.x;
	}
	
	public Map getMap(){
		return map;
	}
	
	public List<Entity> getEntities(){
		return entities;
	}
	
	public float getCamXPosition(){
		return camXPos;
	}

}
