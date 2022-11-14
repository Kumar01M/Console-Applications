package model;

public class FlightRouteModel {
	
	private int flightNumber, noOfSeats, remainingNoOfSeats, ticketFare;
	private String flightName, arrival, departure, dateAndTime;
	private float arrivalTime, departureTime;
	
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
	public int getRemainingNoOfSeats() {
		return noOfSeats;
	}
	public void setRemainingNoOfSeats(int remainingNoOfSeats) {
		this.remainingNoOfSeats = remainingNoOfSeats;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
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
	public String toString() {
		return "\nFlight Number: "+this.flightNumber+"\nFlight Name: "+this.flightName+"\nArrival: "+this.arrival+"\tat: "+this.arrivalTime+"\nDeparture: "+this.departure+"\tat: "+this.departureTime+"\nOn: "+this.dateAndTime+"\nNumber Of Seats Available: "+this.noOfSeats+"\nTicketFare: "+this.ticketFare+"\n";
		

	}
}
