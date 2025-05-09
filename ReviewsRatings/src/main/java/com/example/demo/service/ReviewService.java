package com.example.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.UserReviewResponseDTO;
import com.example.demo.exception.UserNotFound;
import com.example.demo.model.Review;


public interface ReviewService {
  
	public abstract String saveReview(Review review);

	public abstract Review updateReview(Review review);

	public abstract String removeReview(int userId);

	public abstract UserReviewResponseDTO getReview(int reviewId) throws UserNotFound;

	public abstract List<Review> getAllReview();
	
	 public abstract void deleteReviewsByPackage(int packageId) ;
	
}
