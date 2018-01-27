package com.nni.gamevate.orchestrion.entitysystem.objects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class PlayerData extends DataObject {
	
	private float xPos;
	private float yPos;
	private float width;
	private float height;
	
	private Animation runAnimation;
	private Animation jumpAnimation;
	
	private int character;

	public PlayerData(float x, float y, float width, float height) {
		
		this.xPos = x;
		this.yPos = y;
		this.width = width;
		this.height = height;
	}
	
	public int getCharacter(){
		return this.character;
	}
	
	public void setCharacter(int character){
		this.character = character;
	}
	
	public void setRunAnimation(Animation anim){
	    runAnimation = anim;
	}
	
	public Animation getRunAnimation(){
		return runAnimation;
	    
	}

	public float getxPos() {
		return xPos;
	}

	public float getyPos() {
		return yPos;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public void setxPos(float xPos) {
		this.xPos = xPos;
	}

	public void setyPos(float yPos) {
		this.yPos = yPos;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public void setHeight(float height) {
		this.height = height;
	}
}