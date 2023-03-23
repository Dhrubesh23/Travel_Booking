package com.stl.travelbooking.bookingProcess;

import com.stl.travelbooking.domain.TravelTicket;

public class CheapTravelBookingSystem implements BookingSystem {

	@Override
	public void setTravelTicket(TravelTicket ticket) {
		System.out.println("CheapTravel has received ticket " + ticket);

	}

	@Override
	public void requestBooking() {
		System.out.println("CheapTravel has had a booking request ");

	}

	@Override
	public boolean getStatus() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancel() {
		// TODO Auto-generated method stub
		return false;
	}

}
