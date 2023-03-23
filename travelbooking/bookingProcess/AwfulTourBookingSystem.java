package com.stl.travelbooking.bookingProcess;

import com.stl.travelbooking.domain.TravelTicket;

public class AwfulTourBookingSystem implements BookingSystem {

	@Override
	public void setTravelTicket(TravelTicket ticket) {
		System.out.println("Awful Tours has received ticket -> " + ticket);
		

	}

	@Override
	public void requestBooking() {
		System.out.println("Awful Tours has received a booking request ");

	}

	@Override
	public boolean getStatus() {
		System.out.println("Awful Tours is providing the booking status ");
		return false;
	}

	@Override
	public boolean cancel() {
		// TODO Auto-generated method stub
		return false;
	}

}
