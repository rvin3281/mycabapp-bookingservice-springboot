package com.atsmart.registration.dto.travelResponse;

import com.atsmart.registration.dto.BookOrderDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

	 private TravelDetailDto data;
	    private String message;
	    private Integer status;
	
}
