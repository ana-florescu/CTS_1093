package src.ro.ase.csie.cts.g1093.dp.facade;

public class UserAPIFacade {

	//tghe facade method
	public static String getUserProfile(String username, String pass) {
		// 1.Create a game server instance and connect
				GameServer server = new GameServer();
				server.connect();
				
				//2. Create a login
				LogIn login = new LogIn("player1", "1234");
				login.login();
				
				//3. Get user profile
				UserProfile userProfile = login.getUserProfile();
		     	String profile = userProfile.getProfile();
		     	
		     	return profile;
	}
}
