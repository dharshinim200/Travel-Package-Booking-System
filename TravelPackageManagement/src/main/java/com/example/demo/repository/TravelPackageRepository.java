package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Pack;


public interface TravelPackageRepository extends JpaRepository<Pack , Integer>{

}
