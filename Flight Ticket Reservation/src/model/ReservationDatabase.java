package model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ReservationDatabase {

	private static ReservationDatabase database;
	private Map<Integer, FlightRouteModel> flightRoutes;
	private Map<Integer, Passenger> passengersList;
	private Queue<TicketBooking> bookingsList;
	private Map<Integer, TicketBooking> bookMap;

	private ReservationDatabase() {
		flightRoutes = new HashMap<>();
		passengersList = new HashMap<>();
		bookingsList = new LinkedList<>();
		bookMap = new HashMap<>();
	}

	public static ReservationDatabase getInstance() {
		if (database == null) {
			database = new ReservationDatabase();
		}
		return database;
	}

	public Queue<TicketBooking> getBookingsList() {
		return bookingsList;
	}

	public void setBookingsList(Queue<TicketBooking> bookingsList) {
		this.bookingsList = bookingsList;
	}

	public Map<Integer, FlightRouteModel> getFlightRoutes() {
		return flightRoutes;
	}

	public void setFlightRoutes(Map<Integer, FlightRouteModel> flightRoutes) {
		this.flightRoutes = flightRoutes;
	}

	public Map<Integer, Passenger> getPassengersList() {
		return passengersList;
	}

	public void setPassengersList(Map<Integer, Passenger> passengersList) {
		this.passengersList = passengersList;
	}

	public Map<Integer, TicketBooking> getBookMap() {
		return bookMap;
	}

	public void setBookMap(Map<Integer, TicketBooking> bookMap) {
		this.bookMap = bookMap;
	}
}
