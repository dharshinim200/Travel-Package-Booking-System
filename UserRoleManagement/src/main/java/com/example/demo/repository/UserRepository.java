package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.RoleManagement;

public interface UserRepository extends JpaRepository<RoleManagement,Integer> {
   //User findByEmail(String email);
}
