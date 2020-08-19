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
import com.park.parkingmanagment.service.ParkingSlotDetailsService;
@RestController
@RequestMapping("/parking")
@CrossOrigin(origins = "*")
public class ParkingSlotDetailsController {
	@Autowired
	private ResponseUtil responseutil;
	@Autowired
	ParkingSlotDetailsService service;

	@PostMapping({ "/parkvehicle" })
	public ResponseEntity<ObjectResponse<Object>> parkVehicle(@RequestBody final Map bodyMap) {
		final ObjectResponse<Object> endPointResponse = new ObjectResponse<>();
		Map map = new HashMap();
		try {
			responseutil.getResponseKeyValue(bodyMap, "parkingid");
			responseutil.getResponseKeyValue(bodyMap, "parkingslot");
			responseutil.getResponseKeyValue(bodyMap, "vehiclecode");
			responseutil.getResponseKeyValue(bodyMap, "vehicletypeID");
			responseutil.getResponseKeyValue(bodyMap, "vehicleno");
		    map=service.parkVehicle(bodyMap);
		    endPointResponse.setResponse(map);
			endPointResponse.setStatus(new StatusType("SUCCESS"));
			return ResponseEntity.status(HttpStatus.OK).body(endPointResponse);
		} catch (ParkingExceptions e) {
			return responseutil.returnFailedResponseStatus(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	@PostMapping({ "/unparkvehicle" })
	public ResponseEntity<ObjectResponse<Object>> unParkVehicle(@RequestBody final Map bodyMap) {
		final ObjectResponse<Object> endPointResponse = new ObjectResponse<>();
		Map map = new HashMap();
		try {
			responseutil.getResponseKeyValue(bodyMap, "parkingslotid");
			responseutil.getResponseKeyValue(bodyMap, "parkingid");
		    map=service.unparkVehicle(bodyMap);
		    endPointResponse.setResponse(map);
			endPointResponse.setStatus(new StatusType("SUCCESS"));
			return ResponseEntity.status(HttpStatus.OK).body(endPointResponse);
		} catch (ParkingExceptions e) {
			return responseutil.returnFailedResponseStatus(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@PostMapping({ "/availability" })
	public ResponseEntity<ObjectResponse<Object>> checkAvilbilty(@RequestBody final Map bodyMap) {
		final ObjectResponse<Object> endPointResponse = new ObjectResponse<>();
		Map map = new HashMap();
		try {
			responseutil.getResponseKeyValue(bodyMap, "parkingid");
		    map=service.checkAvilablespace(bodyMap);
		    endPointResponse.setResponse(map);
			endPointResponse.setStatus(new StatusType("SUCCESS"));
			return ResponseEntity.status(HttpStatus.OK).body(endPointResponse);
		} catch (ParkingExceptions e) {
			return responseutil.returnFailedResponseStatus(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@PostMapping({ "/isslotempty" })
	public ResponseEntity<ObjectResponse<Object>> checkISSlotEmpty(@RequestBody final Map bodyMap) {
		final ObjectResponse<Object> endPointResponse = new ObjectResponse<>();
		Map map = new HashMap();
		try {
			responseutil.getResponseKeyValue(bodyMap, "parkingslot");
			responseutil.getResponseKeyValue(bodyMap, "parkingid");
		    map=service.getSlotIsEmpty(bodyMap);
		    endPointResponse.setResponse(map);
			endPointResponse.setStatus(new StatusType("SUCCESS"));
			return ResponseEntity.status(HttpStatus.OK).body(endPointResponse);
		} catch (ParkingExceptions e) {
			return responseutil.returnFailedResponseStatus(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@PostMapping({ "/getslotdetail" })
	public ResponseEntity<ObjectResponse<Object>> getSlotDetails(@RequestBody final Map bodyMap) {
		final ObjectResponse<Object> endPointResponse = new ObjectResponse<>();
		Map map = new HashMap();
		try {
			responseutil.getResponseKeyValue(bodyMap, "parkingslot");
			responseutil.getResponseKeyValue(bodyMap, "parkingid");
		    map=service.getSlotDetails(bodyMap);
		    endPointResponse.setResponse(map);
			endPointResponse.setStatus(new StatusType("SUCCESS"));
			return ResponseEntity.status(HttpStatus.OK).body(endPointResponse);
		} catch (ParkingExceptions e) {
			return responseutil.returnFailedResponseStatus(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@PostMapping({ "/getalldata" })
	public ResponseEntity<ObjectResponse<Object>> getAllData() {
		final ObjectResponse<Object> endPointResponse = new ObjectResponse<>();
		Map map = new HashMap();
		try {
		    map=service.getAllData();
		    endPointResponse.setResponse(map);
			endPointResponse.setStatus(new StatusType("SUCCESS"));
			return ResponseEntity.status(HttpStatus.OK).body(endPointResponse);
		} catch (ParkingExceptions e) {
			return responseutil.returnFailedResponseStatus(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
}
