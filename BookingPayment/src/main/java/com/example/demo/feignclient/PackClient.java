package com.example.demo.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.Pack;
import com.example.demo.dto.Payment;

@FeignClient(name="TRAVELPACKAGEMANAGEMENT",path="/package")
public interface PackClient {
   
	@GetMapping("/fetchById/{fid}")
	public Pack getPackId(@PathVariable("fid") int packageId);
	
	@GetMapping("/fetchById/{fid}")
    public Pack checkPackage(@PathVariable("fid") int packageId);
	
	
}
