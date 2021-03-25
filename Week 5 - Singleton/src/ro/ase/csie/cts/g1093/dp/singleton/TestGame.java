package ro.ase.csie.cts.g1093.dp.singleton;

public class TestGame {

	public static void main(String[] args) {
		RESTBackend backend =  RESTBackend.getRESTBackend();
		
		UIModule uiModule = new UIModule();
		PlayerModule playerModule = new PlayerModule();
		
//		RESTBackend backend2 =  RESTBackend.getRESTBackend("wwww", "data");
//		RESTBackend backend3 =  RESTBackend.getRESTBackend("wwwwwww", "data3");
	}

}
