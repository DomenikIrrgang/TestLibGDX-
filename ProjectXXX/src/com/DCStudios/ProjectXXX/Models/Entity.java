package com.DCStudios.ProjectXXX.Models;

import com.DCStudios.ProjectXXX.DataStructures.Measure;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

public abstract class Entity {
	
	protected Vector2 position;
	protected Measure measure;
	protected Rectangle bounds;
	
	protected Texture texture;
	protected Sprite sprite;
	
	protected World world;
	protected Body body;
	protected BodyDef bodyDef;
	protected FixtureDef fixtureDef;
	protected Shape shape;
	
	public Entity(Vector2 position, Measure measure) {
		this.position = position;
		this.measure = measure;
		bounds = new Rectangle(position.x, position.y, measure.width, measure.height);
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Measure getMeasure() {
		return measure;
	}

	public void setMeasure(Measure measure) {
		this.measure = measure;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	public Texture getTexture() {
		return texture;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public void update() {
		bounds.x = position.x;
		bounds.y = position.y;
	}
	
	public Body getBody() {
		return body;
	}
	
	public void draw(SpriteBatch batch) {
		//batch.draw(texture, position.x, position.y, measure.width, measure.height);
		sprite.draw(batch);
	}
		
	public void dispose() {
		texture.dispose();
	}
	
	public abstract void setWorld(World world);

}
