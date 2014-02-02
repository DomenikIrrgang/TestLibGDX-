package com.DCStudios.ProjectXXX.Models;

import com.DCStudios.ProjectXXX.DataStructures.Measure;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

public abstract class MoveableEntity extends Entity {

	protected Vector2 velocity;
	protected float rotation;
	protected float speed;
		
	protected boolean moving = false;

	public MoveableEntity(Vector2 position, Measure measure, float rotation) {
		super(position, measure);
		this.rotation = rotation;
		velocity = new Vector2(0, 0);
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	@Override
	public void update() {
		
		sprite.setPosition(body.getPosition().x - sprite.getWidth() / 2, body.getPosition().y - sprite.getHeight() / 2);
		sprite.setRotation(body.getAngle() * MathUtils.radiansToDegrees);	
		position.x = sprite.getX();
		position.y = sprite.getY();
				
		body.setLinearVelocity(velocity.x * speed, velocity.y * speed);	
		
		super.update();
	}
	
	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	
	@Override
	public void dispose() {
		super.dispose();
	}
		
	public void setWorld(World world) {
		this.world = world;
	}

}
