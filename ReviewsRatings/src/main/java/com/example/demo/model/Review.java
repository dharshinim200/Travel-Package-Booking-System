package com.example.demo.model;


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
	private int userId;
	private int reviewId;
	private int packageId;
	private int rating;
	private String comment;
	private String timestamp;
}
