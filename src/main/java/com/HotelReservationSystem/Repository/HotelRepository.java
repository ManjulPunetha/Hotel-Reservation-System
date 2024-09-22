package com.HotelReservationSystem.Repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.HotelReservationSystem.Entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer>{
	
	@Query("SELECT city,hotel,date FROM Hotel h WHERE h.city = ?1 and h.hotel = ?2 and h.date = ?3 and h.status<>'N'")
	String findByCityHotelDate(String city,String hotel,Date date);
	
	@Query("SELECT DISTINCT city from Hotel")
	List<String> findListOfCities();

	@Query("SELECT DISTINCT hotel from Hotel")
	List<String> findListOfHotels();
	
	@Query("SELECT id FROM Hotel h WHERE h.city = ?1 and h.hotel = ?2")
	int findHotelId(String city,String hotel);

}
