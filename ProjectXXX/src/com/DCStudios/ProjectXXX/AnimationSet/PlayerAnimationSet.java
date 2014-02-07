package com.DCStudios.ProjectXXX.AnimationSet;

import com.DCStudios.ProjectXXX.Animation.PlayerAnimationEast;
import com.DCStudios.ProjectXXX.Animation.PlayerAnimationNorth;
import com.DCStudios.ProjectXXX.Animation.PlayerAnimationSouth;
import com.DCStudios.ProjectXXX.Animation.PlayerAnimationWest;
import com.DCStudios.ProjectXXX.DataStructures.Direction;
import com.badlogic.gdx.graphics.Texture;

public class PlayerAnimationSet extends AnimationSet {

	@Override
	protected void setUpSet() {
		animation.put(Direction.SOUTH, new PlayerAnimationSouth());
		animation.put(Direction.NORTH, new PlayerAnimationNorth());
		animation.put(Direction.EAST, new PlayerAnimationEast());
		animation.put(Direction.WEST, new PlayerAnimationWest());
		animation.put(Direction.NORTHEAST, new PlayerAnimationEast());
		animation.put(Direction.NORTHWEST, new PlayerAnimationEast());
		animation.put(Direction.SOUTHEAST, new PlayerAnimationEast());
		animation.put(Direction.SOUTHWEST, new PlayerAnimationEast());
		
		standingTexture.put(Direction.SOUTH, new Texture("data/Character_Standing_Down.bmp"));
		standingTexture.put(Direction.NORTH, new Texture("data/Character_Standing_Up.bmp"));
		standingTexture.put(Direction.EAST, new Texture("data/Character_Standing_Right.bmp"));
		standingTexture.put(Direction.WEST, new Texture("data/Character_Standing_Left.bmp"));
		standingTexture.put(Direction.NORTHEAST, new Texture("data/Character_Standing_Down.bmp"));
		standingTexture.put(Direction.NORTHWEST, new Texture("data/Character_Standing_Down.bmp"));
		standingTexture.put(Direction.SOUTHEAST, new Texture("data/Character_Standing_Down.bmp"));
		standingTexture.put(Direction.SOUTHWEST, new Texture("data/Character_Standing_Down.bmp"));
	}

}
