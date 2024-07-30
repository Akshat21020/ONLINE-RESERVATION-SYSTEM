package proj;

import java.util.Scanner;	
	public class User_Interface {
		
		 private static Logging_Signing log = new Logging_Signing();
		 private static Reservation_Services reservation = new Reservation_Services();
		 
		public static void main(String[] args) {
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
						isLoggedin = log.login(sc);
						break;
						
					case 2 : 
						log.Register(sc);
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
					System.out.println("Welcome "+ User_Details.getName()+".");
					System.out.println("1. Make a reservation");
					System.out.println("2. Cancel a reservation");
					System.out.println("3. View reservations");
					System.out.println("4. Exit"+"\n");
					System.out.print("Enter a choice: ");
					int choice = sc.nextInt();
					switch(choice) {
					case 1 :
						Reservation_Services.makereservation(sc);
						System.out.println("Reservation Successful. Your PNR Number is "+ reservation.generatePNR()+"\n");
						break;
					case 2 :
						Reservation_Services.cancelreservations(sc);
						break;
					case 3 : 
						Reservation_Services.viewreservation(sc);
						break;
					case 4 :
						System.out.println("Goodbye!");
						System.exit(0);
					default :
						System.out.println("Invalid Choice. Try Again.");
					}
				}
			}
		}
	}
		
