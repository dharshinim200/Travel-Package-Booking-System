package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.exception.PackageNotFound;
import com.example.demo.model.Pack;
import com.example.demo.repository.TravelPackageRepository;
import com.example.demo.service.TravelPackageServiceImpl;

@SpringBootTest
class TravelPackageManagementApplicationTests {
   
	@Mock
	TravelPackageRepository repository;
	@InjectMocks
	TravelPackageServiceImpl service;
	
	
	@Test
	void savePackTest() {
		Pack pack = new Pack(30,"good", "high", 2, 200, "Nothing");
		Mockito.when(repository.save(pack)).thenReturn(pack);
		String response = service.savePack(pack);
		assertEquals("successfully saved", response);
	}
	@Test
	void updatePackTest() {
		Pack pack = new Pack(30,"good", "high", 2, 200, "Nothing");
		Mockito.when(repository.save(pack)).thenReturn(pack);
		Pack updatedPack = service.updatePack(pack);
		assertEquals(pack, updatedPack);
	}
	@Test
	void removePackTest() {
		int packageId=30;
		
		Mockito.doNothing().when(repository).deleteById(packageId);
		String response = service.removePack(packageId);
		assertEquals("deleted successfully", response);
	}
 
    @Test
    public void testGetPackNotFound() {
        int packId = 1;

        Mockito.when(repository.findById(packId)).thenReturn(Optional.empty());

        assertThrows(PackageNotFound.class, () -> service.getPack(packId));
    }
    @Test
    public void testGetPackSuccess() throws PackageNotFound {
        int packId = 30;
        Pack mockPack = new Pack(30,"good", "high", 2, 200, "Nothing");

        Mockito.when(repository.findById(packId)).thenReturn(Optional.of(mockPack));

        Pack result = service.getPack(packId);

        assertNotNull(result);
        assertEquals(packId, result.getPackageId());
        assertEquals("good", result.getTitle());
    }
    @Test
    public void testGetAllPack() {
        List<Pack> mockPacks = Arrays.asList(
            new Pack(30,"Package 1", "high", 2, 200, "Nothing"),
            new Pack(20,"Package 2", "high", 3, 100, "Nothing")
        	
        );

        Mockito.when(repository.findAll()).thenReturn(mockPacks);

        List<Pack> result = service.getAllPack();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Package 1", result.get(0).getTitle());
        assertEquals("Package 2", result.get(1).getTitle());
    }
    
 

}
