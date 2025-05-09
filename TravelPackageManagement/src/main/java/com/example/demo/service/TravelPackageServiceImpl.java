package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.PackageNotFound;
import com.example.demo.feignclient.ReviewClient;
import com.example.demo.model.Pack;
import com.example.demo.repository.TravelPackageRepository;



@Service("TravelPackageService")
public class TravelPackageServiceImpl implements TravelPackageService {



	@Autowired
	TravelPackageRepository repository;

    @Autowired
    ReviewClient reviewClient;
    
	@Override
	public String savePack(Pack pack) {
		Pack package2 = repository.save(pack);
		if (package2 != null) {
			return "successfully saved";

		} else {
			return "Not saved";
		}
	}

	@Override
	public Pack updatePack(Pack pack) {
		Pack package2=repository.save(pack);
		return package2;
	}

	@Override
	public String removePack(int packId) {

        repository.deleteById(packId);
		return "deleted successfully";
		 	
	}
	
	  public void deletePackage(int packageId) {
	        // First, delete associated reviews
	        reviewClient.deleteReviewsByPackage(packageId);
	        
	        repository.deleteById(packageId);
	    }

	@Override
	public Pack getPack(int packId) throws PackageNotFound {
       
		Optional<Pack> optional= repository.findById(packId);
		if(optional.isPresent()) {
		return optional.get();
		}
		else
			throw new PackageNotFound("Not found");
	}

	@Override
	public List<Pack> getAllPack() {
        return repository.findAll();
	}


}
