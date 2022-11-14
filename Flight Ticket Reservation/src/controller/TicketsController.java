package controller;

import model.FlightRouteModel;
import model.Passenger;
import model.ReservationDatabase;
import view.UserPage;

public class TicketsController {
	Input in;
	UserPage userPage;
	Passenger passenger;
	public TicketsController(UserPage userPage) {
		this.userPage = userPage;
		in = new Input();
	}
	public void bookTickets() {
		System.out.println("Enter Flight Number: ");
		FlightRouteModel flight = ReservationDatabase.getInstance().getFlightRoutes().get(in.inputInteger());
		System.out.println("Number of passengers");
		int noOfPassengers = in.inputInteger();
		if(flight.getNoOfSeats()<noOfPassengers) {
			System.out.println("Seating Capacity is less.");
		}
		System.out.println("Proceed with filling your details.");
		int nos = 1;
		while(nos++<=noOfPassengers) {
			passenger = new Passenger();
			System.out.println("Passenger Name: ");
			passenger.setPassengerName(in.inputString());
			System.out.println("ID: ");
			passenger.setPassengerID(in.inputInteger());
			System.out.println("Age: ");
			passenger.setPassengersAge(in.inputInteger());
			System.out.println("Gender[M|F|O]: ");
			passenger.setGender(in.inputString());
			
			
		}
	}
}
