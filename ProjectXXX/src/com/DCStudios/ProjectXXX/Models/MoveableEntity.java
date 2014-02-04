package com.DCStudios.ProjectXXX.Models;

import java.util.HashMap;

import com.DCStudios.ProjectXXX.Animation.Animation;
import com.DCStudios.ProjectXXX.DataStructures.Direction;
import com.DCStudios.ProjectXXX.DataStructures.Measure;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
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
	protected boolean isMoving;
		
	protected Direction direction, oldDirection;
	protected HashMap<Direction,Animation> animation;
	protected HashMap<Direction, Texture> standingTexture;
		

	public MoveableEntity(Vector2 position, Measure measure, float rotation) {
		super(position, measure);
		this.rotation = rotation;
		velocity = new Vector2(0, 0);
		animation = new HashMap<Direction, Animation>();
		standingTexture = new HashMap<Direction, Texture>();
		isMoving = false;
		direction = Direction.SOUTH;
		oldDirection = Direction.SOUTH;
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
	
	private void updateDirection() {
		oldDirection = direction;
		if (velocity.x == 1) {
			if (velocity.y == -1) {
				direction = Direction.SOUTHEAST;
			} else {
				if (velocity.y == 1) {
					direction = Direction.NORTHEAST;
				} else {
					direction = Direction.EAST;
				}
			}
		} else {
			if (velocity.x == -1) {
				if (velocity.y == -1) {
					direction = Direction.SOUTHWEST;
				} else {
					if (velocity.y == 1) {
						direction = Direction.NORTHWEST;
					} else {
						direction = Direction.WEST;
					}
				}
			} else {
				if (velocity.y == 1) {
					direction = Direction.NORTH;
				} else {
					if (velocity.y == -1) {
						direction = Direction.SOUTH;
					}
				}
			}
		}
	}

	private void resetOldAnimation() {
		if (oldDirection != direction)
			animation.get(oldDirection).reset();
	}
	
	private void updateTexture() {
		if (isMoving) {
			animation.get(direction).update();
			sprite.setTexture(animation.get(direction).getTextureToDraw());
		} else {
			sprite.setTexture(standingTexture.get(direction));
		}
	}
	
	private void updateMoving() {
		if (velocity.x != 0 || velocity.y != 0) {
			isMoving = true;
		} else {
			isMoving = false;
		}
	}
	@Override
	public void update() {
				
		updateDirection();
		resetOldAnimation();
		updateMoving();
		updateTexture();
		super.update();
				
		body.setLinearVelocity(velocity.x * speed, velocity.y * speed);		
		//body.applyForceToCenter(velocity.x * speed, velocity.y * speed, true);
	}
	
	@Override
	public void dispose() {
		super.dispose();
	}
		
	public void setWorld(World world) {
		this.world = world;
	}

}
