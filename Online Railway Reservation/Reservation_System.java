package proj;

import java.util.Scanner;	
	
	class user {
		String name;
		String username;
		String password;
		
		public user(String name,String username,String password) {
			this.name = name;
			this.username = username;
			this.password = password;
		}
		
		public String getName() {
			return name;
		}
		public String getUsername() {
			return username;
		}
		
		public String getPassword() {
			return password;
		}
	}
	
	class train_details {
		String from;
		String to;
		String trainname;
		String classtype;
		int no_oftickets;
		String departure_date;
		String return_date;
		int PNR_number;
		
		public train_details(String from,String to,String trainname,String classtype,int no_oftickets,String departure_date,String return_date) {
			this.from = from;
			this.to = to;
			this.trainname = trainname;
			this.classtype = classtype;
			this.no_oftickets = no_oftickets;
			this.departure_date = departure_date;
			this.return_date = return_date;
		}
		public String getDeparture() {
			return from;
		}
		public String getDestination() {
			return to;
		}
		public String getTrainname() {
			return trainname;
		}
		public String getClasstype() {
			return classtype;
		}
		public int getNooftickets(){
			return no_oftickets;
		}
		public String getDeparture_Date() {
			return departure_date;
		}
		public String getReturn_Date() {
			return return_date;
		}
		public int getPNR() {
			return PNR_number;
		}
		public int generatePNR() {
			return (int) (Math.random()*1000000) ;
		}
	}
	
	public class Reservation_System {
		 private static user users;
		 private static train_details reservation;
		 
		 public Reservation_System() {
			 this.users = null;
			 this.reservation = null;
		 }
		 
		public static void main(String[] args) {
			Reservation_System system = new Reservation_System();
			Scanner sc = new Scanner(System.in);
			boolean isLoggedin = false;
			while(true) {
				if(!isLoggedin) {
					System.out.println("Welcome to Online Train Reservation System");
					System.out.println("1. Login");
					System.out.println("2. Register");
					System.out.println("3. Exit"+"\n");
					System.out.print("Enter your choice: ");
					int choice = sc.nextInt();
					
					switch(choice) {
					case 1 :
						isLoggedin = login(sc);
						break;
						
					case 2 : 
						Register(sc);
						break;
						
					case 3 :
						System.out.println("Exiting....");
						System.out.println("Exited.");
						System.exit(0);

					default :
						System.out.println("Invalid Choice. Try Again.");
					}
				}
				else {
					System.out.println("Welcome "+ system.users.getName()+".");
					System.out.println("1. Make a reservation");
					System.out.println("2. Cancel a reservation");
					System.out.println("3. View reservations"+"\n");
					System.out.print("Enter a choice: ");
					int choice = sc.nextInt();
					switch(choice) {
					case 1 :
						system.reservation = makereservation(sc);
						System.out.println("Reservation Successful. Your PNR Number is "+ system.reservation.generatePNR());
						break;
					case 2 :
						cancelreservations(sc);
						break;
					case 3 : 
						viewreservation(sc);
						break;
					default :
						System.out.println("Invalid Choice. Try Again.");
					}
				}
			}
		}
		// login validity
		public static boolean login(Scanner sc) {
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
		public static void Register(Scanner sc) {
			System.out.print("Enter name: ");
			String name = sc.next();
			System.out.print("Enter username: ");
			String username = sc.next();
			System.out.print("Enter password: ");
			String password = sc.next();
			
			users = new user(name,username,password);
			System.out.println("User Registered Successfully!!"+"\n");
		}
		
		// Making Reservations
		public static train_details makereservation(Scanner sc) {
			System.out.print("From: ");
			String from = sc.next();
			System.out.print("To: ");
			String to = sc.next();
			System.out.print("Train name: ");
			String t = sc.next();
			System.out.print("Class type: ");
			String cl = sc.next();
			System.out.print("No. of tickets: ");
			int ticket = sc.nextInt();
			System.out.print("Departure Date (DD/MM/YYYY format): ");
			String dd = sc.next();
			System.out.print("Return Date (DD/MM/YYYY format): "+"\n");
			String rd = sc.next();
			return new train_details(from, to, t, cl, ticket, dd,rd);
		}
		
		// Canceling Reservations
		public static void cancelreservations(Scanner sc) {
			if(reservation == null) {
				System.out.println("No reservations found.");
				return;
			}
			System.out.print("Enter PNR number: ");
			int pnr = sc.nextInt();
			if(reservation.getPNR() == pnr) {
				System.out.println("Are you sure you want to cancel the reservation? (yes/no)");
				String c = sc.next();
				if(c == "yes") {
					reservation = null;
					System.out.println("Reservation Cancelled"+"\n");
				}
				else {
					System.out.println("Reservation Not cancelled"+"\n");
				}
			}
			else {
				System.out.println("Invalid PNR number."+"\n");
			}
		}
		
		// View Reservations
		public static void viewreservation(Scanner sc) {
			if(reservation == null) {
				System.out.println("No reservations"+"\n");
				return;
			}
			System.out.print("Enter PNR Number: ");
			int pnr = sc.nextInt();
			if(reservation.getPNR() == pnr) {
				System.out.println("From: "+ reservation.getDeparture());
				System.out.println("To: "+ reservation.getDestination());
				System.out.println("Train Name: "+ reservation.getTrainname());
				System.out.println("Class: "+ reservation.getClasstype());
				System.out.println("Total Tickets: "+ reservation.getNooftickets());
				System.out.println("Departure Date: "+ reservation.getDeparture_Date());
				System.out.println("Return Date: "+ reservation.getReturn_Date());
			}
			else {
				System.out.println("Invalid PNR"+"\n");
			}
		}
	}
		
