package src.ro.ase.csie.cts.g1093.dp.factory.method;

public class WaterBucket AbstractWeapon {
	public WaterBucket(String color, int power) {
		super(color,power);
	}

	@Override
	public void pewPew() {
		System.out.println("Splash");
	}
}
