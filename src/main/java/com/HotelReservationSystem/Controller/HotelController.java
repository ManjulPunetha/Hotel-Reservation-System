package com.HotelReservationSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.HotelReservationSystem.Entity.Hotel;
import com.HotelReservationSystem.Entity.User;
import com.HotelReservationSystem.Service.HotelService;

@SessionAttributes("hotelId")
@Controller
public class HotelController {
	
	@Autowired
	private HotelService hotelService;

	@GetMapping("/index")
	public String searchHotel(Model model) {
		model.addAttribute("searchObject",new Hotel());
		model.addAttribute("cityList",hotelService.cities());
		model.addAttribute("hotelList",hotelService.hotels());
		return "search_hotel";
	}
	
	@PostMapping("/availabilityResult")
	public String afterClickingSearch(@ModelAttribute("searchObject") Hotel hotel,Model model) {
		if(hotelService.searchHotelResult(hotel)==null) 
			return "failure_page";
		else {
			int id = hotelService.findHotelId(hotel.getCity(), hotel.getHotel());
			model.addAttribute("hotelId",id);
			model.addAttribute("hotelRoom_Type",hotelService.hotelObject(id).getRoom_Type());
			model.addAttribute("hotel_price",hotelService.hotelObject(id).getPrice());
			model.addAttribute("hotel_gst",hotelService.hotelObject(id).getGst());
			model.addAttribute("total",hotelService.findTotal(id));
			return "booking_confirmation";
		}		
	}
	
	
	@GetMapping("/navUserRegisterPage")
	public String userRegisterPage(Model model){
		User user = new User();
		model.addAttribute("userObj", user);
		return "user_registerForm";
	}
	
	@PostMapping("/reserveUser")
	public String reserveUserHandler(@ModelAttribute("hotelId") int id,@ModelAttribute("userObj") User user,Model model) {
		model.addAttribute("hotelName",hotelService.hotelObject(id).getHotel());
		model.addAttribute("userName", user.getGuest_name());
		return "confirmation_page";
	}
}
