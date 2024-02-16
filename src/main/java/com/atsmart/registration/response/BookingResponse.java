package com.atsmart.registration.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.atsmart.registration.dto.BookRegisterDto;



public class BookingResponse {

	public ResponseEntity<Object> responseWithData(BookRegisterDto bookRegisterDto, String message, HttpStatus httpStatus) {
		Map<String,Object> response = new HashMap();
		response.put("message", message);
		response.put("data", bookRegisterDto);
		response.put("status", httpStatus);
	
		return new ResponseEntity<>(response, httpStatus);
	}
	
}
