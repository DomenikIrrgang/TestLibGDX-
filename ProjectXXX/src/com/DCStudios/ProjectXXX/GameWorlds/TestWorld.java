package com.DCStudios.ProjectXXX.GameWorlds;

import box2dLight.ConeLight;
import box2dLight.Light;
import box2dLight.PointLight;
import box2dLight.RayHandler;

import com.DCStudios.ProjectXXX.BackGround.TestBackGround;
import com.DCStudios.ProjectXXX.DataStructures.Measure;
import com.DCStudios.ProjectXXX.Events.LoadNewWorldEvent;
import com.DCStudios.ProjectXXX.Events.RunOffTrigger;
import com.DCStudios.ProjectXXX.Events.RunOnTrigger;
import com.DCStudios.ProjectXXX.Models.Baum;
import com.DCStudios.ProjectXXX.Models.Player;
import com.DCStudios.ProjectXXX.Screens.GameScreen;
import com.DCStudios.ProjectXXX.View.GameWorld;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class TestWorld extends GameWorld {

	public TestWorld(GameScreen screen) {
		super(screen);
		setPlayer(new Player(new Vector2(10, 10), new Measure(10, 10), 0));

		measure = new Measure(200, 100);

		addEntity(new Player(new Vector2(30, 11), new Measure(10, 10), 0));
		addEntity(new Player(new Vector2(50, 11), new Measure(10, 10), 0));
		addEntity(new Player(new Vector2(70, 11), new Measure(10, 10), 0));
		addEntity(new Baum(new Vector2(90, 50), new Measure(10, 10)));

		addGround(0, -1f, measure.width, 1f);
		addGround(-1f, 0, 1.0f, measure.height);
		addGround(measure.width + 1f, 0, 1.0f, measure.height);
		addGround(0, measure.height + 1f, measure.width, 1f);

		backGround = new TestBackGround();
		events.add(new LoadNewWorldEvent(
				this,
				new RunOnTrigger(this, new Vector2(150, 80), new Measure(10, 10)),
				new RunOnTrigger(this, new Vector2(40, 80), new Measure(10, 10)),
				new RunOffTrigger(this, new Vector2(95, 30), new Measure(10, 10))));

		renderBackGround = true;
		RayHandler.useDiffuseLight(true);
		
		Light light = new PointLight(rayHandler, 200, new Color(0.5f, 0.3f, 0.6f, 0.5f), 250, 40, 40);
		Light.setContactFilter((short) 10, (short) 10, (short) 10);
		new ConeLight(rayHandler, 200, Color.RED, 200, measure.width / 2 + 50,
				measure.height / 2 + 15, 270, 35);
		renderLight = true;

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
