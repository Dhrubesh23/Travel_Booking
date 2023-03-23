package com.stl.travelbooking;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;

import com.stl.travelbooking.domain.BusTicket;
import com.stl.travelbooking.domain.PlaneTicket;
import com.stl.travelbooking.domain.TrainTicket;
import com.stl.travelbooking.domain.TravelClass;
import com.stl.travelbooking.exceptions.InvalidTravelDurationException;

public class RegisterTravelTicket {

	public static void main(String[] args) throws InvalidTravelDurationException {

		Scanner sc = new Scanner(System.in);
		
		int option = 0;
		
		while(!(option >= 1 && option <=3)) {
			System.out.println("Enter 1 for bus ticket, 2 for train ticket or 3 for plane ticket");
			option = sc.nextInt();
		}
		
		System.out.println("Enter the bookinf ref");
		Long ref = sc.nextLong();
		sc.nextLine();
		
		System.out.println("Enter the origin");
		String origin = sc.nextLine();
		
		System.out.println("Enter the destination");
		String destination = sc.nextLine();
		
		System.out.println("Enter the price");
		BigDecimal price = sc.nextBigDecimal();
		sc.nextLine();
		
		System.out.println("Enter the departure time");
		String dTime = sc.nextLine();
		LocalDateTime departureTime = LocalDateTime.parse(dTime);
		
		System.out.println("Enter the arrival time");
		String aTime = sc.nextLine();
		LocalDateTime arrivalTime = LocalDateTime.parse(aTime);
		
		switch (option) {
		case 1 : 
			BusTicket busTicket = new BusTicket(ref, origin, destination, price, departureTime, arrivalTime, null);
			System.out.println(busTicket);
			break;
		case 2 : 
			System.out.println("Enter the travel class");
			String tClass = sc.nextLine();
			TravelClass travelClass = TravelClass.valueOf(tClass.toUpperCase());
			
			System.out.println("Enter the carriage number");
			int carriageNumber = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter the seat number");
			int seatNumber = sc.nextInt();
			
			TrainTicket trainTicket = new TrainTicket(ref, origin, destination, price, 
					departureTime, arrivalTime, travelClass, carriageNumber, seatNumber);
			System.out.println(trainTicket);
			break;
		case 3 : 
			System.out.println("Enter the travel class");
			String tClass2 = sc.nextLine();
			TravelClass travelClass2 = TravelClass.valueOf(tClass2.toUpperCase());
			
			System.out.println("Enter the number of  stopovers");
			int stopovers = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter the seat number");
			int seatNumber2 = sc.nextInt();
			
			PlaneTicket planeTicket = new PlaneTicket(ref, origin, destination, price, 
					departureTime, arrivalTime, travelClass2, seatNumber2, stopovers);
			System.out.println(planeTicket);
			break;
		}
	}

}
