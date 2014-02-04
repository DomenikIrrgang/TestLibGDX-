package com.DCStudios.ProjectXXX.Events;

import com.DCStudios.ProjectXXX.DataStructures.Measure;
import com.DCStudios.ProjectXXX.GameWorlds.TestWorld;
import com.DCStudios.ProjectXXX.View.GameWorld;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class LoadNewWorldEvent extends Event {

	public LoadNewWorldEvent(GameWorld gameWorld, Trigger ... trigger) {
		super(gameWorld);
		for (Trigger t : trigger) {
			addTrigger(t);
		}				
	}

	@Override
	protected void run() {
		gameWorld.getScreen().setNewWorld(new TestWorld(gameWorld.getScreen()));
		Gdx.app.log("test","test");
	}

}
