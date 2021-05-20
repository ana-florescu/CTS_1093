package ro.ase.csie.cts.g1093.dp.memento;

public class TestMemento {

	public static void main(String[] args) {
		//don't clone your objects when you want to save its state
		SuperHero superman = new SuperHero("Superman", 100, "Fly");
		
		HeroMemento initialSave = superman.createRestorePoint();
		
		superman.takesAHit(50);
		superman.takesAHit(20);
		
		System.out.println("Lifepoints: " + superman.lifePoints);
		
		superman.restore(initialSave);
		
		System.out.println("Lifepoints: " + superman.lifePoints);

	}

}
