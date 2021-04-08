package src.ro.ase.csie.cts.g1093.dp.facade;

public class TestFacade {

	public static void main(String[] args) {
		// 1.Create a game server instance and connect
		GameServer server = new GameServer();
		server.connect();
		
		//2. Create a login
		LogIn login = new LogIn("player1", "1234");
		login.login();
		
		//3. Get user profile
		UserProfile userProfile = login.getUserProfile();
     	String profile = userProfile.getProfile();	
     	
     	String profile2 = UserAPIFacade.getUserProfile("player 2", "12345");
	
	}

}
