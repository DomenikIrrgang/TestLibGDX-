package com.DCStudios.ProjectXXX.Animation;

import com.DCStudios.ProjectXXX.DataStructures.Measure;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class PlayerAnimationEast extends Animation {

	public PlayerAnimationEast() {
		//addTexture(0.0f, new Texture("data/Character_Standing_Right.png"));
		addTexture(0f, new Texture("data/Character_Right_Right.bmp"));
		addTexture(0.5f, new Texture("data/Character_Left_Right.bmp"));
		length = 1f;
		animationSpeed = 1f;
	}
	

}
