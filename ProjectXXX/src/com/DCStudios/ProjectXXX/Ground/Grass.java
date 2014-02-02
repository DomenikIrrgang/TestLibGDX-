package com.DCStudios.ProjectXXX.Ground;

import com.DCStudios.ProjectXXX.DataStructures.Measure;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Grass extends Ground {

	public Grass(Vector2 position, Measure measure) {
		super(position, measure);
		texture = new Texture("data/grass.jpg");
		setUpSprite();
	}

}
