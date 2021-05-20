package ro.ase.csie.cts.g1093.dp.observer;

public class TestObserver {

	public static void main(String[] args) {
		
		ServerConnectionModule connection = new ServerConnectionModule();
		ConnectionStatusInterface bacup = new BackupModule();
		ConnectionStatusInterface notifications = new UserNotficationsModule();
		
		connection.detectConnectionStatusChanged(ConnectionStatus.UP);
		
		connection.register(notifications);
		connection.register(bacup);
		
		connection.detectConnectionStatusChanged(ConnectionStatus.DOWN);
		
		connection.unregister(bacup);
		
		connection.detectConnectionStatusChanged(ConnectionStatus.UP);


	}

}
