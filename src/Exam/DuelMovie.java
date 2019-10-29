package Exam;

public class DuelMovie {

	Camera camera1;
	Camera camera2;
	GunSlinger gunSlinger1;
	GunSlinger gunSlinger2;

	public DuelMovie() {

		gunSlinger1 = new GunSlinger("Lee vanCleef");
		gunSlinger2 = new GunSlinger("John Wayne");
		camera1 = new Camera(gunSlinger1);
		camera2 = new Camera(gunSlinger2);

		gunSlinger1.addObserver(camera1);
		// gunSlinger1.addObserver(camera2);

		gunSlinger2.addObserver(camera2);
		// gunSlinger2.addObserver(camera2);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DuelMovie duelMovie = new DuelMovie();

		duelMovie.demo();
	}

	private void demo() {

		gunSlinger1.SetTarget(gunSlinger1);
		gunSlinger2.SetTarget(gunSlinger2);
		gunSlinger1.blink();
		
		gunSlinger2.SetTarget(gunSlinger1);
		gunSlinger2.shoot();
		//gunSlinger2.shot();

	}

}
