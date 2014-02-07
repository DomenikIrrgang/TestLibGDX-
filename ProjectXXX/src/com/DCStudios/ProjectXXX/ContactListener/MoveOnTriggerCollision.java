package com.DCStudios.ProjectXXX.ContactListener;

import com.DCStudios.ProjectXXX.Events.RunOnTrigger;
import com.DCStudios.ProjectXXX.Models.Player;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;

public class MoveOnTriggerCollision implements CollisionHandler {

	@Override
	public void startCollision(Contact contact) {
		checkRunOnTrigger(contact.getFixtureA().getBody(), contact.getFixtureB().getBody(), true);
	}

	@Override
	public void endCollision(Contact contact) {
		checkRunOnTrigger(contact.getFixtureA().getBody(), contact.getFixtureB().getBody(), false);
	}
	
	private void checkRunOnTrigger(Body bodyA, Body bodyB , boolean setTrigger) {
		if (bodyA.getUserData() instanceof Player) {
			if (bodyB.getUserData() instanceof RunOnTrigger) {
				((RunOnTrigger) bodyB.getUserData()).setTrigger(setTrigger);
			}
		} else {
			if (bodyA.getUserData() instanceof RunOnTrigger) {
				if (bodyB.getUserData() instanceof Player) {
					((RunOnTrigger) bodyB.getUserData()).setTrigger(setTrigger);
				}	
			}
		}
	}

}
