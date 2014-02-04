package com.DCStudios.ProjectXXX.Animation;

import com.badlogic.gdx.graphics.Texture;

public class PlayerAnimationNorth extends Animation {
	public PlayerAnimationNorth() {
		//addTexture(0.0f, new Texture("data/Character_Standing_Right.png"));
		addTexture(0f, new Texture("data/Character_Right_Up.bmp"));
		addTexture(0.5f, new Texture("data/Character_Left_Up.bmp"));
		length = 1f;
		animationSpeed = 1f;
	}
}
