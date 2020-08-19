package com.park.parkingmanagment.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.park.parkingmanagment.response.ObjectResponse;
import com.park.parkingmanagment.response.ParkingExceptions;
import com.park.parkingmanagment.response.ResponseUtil;
import com.park.parkingmanagment.response.StatusType;
import com.park.parkingmanagment.service.ParkingMasterService;
import com.park.parkingmanagment.service.VehicletypeService;
@RestController
@RequestMapping("/parkingmaster")
@CrossOrigin(origins = "*")
public class ParkingMasterController {
	@Autowired
	private ResponseUtil responseutil;
	@Autowired
	ParkingMasterService service;

	@RequestMapping({ "/save" })
	public ResponseEntity<ObjectResponse<Object>> savVehicles(@RequestBody final Map bodyMap) {
		final ObjectResponse<Object> endPointResponse = new ObjectResponse<>();
		Map map = new HashMap();
		try {
			responseutil.getResponseKeyValue(bodyMap, "parkingcode");
			responseutil.getResponseKeyValue(bodyMap, "parkingaddress");
			responseutil.getResponseKeyValue(bodyMap, "parkingname");
			responseutil.getResponseKeyValue(bodyMap, "parkingslots");
			responseutil.getResponseKeyValue(bodyMap, "parkingtype");
		    map=service.save(bodyMap);
		    endPointResponse.setResponse(map);
			endPointResponse.setStatus(new StatusType("SUCCESS"));
			return ResponseEntity.status(HttpStatus.OK).body(endPointResponse);
		} catch (ParkingExceptions e) {
			return responseutil.returnFailedResponseStatus(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@RequestMapping({ "/update" })
	public ResponseEntity<ObjectResponse<Object>> update(@RequestBody final Map jsonMap) {
		final ObjectResponse<Object> endPointResponse = new ObjectResponse<>();
		Map map = new HashMap();
		try {
			responseutil.getResponseKeyValue(jsonMap, "parkingid");
			responseutil.getResponseKeyValue(jsonMap, "parkingcode");
			responseutil.getResponseKeyValue(jsonMap, "parkingaddress");
			responseutil.getResponseKeyValue(jsonMap, "parkingname");
			responseutil.getResponseKeyValue(jsonMap, "parkingslots");
			responseutil.getResponseKeyValue(jsonMap, "parkingtype");
		    map=service.update(jsonMap);
		    endPointResponse.setResponse(map);
			endPointResponse.setStatus(new StatusType("SUCCESS"));
			return ResponseEntity.status(HttpStatus.OK).body(endPointResponse);
		} catch (ParkingExceptions e) {
			return responseutil.returnFailedResponseStatus(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	@RequestMapping({ "/getparkingdata" })
	public ResponseEntity<ObjectResponse<Object>> getVehicles() {

		final ObjectResponse<Object> endPointResponse = new ObjectResponse<>();
		Map map = new HashMap();
		try {
		    map=service.getParkingData();
		    endPointResponse.setResponse(map);
			endPointResponse.setStatus(new StatusType("SUCCESS"));
			return ResponseEntity.status(HttpStatus.OK).body(endPointResponse);
		} catch (ParkingExceptions e) {
			return responseutil.returnFailedResponseStatus(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
}
