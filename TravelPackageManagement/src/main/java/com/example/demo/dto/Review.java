package com.example.demo.dto;

import java.time.LocalDateTime;

//import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Review {
   
	private int reviewId;
	private int userId;
	private int packageId;
	private int rating;
	private String comment;
//	@CreationTimestamp
	private LocalDateTime timestamp;
}
