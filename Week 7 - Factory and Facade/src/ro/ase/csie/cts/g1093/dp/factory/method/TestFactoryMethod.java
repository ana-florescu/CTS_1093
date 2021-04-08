package src.ro.ase.csie.cts.g1093.dp.factory.method;

import src.ro.ase.csie.cts.g1093.dp.factory.simple.AbstractWeapon;

public class TestFactoryMethod {

	public static void main(String[] args) {
		boolean isWaterModeSet = true;

		if (isWaterModeSet) {
			AbstractWeapon pistol = new WaterPistol("Grey", 2000);
		} else {
			AbstractWeapon pistol = new Pistol("grey", 200, 100);
		}
	}

}
