package com.example.demo.model;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="review")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
	
	@Id
	private int reviewId;
	private int userId;
	private int packageId;
	private int rating;
	private String comment;
	@CreationTimestamp
	private LocalDateTime timestamp;
}
