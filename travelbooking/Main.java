package com.stl.travelbooking;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.stl.travelbooking.bookingProcess.BookingSystem;
import com.stl.travelbooking.bookingProcess.CheapTravelBookingSystem;
import com.stl.travelbooking.bookingProcess.AwfulTourBookingSystem;
import com.stl.travelbooking.domain.BusTicket;
import com.stl.travelbooking.domain.PlaneTicket;
import com.stl.travelbooking.domain.TrainTicket;
import com.stl.travelbooking.domain.TravelClass;
import com.stl.travelbooking.domain.TravelTicket;
import com.stl.travelbooking.exceptions.InvalidTravelDurationException;
import com.stl.travelbooking.utilities.OriginSortComparator;

public class Main {
	
	public static void main(String[] args) throws InvalidTravelDurationException  {
		
		TrainTicket trainTicket = new TrainTicket();
		trainTicket.rescheduling();
		
		TrainTicket trainTicket2 = null;
		try {
			trainTicket2 = new TrainTicket(5449L,"Bangalore", "Kolkata", new BigDecimal("4567.00"),
					LocalDateTime.of(2023, 10, 14, 20, 03),
					LocalDateTime.of(2023, 10, 16, 19, 03),
					TravelClass.FIRST, 4, 24);
			trainTicket2.upgrade();
			trainTicket2.cancel();
		} catch (InvalidTravelDurationException e) {
			
			e.printStackTrace();
		}
		
		
				
		ArrayList<String> providers = new ArrayList<>();
		providers.add("First bus company");
		providers.add("Second bus company");
		providers.add("Third bus company");
		
		System.out.println(providers.size());
		System.out.println(providers);
		
		BusTicket busTicket = null;
		
		 busTicket = new BusTicket(5459L,"Bangalore", "Delhi", new BigDecimal("4567.00"),
					LocalDateTime.of(2023, 1, 31, 16, 20),
					LocalDateTime.of(2023, 10, 16, 7, 20),providers);
		 
		BusTicket busTicket2 = new BusTicket(5469L,"Howrah", "Bangalore", new BigDecimal("4567.00"),
				LocalDateTime.of(2023, 1, 31, 16, 20),
				LocalDateTime.of(2023, 10, 16, 7, 20),providers);
		
		BusTicket busTicket3 = new BusTicket(5479L,"Bangalore", "Goa", new BigDecimal("4567.00"),
				LocalDateTime.of(2023, 1, 31, 16, 20),
				LocalDateTime.of(2023, 10, 16, 7, 20),providers);
		
//		ArrayList<TravelTicket> tickets =  new ArrayList<>();
		List<TravelTicket> tickets = new LinkedList<>();
		tickets.add(busTicket);
		tickets.add(busTicket2);
		tickets.add(busTicket2);
		tickets.add(busTicket2);
		tickets.add(busTicket3);
		tickets.add(trainTicket2);
		
//		System.out.println(busTickets.get(1));
//		
//		for(int i =0; i < busTickets.size(); i++) {
//			System.out.println(busTickets.get(i));
//		}
		
		for(TravelTicket b: tickets) {
			System.out.println(b);
		}
		
		TravelTicket foundTicket = tickets.get(2);
		System.out.println(foundTicket);
		
		if(foundTicket instanceof BusTicket) {
			
			System.out.println("This is a bus ticket");
			BusTicket foundBusTicket = (BusTicket) foundTicket;
			System.out.println(foundBusTicket.getPermittedProviders()); 
		}
		else if (foundTicket instanceof TrainTicket) {
			System.out.println("This is a train ticket");
		}
		else {
			System.out.println("This is a plane ticket");
		}
		
		BusTicket busTicket4 = new BusTicket(foundTicket, providers);
		
		BookingSystem bookingSystem = new CheapTravelBookingSystem();
		
		
		bookingSystem.setTravelTicket(busTicket4);
		bookingSystem.requestBooking();
		System.out.println("The booking status is " + bookingSystem.getStatus());
		
		System.out.println(BookingSystem.getVersion());
		
		BookingSystem bookingSystem2 = BookingSystem.of(trainTicket);
		
//		Collections.sort(tickets);
		
//		Collections.sort(tickets, new OriginSortComparator());		
		
		
//		
//		Collections.sort(tickets, new Comparator<TravelTicket>(){
//			
//			public int compare(TravelTicket o1,TravelTicket o2) {
//				return o1.getDestination().compareTo(o2.getDestination());
//			}
//		});
		System.out.println(".........");
		Collections.sort(tickets, (a, b) -> a.getDepartureTime().compareTo(b.getDepartureTime()) );
		
		tickets.stream().forEach(a -> System.out.println(a) );
		
		System.out.println("-------");
		tickets.stream().filter(a -> a.getOrigin().equals("Bangalore")).forEach(a -> System.out.println(a));
		
		List<TravelTicket> londonTickets = tickets.stream().filter(a -> a.getOrigin().equals("Bangalore")).toList();
		
		//Pre java 17 version
		List<TravelTicket> londonTickets2 = tickets.stream().filter(a -> a.getOrigin().equals("Bangalore")).collect(Collectors.toList());
		
		System.out.println("**********");
		
		for(TravelTicket t : londonTickets) {
			System.out.println(t);
		}
		
		tickets.stream().map(a -> {
			a.setPrice(a.getPrice().add(new BigDecimal("10")));
			return a;
		}).forEach(a -> System.out.println(a));
	}
	
	
}
