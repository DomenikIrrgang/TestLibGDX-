package com.DCStudios.ProjectXXX.ContactListener;

import com.DCStudios.ProjectXXX.Events.RunOffTrigger;
import com.DCStudios.ProjectXXX.Events.RunOnTrigger;
import com.DCStudios.ProjectXXX.Models.Player;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

public class TriggerListener implements ContactListener {

	@Override
	public void beginContact(Contact contact) {
		Body bodyA = contact.getFixtureA().getBody();
		Body bodyB = contact.getFixtureB().getBody();
		
		checkRunOnTrigger(bodyA, bodyB, true);
		checkRunOffTrigger(bodyA, bodyB, false);
	}

	@Override
	public void endContact(Contact contact) {
		Body bodyA = contact.getFixtureA().getBody();
		Body bodyB = contact.getFixtureB().getBody();
		
		checkRunOnTrigger(bodyA, bodyB, false);
		checkRunOffTrigger(bodyA, bodyB, true);
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
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
