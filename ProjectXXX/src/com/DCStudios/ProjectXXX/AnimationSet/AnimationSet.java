package com.DCStudios.ProjectXXX.AnimationSet;

import java.util.HashMap;

import com.DCStudios.ProjectXXX.Animation.Animation;
import com.DCStudios.ProjectXXX.DataStructures.Direction;
import com.badlogic.gdx.graphics.Texture;

public abstract class AnimationSet {
	protected HashMap<Direction,Animation> animation;
	protected HashMap<Direction, Texture> standingTexture;

	protected Direction oldDirection;
	
	
	protected AnimationSet() {
		animation = new HashMap<Direction, Animation>();
		standingTexture = new HashMap<Direction, Texture>();
		setUpSet();
		oldDirection = Direction.EAST;
	}
	
	public void updateAnimation(Direction direction) {
		updateDirection(direction);
		animation.get(direction).update();
	}
	
	public Texture getAnimation(Direction direction) {
		updateDirection(direction);
		return animation.get(direction).getTextureToDraw();
	}
	
	public Texture getStandingTexture(Direction direction) {
		animation.get(direction).reset();
		return standingTexture.get(direction);
	}
	
	private void updateDirection(Direction direction) {
		if (direction != oldDirection) {
			animation.get(oldDirection).reset();
			oldDirection = direction;
		}
	}
	
	abstract protected void setUpSet(); 
}
