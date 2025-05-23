package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.PackageNotFound;
import com.example.demo.model.Pack;

public interface TravelPackageService {

	public abstract String savePack(Pack pack);

	public abstract Pack updatePack(Pack pack);

	public abstract String removePack(int packId);

	public abstract Pack getPack(int packId) throws PackageNotFound;

	public abstract List<Pack> getAllPack();

}
