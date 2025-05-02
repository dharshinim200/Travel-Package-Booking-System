package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="package_info")
public class Pack {
    @Id
	private int packageId;
	private String title;
	private String description;
	private int duration;
	private float price;
	private String includedServices;
}
