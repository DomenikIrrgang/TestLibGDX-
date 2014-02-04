package com.DCStudios.ProjectXXX.Animation;

import com.badlogic.gdx.graphics.Texture;

public class PlayerAnimationSouth extends Animation {
	public PlayerAnimationSouth() {
		// addTexture(0.0f, new Texture("data/Character_Standing_Right.png"));
		addTexture(0f, new Texture("data/Character_Right_Down.bmp"));
		addTexture(0.5f, new Texture("data/Character_Left_Down.bmp"));
		length = 1f;
		animationSpeed = 1f;
	}
}
