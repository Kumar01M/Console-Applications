package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.FlightRouteModel;
import model.ReservationDatabase;
import view.UserPage;

public class FlightRouteController {
	Input in;
	UserPage userPage;
	FlightRouteModel flight;

	public FlightRouteController(UserPage userPage) {
		in = new Input();
		this.userPage = userPage;
	}

	public void displayFlightRoutes() {
		if (ReservationDatabase.getInstance().getFlightRoutes().size() != 0) {
			System.out.println("\nAvailable Flight Schedules.");
			int count = 1;
			for (Integer flightNumber : ReservationDatabase.getInstance().getFlightRoutes().keySet()) {
				System.out.println("\nSchedule " + count++);
				System.out.print(ReservationDatabase.getInstance().getFlightRoutes().get(flightNumber));
			}
		} else {
			System.out.println("\n-No flight routes available. Create new schedules");
			createFlights(); // TODO (to be removed)
//			createFlightRoutes();
			displayFlightRoutes();
			return;
		}
	}

	public void createFlightRoutes() {
		System.out.print("\nNumber of Schedules: ");
		int schedules = in.inputInteger();
		while (schedules-- != 0) {
			flight = new FlightRouteModel();
			System.out.print("\nFlight Number:");
			flight.setFlightNumber(in.inputInteger());
			System.out.print("Flight Name:");
			flight.setFlightName(in.inputString());
			System.out.print("Arrival at:");
			flight.setArrivalTime(in.inputInteger());
			System.out.print("Departure at:");
			flight.setDepartureTime(in.inputInteger());
			System.out.print("Number Of Seats Available:");
			flight.setNoOfSeats(in.inputInteger());
			System.out.print("TicketFare:");
			flight.setTicketFare(in.inputInteger());
			ReservationDatabase.getInstance().getFlightRoutes().put(flight.getFlightNumber(), flight);
		}
	}

	// adding flights statically
	private void createFlights() {
		List<String> list = new ArrayList<>();
		flight = new FlightRouteModel();
		Collections.addAll(list, "Chennai", "Bengaluru", "Hyderabad", "Kolkata");
		flight.addFlight(new String[] { "2345", "Kolkata Airways", "Kolkata", "1.00", "Chennai", "11.00", "2", "530" },
				list);
		ReservationDatabase.getInstance().getFlightRoutes().put(2345, flight);
		flight = null;
		flight = new FlightRouteModel();
		list.clear();
		Collections.addAll(list, "Chennai", "Bengaluru", "Hyderabad", "Kolkata", "Delhi");
		flight.addFlight(new String[] { "2346", "Delhi Airways", "Delhi", "5.00", "Chennai", "23.00", "2", "530" },
				list);
		ReservationDatabase.getInstance().getFlightRoutes().put(2346, flight);
		flight = null;
		list.clear();
	}

}
