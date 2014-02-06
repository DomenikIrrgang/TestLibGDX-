package com.DCStudios.ProjectXXX.Screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

import com.DCStudios.ProjectXXX.ProjectXXX;
import com.DCStudios.ProjectXXX.SpriteTween.SpriteTween;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SplashScreenLogo implements Screen {

	Texture fadingLogo;
	Sprite fadingSprite;
	SpriteBatch batch;
	TweenManager manager;
	ProjectXXX game;
	
	public SplashScreenLogo(ProjectXXX game) {
		this.game = game;
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		manager.update(delta);
		batch.begin();
		fadingSprite.draw(batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		fadingLogo = new Texture("data/logo.png");
		fadingLogo.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		fadingSprite = new Sprite(fadingLogo);
		fadingSprite.setSize(368, 200);
		fadingSprite.setX((Gdx.graphics.getWidth() / 2) - fadingSprite.getWidth() / 2);
		fadingSprite.setY((Gdx.graphics.getHeight() /2) - fadingSprite.getHeight() / 2);
		
		fadingSprite.setColor(1, 1, 1, 0);
		
		batch = new SpriteBatch();
		
		Tween.registerAccessor(Sprite.class, new SpriteTween());
		
		manager = new TweenManager();
		
		TweenCallback cb = new TweenCallback() {
			@Override
			public void onEvent(int type, BaseTween<?> source) {
				tweenCompleted();
			}
		};
		
		Tween.to(fadingSprite,  SpriteTween.alpha, 3f).target(1).ease(TweenEquations.easeInQuad).repeatYoyo(1, 0.5f).setCallback(cb).setCallbackTriggers(TweenCallback.COMPLETE).start(manager);
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}
	
	private void tweenCompleted() {
		game.setScreen(new GameScreen(game));
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

}
