package com.example.demo.service;

import java.util.List;
import com.example.demo.exception.UserNotFound;
import com.example.demo.model.Review;


public interface ReviewService {
  
	public abstract String saveReview(Review review);

	public abstract Review updateReview(Review review);

	public abstract String removeReview(int userId);

	public abstract Review getReview(int userId) throws UserNotFound;

	public abstract List<Review> getAllReview();
	
}
