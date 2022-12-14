package view;

import controller.Input;
import controller.TicketsController;
import controller.FlightRouteController;

public class UserPage {
	Input in;
	FlightRouteController routesController; 
	TicketsController ticketController;
	
	public UserPage() {
		routesController = new FlightRouteController(this);
		ticketController = new TicketsController(this);
		in = new Input();
	}
	
	public void menu() {
		System.out.println("Welcome to Indian Airways.");
		boolean openMenu = true;
		while(openMenu) {
			System.out.println("(1.Book Tickets | 2.Flight Routes | 3.Check Ticket Status | 4.Search For Passenger"
					+ " | 5.Bookings List | 6.Cancel Tickets | 7.Exit)");
			int choice = in.inputInteger();
			switch(choice){
			case 1:
				routesController.displayFlightRoutes();
				ticketController.bookTickets();
				break;
			case 2:
				routesController.displayFlightRoutes();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				openMenu = false;
				break;
			default:
				System.out.println("Invalid Input Click (1-7)");
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		new UserPage().menu();
	}
}
