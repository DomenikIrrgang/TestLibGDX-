package com.DCStudios.ProjectXXX.Events;

import java.util.Iterator;

import com.DCStudios.ProjectXXX.View.GameWorld;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

public abstract class Event {

	protected GameWorld gameWorld;
	protected Array<Trigger> trigger;
	private Trigger iTrigger;
	private Iterator<Trigger> tIter;
	protected int triggerCount;

	public Event(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
		trigger = new Array<Trigger>();
		triggerCount = 0;
	}

	protected boolean isTriggered() {
		int triggerCounter = 0;
		tIter = trigger.iterator();
		while (tIter.hasNext()) {
			iTrigger = tIter.next();
			if (iTrigger.isTriggered()) {
				triggerCounter++;
			}
		}
		
		if (triggerCounter >= triggerCount) {
			return true;
		}
		return false;
	}

	protected void addTrigger(Trigger trigger) {
		this.trigger.add(trigger);
		triggerCount++;
	}

	public void update() {
		if (isTriggered()) {
			run();
		}
	}

	abstract protected void run();
}
