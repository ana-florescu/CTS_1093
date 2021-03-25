package ro.ase.csie.cts.g1093.dp.singleton;

public class RESTBackend {
	String url;
	String data;

	//eager-instantiation
	//private static RESTBackend thebackend = new RESTBackend()
	
	private static RESTBackend theBackend = null;
	
	private RESTBackend(String url, String data) {
		System.out.println("Opening a connection to the backend service");
		this.url = url;
		this.data = data;
	}

	private RESTBackend() {

	}

	public void sendGET() {
		System.out.println("Send GET command to " + this.url);
	}

	//lazy instantiation example - the conn is created only when someone need it
	//synchronized is used in a multi threading situation
	public static synchronized RESTBackend getRESTBackend() {
		if (theBackend == null) {
			//get the backend data from a config/settings file
			String url = "www.acs.ase.ro/game";
			String data = "get backend connection";
			theBackend = new RESTBackend(url, data);
        }
        return theBackend;
	}
	
//	public static synchronized RESTBackend getRESTBackend(String url, String data) {
//		if (theBackend == null) {
//			theBackend = new RESTBackend(url, data);
//        }
//        return theBackend;
//	}
	
}
