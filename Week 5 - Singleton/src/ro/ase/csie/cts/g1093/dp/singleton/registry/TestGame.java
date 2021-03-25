package ro.ase.csie.cts.g1093.dp.singleton.registry;

public class TestGame {

	public static void main(String[] args) {
		RESTBackend back1 = RESTBackend.getRESTBackend("www.ase/cts", "data1");
		RESTBackend back2 = RESTBackend.getRESTBackend("www.ase/dam", "data2");
		

		if(back1 == back2) {
			System.out.println("They are the same object");
		}else {
			System.out.println("They are different");
		}

	}

}
