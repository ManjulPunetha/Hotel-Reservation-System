package com.HotelReservationSystem.Entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String city;
	private String hotel;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private char status;
	private String room_type;
	private double price;
	private double gst;
	
	public Hotel(String city, String hotel,char status, String room_Type, double price, double gst) {
		this.city = city;
		this.hotel = hotel;
		this.status = status;
		this.room_type = room_Type;
		this.price = price;
		this.gst = gst;
	}
	
	public Hotel() {
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public String getRoom_Type() {
		return room_type;
	}
	public void setRoom_Type(String room_Type) {
		room_type = room_Type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getGst() {
		return gst;
	}
	public void setGst(double gst) {
		this.gst = gst;
	}
	public int getId() {
		return id;
	}
}

