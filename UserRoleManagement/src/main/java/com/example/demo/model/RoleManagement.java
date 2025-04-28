package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="User")
public class RoleManagement {
    @Id
	private int UserId;
    @NotEmpty
    //@Email
    @Size(min = 3, message = "Name should have at least 3 characters")
	private String Name;
    @NotEmpty
	private String Email;
    @NotEmpty
	private String Password;
    @NotEmpty
	private String Role;
    
	@Column(name="Contact")
	private String ContactNumber;
}
