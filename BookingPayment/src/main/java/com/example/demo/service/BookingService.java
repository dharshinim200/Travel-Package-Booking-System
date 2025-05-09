package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.PackBookResponseDTO;
import com.example.demo.dto.UserBookResponseDTO;
import com.example.demo.exception.BookingNotFound;
import com.example.demo.exception.PackageNotFound;
import com.example.demo.model.Booking;

public interface BookingService {

	public abstract String saveBooking(Booking booking) throws PackageNotFound;

	public abstract Booking updateBooking(Booking booking);

	public abstract String removeBooking(int bookingId);

	public abstract UserBookResponseDTO getBooking(int bookingId);

	public abstract List<Booking> getAllBooking();

	public abstract String updateBookingStatus(int bookingId, String status);

	// public abstract PackBookResponseDTO getPack(int bookingId) throws
	// BookingNotFound;

}
