package com.DCStudios.ProjectXXX.Screens;

import com.DCStudios.ProjectXXX.ProjectXXX;
import com.DCStudios.ProjectXXX.GameWorlds.TestWorld;
import com.DCStudios.ProjectXXX.Input.InputHandler;
import com.DCStudios.ProjectXXX.View.GameRender;
import com.DCStudios.ProjectXXX.View.GameWorld;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;

public class GameScreen implements Screen {

	ProjectXXX game;
	GameWorld gameWorld;
	GameRender gameRender;
	InputProcessor input;
	FPSLogger log = new FPSLogger();
	
	public GameScreen(ProjectXXX game) {
		this.game = game;
		this.gameWorld = new TestWorld(this);
		this.gameRender = new GameRender(gameWorld);
		input = new InputHandler(gameWorld);
		
		Gdx.input.setInputProcessor(input);
	}
	
	public void setNewWorld(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
		this.gameRender = new GameRender(this.gameWorld);
		input = new InputHandler(this.gameWorld);
		Gdx.input.setInputProcessor(input);
	}
	
	@Override
	public void render(float delta) {
		gameRender.render();
		//Gdx.app.log("delta.", String.valueOf(delta));
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		
	}

}
