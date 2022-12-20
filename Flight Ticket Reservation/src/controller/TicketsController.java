package controller;

import model.FlightRouteModel;
import model.Passenger;
import model.ReservationDatabase;
import model.TicketBooking;
import view.UserPage;

public class TicketsController {
	Input in;
	UserPage userPage;
	Passenger passenger;
	TicketBooking ticket;
	
	public TicketsController(UserPage userPage) {
		this.userPage = userPage;
		in = new Input();
	}
	public void bookTickets() {
		boolean rac = false;
		System.out.println("\nBook Your Tickets Now");
		System.out.print("\nEnter Flight Number: ");
		FlightRouteModel flight = ReservationDatabase.getInstance().getFlightRoutes().get(in.inputInteger());
		if(flight==null) {
			System.out.println("Invalid flight number.");
			return;
		}
		System.out.print("Number of passengers: ");
		int noOfPassengers = in.inputInteger();
		if(flight.getNoOfSeats()<noOfPassengers) {
			rac = true;
			System.out.println("You're in RAC. [1] to continue");
			if(in.inputInteger()!=1)
					return;
		}
		ticket = new TicketBooking();
		System.out.println("--Proceed with filling your details.--");
		int nos = 1;
		int pnrGen = Integer.valueOf(2022+""+nos+""+flight.getFlightNumber());//update to current date
		ticket.setPnrNumber(pnrGen);
		while(nos<=noOfPassengers) {
			passenger = new Passenger();
			System.out.println("\nPassenger "+ nos++ +"\n");
			System.out.print("Passenger Name: ");
			passenger.setPassengerName(in.inputString());
			System.out.print("Aadhar ID: ");
			passenger.setPassengerID(in.inputInteger());
			System.out.print("Age: ");
			passenger.setPassengersAge(in.inputInteger());
			System.out.print("Gender[M|F|O]: ");
			passenger.setGender(in.inputString());
			passenger.setPnrNumber(pnrGen);
			ReservationDatabase.getInstance().getPassengersList().put(passenger.getPassengerID(), passenger);
			ticket.getList().add(passenger);
			System.out.println();
		}
		ReservationDatabase.getInstance().getBookMap().put(pnrGen, ticket);
		ReservationDatabase.getInstance().getBookingsList().add(ticket);
		if(rac)
			System.out.println("\n-Your request added to queue, check ticket status for further information.\n");
		else 
			System.out.println("\nTicket(s) booked successfully.\n");
	}
}
