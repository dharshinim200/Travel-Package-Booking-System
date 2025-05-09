package com.example.demo.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "REVIEWSRATINGS",path="/review")
public interface ReviewClient {
	
	@DeleteMapping("/deleteById/{packageId}")
    void deleteReviewsByPackage(@PathVariable("packageId") int packageId);
}
