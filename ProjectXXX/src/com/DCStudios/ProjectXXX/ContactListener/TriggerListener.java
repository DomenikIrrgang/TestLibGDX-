package com.DCStudios.ProjectXXX.ContactListener;

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
		
		if (bodyA.getUserData() instanceof Player) {
			if (bodyB.getUserData() instanceof RunOnTrigger) {
				((RunOnTrigger) bodyB.getUserData()).setTrigger(true);
			}
		} else {
			if (bodyA.getUserData() instanceof RunOnTrigger) {
				if (bodyB.getUserData() instanceof Player) {
					((RunOnTrigger) bodyB.getUserData()).setTrigger(true);
				}	
			}
		}
	}

	@Override
	public void endContact(Contact contact) {
		Body bodyA = contact.getFixtureA().getBody();
		Body bodyB = contact.getFixtureB().getBody();
		
		if (bodyA.getUserData() instanceof Player) {
			if (bodyB.getUserData() instanceof RunOnTrigger) {
				((RunOnTrigger) bodyB.getUserData()).setTrigger(false);
			}
		} else {
			if (bodyA.getUserData() instanceof RunOnTrigger) {
				if (bodyB.getUserData() instanceof Player) {
					((RunOnTrigger) bodyB.getUserData()).setTrigger(false);
				}	
			}
		}
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
	}

}
