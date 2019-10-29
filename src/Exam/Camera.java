package Exam;

import java.util.Observable;
import java.util.Observer;

public class Camera implements Observer {

	private GunSlinger shooter;

	public Camera(GunSlinger newGunSlinger) {
		shooter = newGunSlinger;
	}

	public void showClip() {

		switch (shooter.getState()) {
		case "Duel":
			System.out.println(shooter.name + " : stands tickly finger");
			break;
		case "Blink":
			System.out.println(shooter.name + " : sweating blinks");
			break;
		case "Dead":
			System.out.println(shooter.name + " : knees bend falls dead");
			break;
		case "shooting":
			System.out.println(shooter.name + " : lighting fast shot");
			break;

		}
	}

	@Override
	public void update(Observable o, Object arg) {
		
		GunSlinger currentobj = (GunSlinger) o;
		
		if (o == arg || currentobj.getState().equals(("shooting"))) {
			showClip();
		}
		
	}

}
