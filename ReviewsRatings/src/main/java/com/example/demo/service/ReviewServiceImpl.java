package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.exception.UserNotFound;
import com.example.demo.model.Review;
import com.example.demo.repository.ReviewRepository;


@Service("userService")
public class ReviewServiceImpl implements ReviewService {



	@Autowired
	ReviewRepository repository;


	@Override
	public String saveReview(Review review) {
		Review review2 = repository.save(review);
		if (review2 != null) {
			return "successfully saved";

		} else {
			return "Not saved";
		}
	}

	@Override
	public Review updateReview(Review review) {
		Review review2=repository.save(review);
		return review2;
	}

	@Override
	public String removeReview(int reviewId) {

        repository.deleteById(reviewId);
		return "deleted successfully";
		
	}

	@Override
	public Review getReview(int reviewId) throws UserNotFound {
       
		Optional<Review> optional= repository.findById(reviewId);
		if(optional.isPresent()) {
		return optional.get();
		}
		else
			throw new UserNotFound("Not found");
	}

	@Override
	public List<Review> getAllReview() {
        return repository.findAll();
	}

}
