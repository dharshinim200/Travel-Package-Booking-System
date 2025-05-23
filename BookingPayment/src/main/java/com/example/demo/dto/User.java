package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
   
	private int userId;
	private String name;
	private String email;
	private String password;
	private String role;
	private String contactNumber;
}
