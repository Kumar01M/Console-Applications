package model;

import java.util.ArrayList;
import java.util.List;

public class TicketBooking {

	private int pnrNumber;
	private boolean bookingStatus;
	private int flightNumber;
	int nos;
	private List<Passenger> list;

	public TicketBooking() {
		setList(new ArrayList<>());
	}

	public boolean isBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(boolean status) {
		this.bookingStatus = status;
	}

	public int getPnrNumber() {
		return pnrNumber;
	}

	public void setPnrNumber(int pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public List<Passenger> getList() {
		return list;
	}

	public void setList(List<Passenger> list) {
		this.list = list;
	}

}
