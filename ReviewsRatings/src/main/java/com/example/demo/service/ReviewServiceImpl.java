package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.demo.dto.Pack;
import com.example.demo.dto.User;
import com.example.demo.dto.UserReviewResponseDTO;
import com.example.demo.exception.UserNotFound;
import com.example.demo.feignclient.PackClient;
import com.example.demo.feignclient.UserClient;
import com.example.demo.model.Review;
import com.example.demo.repository.ReviewRepository;

@Service("userService")
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewRepository repository;
	@Autowired
	UserClient userClient;
	@Autowired
	PackClient packClient;

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
	public UserReviewResponseDTO getReview(int reviewId) throws UserNotFound {
		
//		Review review = repository.findById(reviewId).get();
//
//		int packageId=review.getPackageId();
//		int userno = review.getUserId();
//		User user=userClient.getUserId(userno);
//		Pack pack=packClient.getPackId(packageId);
//		UserReviewResponseDTO responseDTO = new UserReviewResponseDTO(user,review,pack);
//		return responseDTO;
		
		    Optional<Review> optionalReview = repository.findById(reviewId);
		    
		    if (optionalReview.isEmpty()) {
		        throw new UserNotFound("Review not found for ID: " + reviewId);
		    }

		    Review review = optionalReview.get();
		    int packageId = review.getPackageId();
		    int userNo = review.getUserId();
		    User user = userClient.getUserId(userNo);
		    Pack pack = packClient.getPackId(packageId);

		    return new UserReviewResponseDTO(user, review, pack);
		}


	
	

	@Override
	public List<Review> getAllReview() {
        return repository.findAll();
	}

	@Override
	
	@DeleteMapping("/package/{packageId}")
	public void deleteReviewsByPackage(int packageId) {
	
		 repository.deleteByPackageId(packageId);	
		
	}

}
