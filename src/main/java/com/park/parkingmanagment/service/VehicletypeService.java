package com.park.parkingmanagment.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.park.parkingmanagment.response.ParkingExceptions;
@Service
public interface VehicletypeService {
	public Map save(Map jsonMap) throws ParkingExceptions;
	//public Map save() throws ParkingExceptions;
	public Map getVehicle() throws ParkingExceptions;
	public Map update(Map jsonMap) throws ParkingExceptions ;
}
