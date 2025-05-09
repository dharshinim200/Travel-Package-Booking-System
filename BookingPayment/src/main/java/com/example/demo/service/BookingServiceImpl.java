package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Pack;
import com.example.demo.dto.User;
import com.example.demo.dto.UserBookResponseDTO;
import com.example.demo.exception.BookingNotFound;
import com.example.demo.feignclient.PackClient;
import com.example.demo.feignclient.PayClient;
import com.example.demo.feignclient.UserClient;
import com.example.demo.model.Booking;
import com.example.demo.repository.BookingRepository;


@Service("bookingService")
public class BookingServiceImpl implements BookingService {
	
	Logger log = LoggerFactory.getLogger(BookingServiceImpl.class);

	@Autowired
	BookingRepository repository;

	@Autowired
	UserClient userClient;

	@Autowired
	PackClient packClient;
	@Autowired
	PayClient payClient;


	@Override
	public String saveBooking(Booking booking) {
		
		log.info("In BookingServiceImpl saveBooking method ....");
		   try {
		        Pack pack = packClient.checkPackage(booking.getPackageId());

		        if (pack == null) {
		            return "Invalid Package";
		        }
		        booking.setStatus("NOT_PAID");
		        
		        Booking book = repository.save(booking);
		        if (book != null) {
		            return "Successfully saved and waiting for payment process";
		        } else {
		            return "Not saved";
		        }

		    } catch (Exception e) {
		        return "Package service not found";
		    }
	}
   
    public String updateBookingStatus( int bookingId, String status) {
    	
    	log.info("In BookingServiceImpl update the booking status ....");
    	
        Booking booking = repository.findById(bookingId).orElse(null);
        if (booking == null) {
            return "Booking not found";
        }

        booking.setStatus(status);
        repository.save(booking);
        return "Booking status updated successfully to " + status;
    }

	
  
	@Override
	public Booking updateBooking(Booking booking) {
		
		log.info("In BookingServiceImpl updateBooking method ....");
		
		Booking book = repository.save(booking);
		return book;
	}

	@Override
	public String removeBooking(int bookingId) {
 
		log.info("In BookingServiceImpl saveProduct method ....");
		
		repository.deleteById(bookingId);
		return "deleted successfully";

	}

	@Override
	public UserBookResponseDTO getBooking(int bookingId) {
		
		log.info("In BookingServiceImpl Listing the Booking details based on the id ....");

		Booking book = repository.findById(bookingId).get();
		int userno = book.getUserId();
		User user = userClient.getUserId(userno);

		int packno = book.getPackageId();
		Pack pack = packClient.getPackId(packno);

		UserBookResponseDTO responseDTO = new UserBookResponseDTO(user, book, pack);
		return responseDTO;
	}

	@Override
	public List<Booking> getAllBooking() {
		
		log.info("In BookingServiceImpl Listing the Booking details ....");

		return repository.findAll();
	}

}
