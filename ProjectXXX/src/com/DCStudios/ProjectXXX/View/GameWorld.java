package com.DCStudios.ProjectXXX.View;

import java.util.Iterator;

import box2dLight.RayHandler;

import com.DCStudios.ProjectXXX.DataStructures.Measure;
import com.DCStudios.ProjectXXX.Models.Entity;
import com.DCStudios.ProjectXXX.Models.MoveableEntity;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.utils.Array;

public abstract class GameWorld {
	
	protected Array<Entity> entitys = new Array<Entity>();
	protected MoveableEntity player;
	
	protected World world;
	protected Box2DDebugRenderer box2DRenderer;
	protected RayHandler rayHandler;
	
	protected boolean renderLight = false;
	
	protected Measure measure;	
	protected Texture backGround;
	
	protected GameWorld gameWorldPointer;	
	
	public GameWorld(GameWorld gameWorld) {
		gameWorldPointer = gameWorld;
		world = new World(new Vector2(0, 0f), false);
		box2DRenderer = new Box2DDebugRenderer();
		rayHandler = new RayHandler(world);
		
	}
	
	public Array<Entity> getEntitys() {
		return entitys;
	}
	
	protected void addEntity(Entity entity) {
		entitys.add(entity);
		entity.setWorld(world);
		//entity.getBody().setType(BodyType.KinematicBody);
	}
	
	protected void setPlayer(MoveableEntity player) {
		this.player = player;
		entitys.add(this.player);
		this.player.setWorld(world);
	}
	
	public Measure getMeasure() {
		return measure;
	}
	
	public MoveableEntity getPlayer() {
		return player;
	}
	
	public void update() {
		Iterator<Entity> eIter = entitys.iterator();
		while (eIter.hasNext()) {
			Entity updateEntity = eIter.next();
			updateEntity.update();
		}		
	}
	
	public void render(OrthographicCamera camera) {	
		world.step(1/60f, 6, 2);
		update();
		box2DRenderer.render(world, camera.combined);
		
		if (renderLight) {
			rayHandler.updateAndRender();
		}
		
		
	}
	
	public void dispose() {
		backGround.dispose();
		world.dispose();
		box2DRenderer.dispose();
	}
	
}
