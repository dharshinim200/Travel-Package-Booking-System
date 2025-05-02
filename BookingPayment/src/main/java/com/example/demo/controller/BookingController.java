package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.BookingNotFound;
import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	BookingService service;

	@PostMapping("/save")
	public String saveBooking(@RequestBody Booking booking) {
		return service.saveBooking(booking);
	}

	@PutMapping("/update")
	public Booking updateBooking(@RequestBody Booking booking) {
		return service.updateBooking(booking);
	}

	@DeleteMapping("/deleteById/{did}")
	public String removeBooking(@PathVariable("did") int bookingId) {
		return service.removeBooking(bookingId);
	}

	@GetMapping("/fetchById/{fid}")
	public Booking getBooking(@PathVariable("fid") int bookingId) throws BookingNotFound {
		return service.getBooking(bookingId);
	}

	@GetMapping("/fetchAll")
	public List<Booking> getAllBooking() {
		return service.getAllBooking();
	}
}
