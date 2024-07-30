package proj;

public class User_Details {
	static String name;
	static String username;
	static String password;
	
	public User_Details(String name,String username,String password) {
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	public static String getName() {
		return name;
	}
	public static String getUsername() {
		return username;
	}
	
	public static String getPassword() {
		return password;
	}
}
