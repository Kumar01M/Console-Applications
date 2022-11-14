package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReservationDatabase {
	
	private static ReservationDatabase database;
	private Map<Integer, FlightRouteModel> flightRoutes;
	private Map<Integer, Passenger> passengers;
	private List<Passenger> passengersList;
	private Queue<TicketBooking> bookingsList;

	private ReservationDatabase(){
		setFlightRoutes(new HashMap<>());
		passengersList = new ArrayList<>();
		bookingsList = new PriorityQueue<>();
		
	}
	public static ReservationDatabase getInstance() {
		if(database == null) {
			database = new ReservationDatabase();
		}
		return database;
	}
	
	public List<Passenger> getPassengersList() {
		return passengersList;
	}
	public void setPassengersList(List<Passenger> passengersList) {
		this.passengersList = passengersList;
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
}
