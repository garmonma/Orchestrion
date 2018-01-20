package com.nni.gamevate.orchestrion.maps;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MapBackground {
	
	private float xPos;
	private float yPos;
	private float width;
	private float height;
	
	private TextureRegion texReg;
	
	public void setTextureRegion(TextureRegion tex){
	    texReg = tex;
	}
	
	public TextureRegion getTextureRegion(){
		return texReg;
	}
}
