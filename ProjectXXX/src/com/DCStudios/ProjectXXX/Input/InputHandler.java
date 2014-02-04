package com.DCStudios.ProjectXXX.Input;

import com.DCStudios.ProjectXXX.View.GameWorld;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;

public class InputHandler implements InputProcessor {
	
	GameWorld gameWorld;
	
	public InputHandler(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
	}

	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
		case Keys.W: 
			gameWorld.getPlayer().getVelocity().y = 1;
			break;
		case Keys.S:
			gameWorld.getPlayer().getVelocity().y = -1;
			break;
		case Keys.A:
			gameWorld.getPlayer().getVelocity().x = -1;
			break;
		case Keys.D:
			gameWorld.getPlayer().getVelocity().x = 1;
			break;
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch (keycode) {
		case Keys.W:
			if (gameWorld.getPlayer().getVelocity().y == 1) {
				gameWorld.getPlayer().getVelocity().y = 0;
			}
			break;
		case Keys.S:
			if (gameWorld.getPlayer().getVelocity().y == -1) {
				gameWorld.getPlayer().getVelocity().y = 0;
			}
			break;
		case Keys.A:
			if (gameWorld.getPlayer().getVelocity().x == -1) {
				gameWorld.getPlayer().getVelocity().x = 0;
			}
			break;
		case Keys.D:
			if (gameWorld.getPlayer().getVelocity().x == 1) {
				gameWorld.getPlayer().getVelocity().x = 0;
			}
			break;
		}
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
