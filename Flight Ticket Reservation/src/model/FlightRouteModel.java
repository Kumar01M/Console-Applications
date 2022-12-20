package model;

import java.util.ArrayList;
import java.util.List;

public class FlightRouteModel {
	
	private int flightNumber, noOfSeats, ticketFare;
	private String flightName, dateAndTime;
	private float arrivalTime, departureTime;
	private List<String> routes;
	
	public void addFlight(String[] args, List<String> routes) {
		this.flightNumber = Integer.parseInt(args[0]);
		this.flightName = args[1];
		//this.arrival = args[2];
		this.arrivalTime = Float.parseFloat(args[3]);
		//this.departure = args[4];
		this.departureTime = Float.parseFloat(args[5]);
		this.noOfSeats = Integer.parseInt(args[6]);
		this.ticketFare = Integer.parseInt(args[6]);
		this.routes = new ArrayList<>(routes);
	}
	
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int totalNoOfSeats) {
		this.noOfSeats = totalNoOfSeats;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	public float getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(float arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public float getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(float departureTime) {
		this.departureTime = departureTime;
	}
	public int getTicketFare() {
		return ticketFare;
	}
	public void setTicketFare(int ticketFare) {
		this.ticketFare = ticketFare;
	}
	public List<String> getRoutes() {
		return routes;
	}
	public void setRoutes(List<String> routes) {
		this.routes = routes;
	}
	public String toString() {
		
		String routes = (this.routes).toString();	
		return "\n- - - - -\nFlight Number: "+this.flightNumber+"\nFlight Name: "+this.flightName+"\nArrival: "+this.routes.get(this.routes.size()-1)+"\tat: "+this.arrivalTime+"\nDeparture: "+this.routes.get(0)+"\tat: "+this.departureTime+"\nOn: "+this.dateAndTime+"\nNumber Of Seats Available: "+this.noOfSeats+"\nTicketFare: "+this.ticketFare+"\n"+"Routes: "+routes+"\n- - - - -\n";
		

	}
}
