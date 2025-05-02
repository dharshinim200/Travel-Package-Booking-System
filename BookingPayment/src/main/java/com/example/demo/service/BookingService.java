package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.BookingNotFound;
import com.example.demo.model.Booking;



public interface BookingService {
  
	public abstract String saveBooking(Booking booking);

	public abstract Booking updateBooking(Booking booking);

	public abstract String removeBooking(int bookingId);

	public abstract Booking getBooking(int bookingId) throws BookingNotFound;

	public abstract List<Booking> getAllBooking();
	
}
