package com.DCStudios.ProjectXXX;

import com.DCStudios.ProjectXXX.Screens.GameScreen;
import com.badlogic.gdx.Game;


public class ProjectXXX extends Game {
	
	public static final String name = "ProjectXXX";
	public static final String version = "0.0.0.03 Pre-Alpha";
	static final public boolean debug = false;
	
	@Override
	public void create() {		
		setScreen(new GameScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {		
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
