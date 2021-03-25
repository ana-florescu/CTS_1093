package ro.ase.csie.cts.g1093.dp.singleton.staticversion;

public class RESTBackend {
	
	String url;
	String data;

	public static final RESTBackend theBackend;

    static {
    	System.out.println("Is executed when the class is loaded by the JVM");
        theBackend = new RESTBackend();
        theBackend.url = "www.ase.ro";
    }
    {
    	System.out.println("Is executed before any constructor call");
    }

    private RESTBackend() {
    }
}
