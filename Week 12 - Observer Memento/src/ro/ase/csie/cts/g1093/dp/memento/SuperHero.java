package ro.ase.csie.cts.g1093.dp.memento;

public class SuperHero {
	
	String name;
	int lifePoints;
	String magic;
	
	public SuperHero(String name, int lifePoints, String magic) {
		super();
		this.name = name;
		this.lifePoints = lifePoints;
		this.magic = magic;
	}
	
	public void attack() {
		System.out.println("Is attacking");
	}
	
	public void heal(int points) {
		this.lifePoints += points;
	}
	
	public void takesAHit(int points) {
		this.lifePoints -= points;
	}
	
	public HeroMemento createRestorePoint() {
		return new HeroMemento(name, lifePoints, magic);
	}
	
	public void restore(HeroMemento memento) {
		this.name = memento.name;
		this.lifePoints = memento.lifePoints;
		this.magic = memento.magic;
	}
}
