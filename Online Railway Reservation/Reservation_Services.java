package proj;

import java.util.Scanner;

public class Reservation_Services {

	private static User_Details users = new User_Details(null, null, null);
	 private static Train_Details reservation = new Train_Details(null, null, null, null, 0, null, null);
	 
	// Making Reservations
			public static Train_Details makereservation(Scanner sc) {
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
				return new Train_Details(from, to, t, cl, ticket, dd,rd);
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
			public int generatePNR() {
				return (int) (Math.random()*1000000) ;
			}
}
