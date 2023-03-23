package com.stl.travelbooking.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import com.stl.travelbooking.exceptions.InvalidTravelDurationException;

public class PlaneTicket extends TravelTicket implements Comparable<TravelTicket>  {
	
	private TravelClass travelClass;
	private Integer seatNumber;
	private Integer stopOvers;
	
	public PlaneTicket () {
		super();
	}
	
	
	public PlaneTicket(long bookingRef, String origin, String destination, BigDecimal price,
			LocalDateTime departureTime, LocalDateTime arrivalTime, TravelClass travelClass, Integer seatNumber,
			Integer stopOvers) throws InvalidTravelDurationException {
		super(bookingRef, origin, destination, price, departureTime, arrivalTime);
		this.travelClass = travelClass;
		this.seatNumber = seatNumber;
		this.stopOvers = stopOvers;
	}
	
	public TravelClass getTravelClass() {
		return travelClass;
	}
	public void setTravelClass(TravelClass travelClass) {
		this.travelClass = travelClass;
	}
	public Integer getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}
	public Integer getStopOvers() {
		return stopOvers;
	}
	public void setStopOvers(Integer stopOvers) {
		this.stopOvers = stopOvers;
	}
	
	public void upgrade() {
		super.setPrice(getPrice().multiply(new BigDecimal("2")));
		System.out.println("You have been upgraded");
	}   
	
	public void addStopOver() {
		stopOvers++;
		System.out.println("You have " + stopOvers + " stopovers" );
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(seatNumber, stopOvers, travelClass);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlaneTicket other = (PlaneTicket) obj;
		return Objects.equals(seatNumber, other.seatNumber) && Objects.equals(stopOvers, other.stopOvers)
				&& Objects.equals(travelClass, other.travelClass);
	}


	@Override
	public String toString() {
		return "PlaneTicket [travelClass=" + travelClass + ", seatNumber=" + seatNumber + ", stopOvers=" + stopOvers
				+ "]";
	}
	
	
}
