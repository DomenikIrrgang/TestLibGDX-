package com.DCStudios.ProjectXXX.ContactListener;

import com.DCStudios.ProjectXXX.Events.RunOffTrigger;
import com.DCStudios.ProjectXXX.Models.Player;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;

public class MoveOffTriggerCollision implements CollisionHandler {

	@Override
	public void startCollision(Contact contact) {
		checkRunOffTrigger(contact.getFixtureA().getBody(), contact.getFixtureB().getBody(), false);
	}

	@Override
	public void endCollision(Contact contact) {
		checkRunOffTrigger(contact.getFixtureA().getBody(), contact.getFixtureB().getBody(), true);
	}
	
	private void checkRunOffTrigger(Body bodyA, Body bodyB, boolean setTrigger) {
		if (bodyA.getUserData() instanceof Player) {
			if (bodyB.getUserData() instanceof RunOffTrigger) {
				((RunOffTrigger) bodyB.getUserData()).setTrigger(setTrigger);
			}
		} else {
			if (bodyA.getUserData() instanceof RunOffTrigger) {
				if (bodyB.getUserData() instanceof Player) {
					((RunOffTrigger) bodyB.getUserData()).setTrigger(setTrigger);
				}	
			}
		}
	}

}
