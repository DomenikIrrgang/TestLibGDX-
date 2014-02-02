package com.DCStudios.ProjectXXX.Models;

import com.DCStudios.ProjectXXX.DataStructures.Measure;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class Baum extends MoveableEntity {
	
	public Baum(Vector2 position, Measure measure, float rotation) {
		super(position, measure, rotation);
		texture = new Texture("data/baum.png");
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		speed = 0;
	}
	
	@Override
	public void setWorld(World world) {
		this.world = world;
		
		bodyDef = new BodyDef();
		bodyDef.type = BodyType.KinematicBody;
		bodyDef.position.set(position.x + measure.width / 2, position.y + measure.height / 2);
		
		body = this.world.createBody(bodyDef);
		
		shape = new PolygonShape();
		((PolygonShape) shape).setAsBox(measure.width / 2 - 0.5f, measure.height / 2 - 0.5f);
		
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		fixtureDef.density = 1.0f;
		fixtureDef.friction = 1.0f;
		fixtureDef.restitution = 1.0f;
		body.setFixedRotation(true);
		
		body.createFixture(fixtureDef); 
		
		sprite = new Sprite(texture);
		sprite.setSize(measure.width, measure.height);
		sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);
		//sprite.setPosition(position.x, position.y);
		body.setUserData(this);				
	}
}
