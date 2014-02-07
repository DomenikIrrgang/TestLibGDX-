package com.DCStudios.ProjectXXX.View;

import java.util.Iterator;

import box2dLight.RayHandler;

import com.DCStudios.ProjectXXX.BackGround.BackGround;
import com.DCStudios.ProjectXXX.ContactListener.CollisionListener;
import com.DCStudios.ProjectXXX.DataStructures.Measure;
import com.DCStudios.ProjectXXX.Events.Event;
import com.DCStudios.ProjectXXX.Models.Entity;
import com.DCStudios.ProjectXXX.Models.MoveableEntity;
import com.DCStudios.ProjectXXX.Screens.GameScreen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

public abstract class GameWorld {
	
	protected Array<Entity> entitys = new Array<Entity>();
	protected MoveableEntity player;
	protected Array<Event> events = new Array<Event>();
	
	protected World world;
	protected Box2DDebugRenderer box2DRenderer;
	protected RayHandler rayHandler;
	
	protected boolean renderLight = false;
	protected boolean renderBackGround = false;
	
	protected Measure measure;	
	protected BackGround backGround;
	
	protected GameScreen screen;	
	
	
	public GameWorld(GameScreen screen) {
		this.screen = screen;
		world = new World(new Vector2(0, 0f), false);
		box2DRenderer = new Box2DDebugRenderer();
		rayHandler = new RayHandler(world);
		world.setContactListener(new CollisionListener());		
		
	}
	
	public World getWorld() {
		return world;
	}
		
	public GameScreen getScreen() {
		return screen;
	}
	
	public Array<Entity> getEntitys() {
		return entitys;
	}
	
	public BackGround getBackGround() {
		return backGround;
	}
	
	public boolean renderBackGround() {
		return renderBackGround;
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
		Iterator<Event> eventIter = events.iterator();
		while (eventIter.hasNext()) {
			Event updateEvent = eventIter.next();
			updateEvent.update();
		}
	}
	
	public void renderPhysics(OrthographicCamera camera) {	
		world.step(1/60f, 6, 2);
		update();
		box2DRenderer.render(world, camera.combined);
		
		if (renderLight) {
			rayHandler.setCombinedMatrix(camera.combined);
			rayHandler.updateAndRender();
		}
		
	}
	
	public void dispose() {
		backGround.dispose();
		world.dispose();
		box2DRenderer.dispose();
	}
	
}
