package com.DCStudios.ProjectXXX.GameWorlds;

import com.DCStudios.ProjectXXX.BackGround.TestBackGround;
import com.DCStudios.ProjectXXX.DataStructures.Measure;
import com.DCStudios.ProjectXXX.Models.Baum;
import com.DCStudios.ProjectXXX.Models.Player;
import com.DCStudios.ProjectXXX.View.GameWorld;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class TestWorld extends GameWorld {

	public TestWorld(GameWorld gameWorld) {
		super(gameWorld);
		setPlayer(new Player(new Vector2(10,10), new Measure(10, 10), 0));
		
		measure = new Measure(200, 100);
		
		addEntity(new Player(new Vector2(30,11), new Measure(10, 10), 0));
		addEntity(new Player(new Vector2(50,11), new Measure(10, 10), 0));
		addEntity(new Player(new Vector2(70,11), new Measure(10, 10), 0));
		addEntity(new Baum(new Vector2(90,50), new Measure(10, 10), 0));
		
		addGround(0,-1f,measure.width, 1f);
		addGround(-1f,0,1.0f, measure.height);
		addGround(measure.width + 1f,0,1.0f, measure.height);
		addGround(0,measure.height + 1f,measure.width, 1f);
		
		backGround = new TestBackGround();
		
		renderBackGround = true;

	}
	
	private void addGround(float x, float y, float width, float height) {
		BodyDef groundBodyDef = new BodyDef();
		groundBodyDef.position.set(x, y);
		
		Body groundBody = world.createBody(groundBodyDef);
		
		PolygonShape groundBox = new PolygonShape();
		groundBox.setAsBox(width, height);
		groundBody.createFixture(groundBox, 0.0f);
		
	}

}
