package com.example.demo.model;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "booking")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Booking {

	@Id
	private int bookingId;
	private int userId;
	private int packageId;
	private LocalDate startDate;
	private LocalDate endDate;
	private String status;
	private int paymentId;
}
