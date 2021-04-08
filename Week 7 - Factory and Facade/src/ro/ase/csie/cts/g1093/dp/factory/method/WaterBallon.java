package src.ro.ase.csie.cts.g1093.dp.factory.method;

import src.ro.ase.csie.cts.g1093.dp.factory.simple.AbstractWeapon;

public class WaterBallon extends AbstractWeapon {
	public WaterBalloon(String color, int power) {
		super(color,power);
	}

	@Override
	public void pewPew() {
		System.out.println("Splash");
	}
}
