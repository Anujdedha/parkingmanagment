package com.park.parkingmanagment.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResponseUtil {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity<ObjectResponse<Object>> returnFailedResponseStatus(final HttpStatus status, String msg) {
		Map errorMap = new HashMap<>();
		final ObjectResponse<Object> errorEndPointResponse = new ObjectResponse<>();
		errorMap.put("status", msg);
		errorEndPointResponse.setResponse(errorMap);
		errorEndPointResponse.setStatus(new StatusType("FAILURE", null));
		return ResponseEntity.status(status).body(errorEndPointResponse);

	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map getResponseKeyValue(final Map bodyMap, String keyitem) throws ParkingExceptions {
		Map map = new HashMap();
		if (bodyMap == null || bodyMap.size() == 0) {
			map.put("valid ", "false");
			map.put("error ", "ERROR_NULL_PARAMETERE_SUPPLIED");
			throw new ParkingExceptions(" ERROR_INVALID_JSON_BODYDATA_SUPPLIED","");
		} else if (!bodyMap.containsKey(keyitem)) {
			map.put("valid", "false");
			map.put("error", keyitem.concat(" ERROR_KEY_NOT_FOUND"));
			throw new ParkingExceptions(keyitem.concat(" ERROR_KEY_NOT_FOUND"),"");
		} else if (bodyMap.get(keyitem) == null || "".equals(bodyMap.get(keyitem).toString()) || "null".equals(bodyMap.get(keyitem).toString())) {
			map.put("valid", "false");
			map.put("error", keyitem.concat(" ERROR_VALUE_NOT_FOUND"));
			throw new ParkingExceptions(keyitem.concat(" ERROR_VALUE_NOT_FOUND"),"");
		}
		else {
			String encryptedvalue = bodyMap.get(keyitem).toString();
			map.put(keyitem, encryptedvalue);
		}
		return map;
	}
}
