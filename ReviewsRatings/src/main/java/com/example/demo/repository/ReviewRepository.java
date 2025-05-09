package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Review;


public interface ReviewRepository extends JpaRepository<Review , Integer>{

	void deleteByPackageId(int packageId);
}
