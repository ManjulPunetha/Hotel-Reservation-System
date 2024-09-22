package com.HotelReservationSystem.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.HotelReservationSystem.Entity.Hotel;
import com.HotelReservationSystem.Repository.HotelRepository;


@Service
public class HotelService{
	
	@Autowired
	private HotelRepository hotelRepository;

	public String searchHotelResult(Hotel hotel) {
		return hotelRepository.findByCityHotelDate(hotel.getCity(),hotel.getHotel(),hotel.getDate());
	}

	
	public List<String> cities() {
		return hotelRepository.findListOfCities();
	}
	
	public List<String> hotels() {
		return hotelRepository.findListOfHotels();
	}
	
	public double findTotal(int id) {
		return Double.parseDouble(String.format("%.2f", hotelObject(id).getPrice()+hotelObject(id).getGst()));
	}
	
	public int findHotelId(String city, String hotel) {
		return hotelRepository.findHotelId(city,hotel);
	}
	
	public Hotel hotelObject(int id) {
		return hotelRepository.findById(id).get();
	}
}
