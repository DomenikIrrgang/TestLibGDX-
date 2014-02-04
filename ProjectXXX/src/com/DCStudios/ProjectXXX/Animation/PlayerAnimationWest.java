package com.DCStudios.ProjectXXX.Animation;

import com.badlogic.gdx.graphics.Texture;

public class PlayerAnimationWest extends Animation {
	public PlayerAnimationWest() {
		//addTexture(0.0f, new Texture("data/Character_Standing_Right.png"));
		addTexture(0f, new Texture("data/Character_Right_Left.bmp"));
		addTexture(0.5f, new Texture("data/Character_Left_Left.bmp"));
		length = 1f;
		animationSpeed = 1f;
	}
}
