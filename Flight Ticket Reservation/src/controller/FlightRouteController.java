package controller;

import model.FlightRouteModel;
import model.ReservationDatabase;
import view.UserPage;

public class FlightRouteController {
	Input in;
	UserPage userPage;
	FlightRouteModel flight;
	
	public FlightRouteController(UserPage userPage){
		in = new Input();
		this.userPage = userPage;
	}
	
	public void displayFlightRoutes() {
		if(ReservationDatabase.getInstance().getFlightRoutes().size()!=0) {
			System.out.println("Available Flight Schedules.");
			for(Integer flightNumber:ReservationDatabase.getInstance().getFlightRoutes().keySet()) {
				System.out.print(ReservationDatabase.getInstance().getFlightRoutes().get(flightNumber));
		}
		}
		else {
			createFlightRoutes();
			displayFlightRoutes();
			}
		}
	
	public void createFlightRoutes() {		
		System.out.print("\nNumber of Schedules: ");
		int schedules = in.inputInteger();
		while(schedules--!=0) {
			flight = new FlightRouteModel();
			System.out.print("\nFlight Number:");
			flight.setFlightNumber(in.inputInteger());
			System.out.print("Flight Name:");
			flight.setFlightName(in.inputString());
			System.out.print("Arrival:");
			flight.setArrival(in.inputString());
			System.out.print("Arrival at:");
			flight.setArrivalTime(in.inputInteger());
			System.out.print("Departure:");
			flight.setDeparture(in.inputString());
			System.out.print("Departure at:");
			flight.setDepartureTime(in.inputInteger());
			System.out.print("Number Of Seats Available:");
			flight.setNoOfSeats(in.inputInteger());
			System.out.print("TicketFare:");
			flight.setTicketFare(in.inputInteger());
			ReservationDatabase.getInstance().getFlightRoutes().put(flight.getFlightNumber(),flight);
		}
	}
	
}
