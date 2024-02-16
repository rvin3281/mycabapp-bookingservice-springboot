package com.atsmart.registration.response.errorresponse;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.atsmart.registration.dto.BookRegisterDto;

public class BookingErrorResponse {

	public ResponseEntity<Object> errorResponse(String message, String error, HttpStatus httpStatus) {
		Map<String,Object> response = new HashMap();
		response.put("message", message);
		response.put("error", error);
		response.put("status", httpStatus);
	
		return new ResponseEntity<>(response, httpStatus);
	}
	
}
