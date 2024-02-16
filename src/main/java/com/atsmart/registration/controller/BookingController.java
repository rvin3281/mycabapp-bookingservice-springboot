package com.atsmart.registration.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atsmart.registration.dto.BookOrderDto;
import com.atsmart.registration.dto.BookRegisterDto;
import com.atsmart.registration.dto.checkAvailabilityDto;
import com.atsmart.registration.dto.travelResponse.ResponseDto;
import com.atsmart.registration.dto.travelResponse.TravelDetailDto;
import com.atsmart.registration.response.BookingResponse;
import com.atsmart.registration.response.errorresponse.BookingErrorResponse;
import com.atsmart.registration.service.BookingService;

@RestController
@RequestMapping(path="/api/v1/booking")
@CrossOrigin
public class BookingController {
	
	@Autowired
	BookingService bookingService;

	@GetMapping("/checkAvailable")
	public ResponseEntity<Object> checkTravelAvailable(  
			@RequestParam(name = "source", required = false) String source,
			@RequestParam(name = "destination", required = false) String destination){
		
		
		// 1. INITIALIZE REST TEMPLATE
		RestTemplate temp = new RestTemplate();
		
		// 2. CREATE URL
		String url = "http://localhost:8082/api/v1/travel/check?source="+source+"&destination="+destination;
		
		// 3. MUST USE MAP TO PASS DATA TO ANOTHER SERVICE
		Map<String,String> params = new HashMap<>();
		params.put("source", source);
		params.put("destination", destination);
		
		//4. SEND REQUEST TO ANOTHER SERVICE
		ResponseEntity<String> responseEntity = temp.getForEntity(url, String.class, params);

		return ResponseEntity.status(responseEntity.getStatusCode())
	            .headers(responseEntity.getHeaders())
	            .body(responseEntity.getBody());
		
	}
	
	@PostMapping("/booktravel")
	public ResponseEntity<Object> bookingForm(@RequestBody BookOrderDto bookOrderDto){

		try {
			
			BookRegisterDto bookRegisterDto = bookingService.calculateCost(bookOrderDto);
			
			BookingResponse response = new BookingResponse();
			
			return response.responseWithData(bookRegisterDto, "success", HttpStatus.CREATED);

		}catch(Exception ex) {
			
			BookingErrorResponse error = new BookingErrorResponse();
			return error.errorResponse("fail", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getBookingById(@PathVariable Integer id){
		
		try {
			BookRegisterDto bookRegisterDto = bookingService.getBookingById(id.intValue());
			
			BookingResponse response = new BookingResponse();
			
			return response.responseWithData(bookRegisterDto, "success", HttpStatus.ACCEPTED);
			
		}catch(Exception ex) {
			
			BookingErrorResponse error = new BookingErrorResponse();
			return error.errorResponse("fail", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}












