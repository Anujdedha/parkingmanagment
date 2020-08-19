package com.park.parkingmanagment.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.park.parkingmanagment.response.ParkingExceptions;
@Service
public interface ParkingSlotDetailsService {
	public Map parkVehicle(Map jsonMap) throws ParkingExceptions;
	public Map unparkVehicle(Map jsonMap) throws ParkingExceptions;
	public Map checkAvilablespace(Map jsonMap) throws ParkingExceptions;
	public Map getSlotIsEmpty(Map jsonMap) throws ParkingExceptions;
	public Map getSlotDetails(Map jsonMap) throws ParkingExceptions;
	public Map getAllData() throws ParkingExceptions;
}
