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
import com.park.parkingmanagment.service.VehicletypeService;

@RestController
@RequestMapping("/vehicletype")
@CrossOrigin(origins = "*")
public class VehicletypeController {
	@Autowired
	private ResponseUtil responseutil;
	@Autowired
	VehicletypeService service;

	@PostMapping({ "/save" })
	public ResponseEntity<ObjectResponse<Object>> savVehicles(@RequestBody final Map bodyMap) {
		final ObjectResponse<Object> endPointResponse = new ObjectResponse<>();
		Map map = new HashMap();
		try {			
		responseutil.getResponseKeyValue(bodyMap, "vehiclecode");
		responseutil.getResponseKeyValue(bodyMap, "vehiclecharge");
		    map=service.save(bodyMap);
		    endPointResponse.setResponse(map);
			endPointResponse.setStatus(new StatusType("SUCCESS"));
			return ResponseEntity.status(HttpStatus.OK).body(endPointResponse);
		} catch (ParkingExceptions e) {
			return responseutil.returnFailedResponseStatus(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@PostMapping({ "/update" })
	public ResponseEntity<ObjectResponse<Object>> update(@RequestBody final Map jsonMap) {
		final ObjectResponse<Object> endPointResponse = new ObjectResponse<>();
		Map map = new HashMap();
		try {
			responseutil.getResponseKeyValue(jsonMap, "vehicletypeID");
			responseutil.getResponseKeyValue(jsonMap, "vehiclecode");
			responseutil.getResponseKeyValue(jsonMap, "vehiclecharge");
		    map=service.update(jsonMap);
		    endPointResponse.setResponse(map);
			endPointResponse.setStatus(new StatusType("SUCCESS"));
			return ResponseEntity.status(HttpStatus.OK).body(endPointResponse);
		} catch (ParkingExceptions e) {
			return responseutil.returnFailedResponseStatus(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	@RequestMapping({ "/getvehicles" })
	public ResponseEntity<ObjectResponse<Object>> getVehicles() {

		final ObjectResponse<Object> endPointResponse = new ObjectResponse<>();
		Map map = new HashMap();
		try {
		    map=	service.getVehicle();
		    endPointResponse.setResponse(map);
			endPointResponse.setStatus(new StatusType("SUCCESS"));
			return ResponseEntity.status(HttpStatus.OK).body(endPointResponse);
		} catch (ParkingExceptions e) {
			return responseutil.returnFailedResponseStatus(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
}
