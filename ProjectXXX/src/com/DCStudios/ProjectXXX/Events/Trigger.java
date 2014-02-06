package com.DCStudios.ProjectXXX.Events;

import com.DCStudios.ProjectXXX.DataStructures.Measure;
import com.DCStudios.ProjectXXX.View.GameWorld;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;

public abstract class Trigger {
	
	protected GameWorld gameWorld;
	protected Vector2 position;
	protected Measure measure;
	
	protected boolean isTriggered;
	
	protected Body body;
	protected BodyDef bodyDef;
	protected FixtureDef fixtureDef;
	protected Shape shape;
	
	public Trigger(GameWorld gameWorld, Vector2 position, Measure measure) {
		this.gameWorld = gameWorld;
		this.position = position;
		this.measure = measure;
		isTriggered = false;
		setUpBody();
		shape.dispose();
	}
	
	private void setUpBody() {
		bodyDef = new BodyDef();
		bodyDef.type = BodyType.StaticBody;
		bodyDef.position.set(position.x + measure.width / 2, position.y + measure.height / 2);
		
		body = gameWorld.getWorld().createBody(bodyDef);
		
		shape = new PolygonShape();
		((PolygonShape) shape).setAsBox(measure.width / 2, measure.height / 2);
		
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		fixtureDef.density = 0.0f;
		fixtureDef.friction = 0.0f;
		fixtureDef.restitution = 0.0f;
		fixtureDef.isSensor = true;
		
		
		body.setFixedRotation(true);
		
		body.createFixture(fixtureDef);
		
		
		body.setUserData(this);		
	}
	
	public void setTrigger(boolean triggered) {
		isTriggered = triggered;
	}
	
	protected boolean isTriggered() {
		return isTriggered;
	}
	
}
