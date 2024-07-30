package proj;

import java.util.Scanner;

public class Logging_Signing {
	private static User_Details users = new User_Details(null, null, null);
	 private static Train_Details reservation = new Train_Details(null, null, null, null, 0, null, null);
	 
	
	// login validity
			public boolean login(Scanner sc) {
				System.out.print("Enter username: ");
				String username = sc.next();
				System.out.print("Enter password: ");
				String password = sc.next();
				if(users!= null && users.getUsername().equals(username) && users.getPassword().equals(password)) {
					System.out.println("Login Successful"+"\n");
					return true;
				}
				else {
					System.out.println("Incorrect Username or Password.Try Again."+"\n");
					return false;
				}
			}
			//registering a new user
			public  void Register(Scanner sc) {
				System.out.print("Enter name: ");
				String name = sc.next();
				System.out.print("Enter username: ");
				String username = sc.next();
				System.out.print("Enter password: ");
				String password = sc.next();
				
				users = new User_Details(name,username,password);
				System.out.println("User Registered Successfully!!"+"\n");
			}
}
