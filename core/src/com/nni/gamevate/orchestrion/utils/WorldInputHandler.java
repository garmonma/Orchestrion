package com.nni.gamevate.orchestrion.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.nni.gamevate.orchestrion.screens.GamePlayScreen;

public class WorldInputHandler extends InputAdapter {
	
	public boolean jump;
	
	public void update(float delta){
		jump = Gdx.input.isKeyPressed(Input.Keys.SPACE) 
				|| Gdx.input.isTouched();
		
		if(jump == true){			
			if(GamePlayScreen.gameOver == false){			
				//hero jumps
			}
		}
	}
	
	@Override
	public boolean keyDown(int keyCode){
				return true;
	}

}
