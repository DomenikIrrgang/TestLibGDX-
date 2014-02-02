package com.DCStudios.ProjectXXX.View;

import java.util.Iterator;

import com.DCStudios.ProjectXXX.ProjectXXX;
import com.DCStudios.ProjectXXX.DataStructures.Measure;
import com.DCStudios.ProjectXXX.Models.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;

public class GameRender {

	private GameWorld gameWorld;

	private SpriteBatch batch;
	private ShapeRenderer shapeRenderer;
	private OrthographicCamera camera;
	private Measure measure;

	private float zoom = 8f;

	Iterator<Entity> eIter;
	Entity entity;

	public GameRender(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
		shapeRenderer = new ShapeRenderer();

		measure = new Measure(Gdx.graphics.getWidth() / zoom,
				Gdx.graphics.getHeight() / zoom);

		camera = new OrthographicCamera();
		camera.setToOrtho(false, measure.width, measure.height);
		camera.update();

		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);

		shapeRenderer = new ShapeRenderer();
	}

	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		
		updateCameraSettings();
		
		gameWorld.render(camera);
		
		batch.begin();

		eIter = gameWorld.getEntitys().iterator();
		while (eIter.hasNext()) {
			entity = eIter.next();
			entity.draw(batch);
		}

		batch.end();

		if (ProjectXXX.debug) {
			shapeRenderer.setProjectionMatrix(camera.combined);
			shapeRenderer.begin(ShapeType.Line);
			eIter = gameWorld.getEntitys().iterator();
			while (eIter.hasNext()) {
				entity = eIter.next();
				shapeRenderer.setColor(Color.RED);
				shapeRenderer.rect(entity.getSprite().getX(),
						entity.getSprite().getY(), entity.getMeasure().width,
						entity.getMeasure().height);
			}
			shapeRenderer.end();
		}
	}

	private void updateCameraSettings() {
		if (gameWorld.getPlayer().getBody().getPosition().x + gameWorld.getPlayer().getMeasure().width / 2 <= measure.width / 2) {
		} else {
			if (gameWorld.getPlayer().getBody().getPosition().x + gameWorld.getPlayer().getMeasure().width / 2>= gameWorld.getMeasure().width - measure.width / 2) {
			} else {
				camera.position.set(gameWorld.getPlayer().getBody().getPosition().x
						+ gameWorld.getPlayer().getMeasure().width / 2,
						camera.position.y, 0);
			}

		}
		
		if (gameWorld.getPlayer().getSprite().getY() + gameWorld.getPlayer().getMeasure().height / 2 <= measure.height / 2) {
		} else {
			if (gameWorld.getPlayer().getSprite().getY() + gameWorld.getPlayer().getMeasure().height / 2 >= gameWorld.getMeasure().height - measure.height / 2) {
			} else {
				camera.position.set(camera.position.x,
						gameWorld.getPlayer().getSprite().getY() + gameWorld.getPlayer().getMeasure().height / 2, 0);
			}

		}
		camera.update();
	}

	public void dispose() {
		batch.dispose();
		shapeRenderer.dispose();
	}

}
