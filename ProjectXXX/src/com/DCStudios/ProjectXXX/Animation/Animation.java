package com.DCStudios.ProjectXXX.Animation;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public abstract class Animation {
	protected Array<Texture> textures;
	protected Array<Float> textureTime;
	protected float timeGone;
	protected float length;
	protected float animationSpeed;
	
	public Animation() {
		textures = new Array<Texture>();
		textureTime = new Array<Float>();
		timeGone = 0f;
		length = 1f;
		animationSpeed = 1f;
	}
	
	public void update() {
		timeGone += Gdx.graphics.getDeltaTime() * animationSpeed;		
	}
	
	public Texture getTextureToDraw() {
		return textures.get(getTexturePosition());
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
	
	public void reset() {
		timeGone = 0f;
	}
}
