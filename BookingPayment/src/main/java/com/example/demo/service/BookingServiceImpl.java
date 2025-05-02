package com.example.demo.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.BookingNotFound;
import com.example.demo.model.Booking;
import com.example.demo.repository.BookingRepository;


@Service("bookingService")
public class BookingServiceImpl implements BookingService {



	@Autowired
	BookingRepository repository;


	@Override
	public String saveBooking(Booking booking) {
		Booking review2 = repository.save(booking);
		if (review2 != null) {
			return "successfully saved";

		} else {
			return "Not saved";
		}
	}

	@Override
	public Booking updateBooking(Booking booking) {
		Booking review2=repository.save(booking);
		return review2;
	}

	@Override
	public String removeBooking(int bookingId) {

        repository.deleteById(bookingId);
		return "deleted successfully";
		
	}

	@Override
	public Booking getBooking(int bookingId) throws BookingNotFound {
       
		Optional<Booking> optional= repository.findById(bookingId);
		if(optional.isPresent()) {
		return optional.get();
		}
		else
			throw new BookingNotFound("Not found");
	}

	@Override
	public List<Booking> getAllBooking() {
        return repository.findAll();
	}


}
