package com.nni.gamevate.orchestrion;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

public class KeyboardController implements InputProcessor {

	public boolean left, right, up, down;
	public boolean isMouse1Down, isMouse2Down, isMouse3Down;
	public boolean isDragged;
	public boolean tap;
	public Vector2 mouseLocation = new Vector2(0, 0);

	@Override
	public boolean keyDown(int keycode) {
		boolean keyProcessed = false;
		switch (keycode) // switch code base on the variable keycode
        {
	        case Keys.SPACE:  	// if keycode is the same as Keys.LEFT a.k.a 21
	            tap = true;	// do this
	            keyProcessed = true;	// we have reacted to a keypress 
	           
        }
		return keyProcessed;	//  return our peyProcessed flag
	}

	@Override
	public boolean keyUp(int keycode) {
		boolean keyProcessed = false;
		switch (keycode) // switch code base on the variable keycode
        {
	        case Keys.SPACE:  	// if keycode is the same as Keys.LEFT a.k.a 21
	            tap = false;	// do this
	            keyProcessed = true;	// we have reacted to a keypress 
	            
        }
		
		return keyProcessed;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		System.out.println(button);
		if (button == 0) {
			isMouse1Down = true;
			tap = true;
		} else if (button == 1) {
			isMouse2Down = true;
			tap = true;
		} else if (button == 2) {
			isMouse3Down = true;
			tap = true;
		}
		// mouseLocation.x = screenX;
		// mouseLocation.y = screenY;
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		isDragged = false;
		 System.out.println(button);
		if (button == 0) {
			isMouse1Down = false;
			tap = false;
		} else if (button == 1) {
			isMouse2Down = false;
			tap = false;
		} else if (button == 2) {
			isMouse3Down = false;
			tap = false;
		}
		//mouseLocation.x = screenX;
		//mouseLocation.y = screenY;
		// TODO Auto-generated method stub
		return false;

	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
