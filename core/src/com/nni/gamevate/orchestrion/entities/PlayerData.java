package com.nni.gamevate.orchestrion.entities;

public class PlayerData extends DataObject{
	
	private float xPos;
	private float yPos;
	private float width;
	private float height;

	public PlayerData(float x, float y, float width, float height) {
		
		this.xPos = x;
		this.yPos = y;
		this.width = width;
		this.height = height;
		
		
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