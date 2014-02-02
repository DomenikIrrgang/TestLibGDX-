package com.DCStudios.ProjectXXX.Models;

import java.util.HashMap;
import java.util.Iterator;

import com.DCStudios.ProjectXXX.DataStructures.Measure;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.graphics.Texture;


public abstract class AnimatedMoveableEntity extends MoveableEntity {
	
	protected Array<Texture> textures;
	protected Array<Float> textureTime;
	protected float timeGone;
	protected float length;
	protected float animationSpeed;
	
	public AnimatedMoveableEntity(Vector2 position, Measure measure,
			float rotation) {
		super(position, measure, rotation);
		textures = new Array<Texture>();
		textureTime = new Array<Float>();
		timeGone = 0f;
		length = 1f;
		animationSpeed = 1f;
	}

	@Override
	public void setWorld(World world) {
		super.setWorld(world);
	}
	
	@Override
	public void update() {
		super.update();
		timeGone += Gdx.graphics.getDeltaTime() * animationSpeed;
		
		sprite.setTexture(textures.get(getTexturePosition()));				
	}
	
	private int getTexturePosition() {
		Iterator<Float> fIter = textureTime.iterator();
		Float f;
		int i = 0;
		
		if (timeGone >= length) {
			timeGone = 0f;
		}
		
		while (fIter.hasNext()) {
			f = fIter.next();
			if (timeGone <= f.floatValue()) {
				return i;
			} else {
				i++;
			}
		}
		return 0;
	}
	
	protected void addTexture(float timeGone, Texture texture) {
		textures.add(texture);
		textureTime.add(timeGone);
	}
	
}
