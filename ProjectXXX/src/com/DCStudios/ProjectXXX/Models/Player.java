package com.DCStudios.ProjectXXX.Models;

import java.awt.Rectangle;

import com.DCStudios.ProjectXXX.Animation.PlayerAnimationEast;
import com.DCStudios.ProjectXXX.Animation.PlayerAnimationNorth;
import com.DCStudios.ProjectXXX.Animation.PlayerAnimationSouth;
import com.DCStudios.ProjectXXX.Animation.PlayerAnimationWest;
import com.DCStudios.ProjectXXX.DataStructures.Direction;
import com.DCStudios.ProjectXXX.DataStructures.Measure;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Player extends MoveableEntity {

	public Player(Vector2 position, Measure measure, float rotation) {
		super(position, measure, rotation);
		texture = new Texture("data/player.png");
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
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
		standingTexture.put(Direction.NORTHEAST, texture);
		standingTexture.put(Direction.NORTHWEST, texture);
		standingTexture.put(Direction.SOUTHEAST, texture);
		standingTexture.put(Direction.SOUTHWEST, texture);
		speed = 20;
	}

	@Override
	public void setWorld(World world) {
		super.setWorld(world);
		
		bodyDef = new BodyDef();
		bodyDef.type = BodyType.DynamicBody;
		bodyDef.position.set(position.x + measure.width / 2, position.y + measure.height / 2);
		
		body = this.world.createBody(bodyDef);
		
		shape = new PolygonShape();
		((PolygonShape) shape).setAsBox(measure.width / 2, measure.height / 2);
		
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		fixtureDef.density = 1.0f;
		fixtureDef.friction = 0.0f;
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
