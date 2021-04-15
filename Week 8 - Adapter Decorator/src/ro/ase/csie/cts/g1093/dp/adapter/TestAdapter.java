package ro.ase.csie.cts.g1093.dp.adapter;

import java.util.ArrayList;

public class TestAdapter {

	public static void main(String[] args) {
		ACMECharacter dragon = new FantasyCharacter("Blue dragon", 1000);
		dragon.move();
		dragon.takeAHit(200);
		dragon.heal(100);
		
		DisneyActions donald = new DonaldDuck("Donald Duck", 500);
		donald.changeLocation(122, 150);
		donald.losePoints(140);
		donald.recoverPower(100);
		
		//use the adapter
		ArrayList<ACMECharacter> characters = new ArrayList<>();
		characters.add(dragon);
		Disney2ACMEAdapter donaldAdapter = new Disney2ACMEAdapter(donald);
		characters.add(donaldAdapter);
		
		System.out.println("------------------------");
		
		for(ACMECharacter hero : characters) {
			hero.move();
			hero.takeAHit(50);
		}

	}

}
