package com.park.parkingmanagment.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.park.parkingmanagment.response.ParkingExceptions;
@Service
public interface ParkingMasterService {
	public Map save(Map jsonMap) throws ParkingExceptions;
	public Map getParkingData() throws ParkingExceptions;
	public Map update(Map jsonMap) throws ParkingExceptions;
}
