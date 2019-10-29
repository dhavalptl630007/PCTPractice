package Exam;

import java.util.Observable;

public class GunSlinger extends Observable {

	private String state;
	GunSlinger target;
	String name;

	public GunSlinger(String newName) {
		name = newName;
	}

	public String getState() {
		return state;
	}

	private void setState(String newState) {
		state = newState;
		setChanged();
		notifyObservers(target);
	}

	public void SetTarget(GunSlinger newTarget) {
		target = newTarget;
		setState("Duel");
	}

	public void shot() {
		setState("Dead");
	}

	public void shoot() {

		setState("shooting");
	    target.shot();	
	}

	public void blink() {
		setState("Blink");
	}

}
