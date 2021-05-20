package ro.ase.csie.cts.g1093.dp.observer;

public class UserNotficationsModule implements ConnectionStatusInterface{

	@Override
	public void connectionUp() {
		System.out.println("PopUp: Connection is active!");
		
	}

	@Override
	public void connectionDown() {
		System.out.println("PopUp: Connection to the server is lost!");
	}

}
