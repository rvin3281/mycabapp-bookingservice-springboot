package com.atsmart.registration.dto.travelResponse;

import com.atsmart.registration.dto.BookOrderDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDto {

	    private Long driverId;
	    private String driverName;
	    private String driverContact;
	    private String driverIdentificationNum;
	    private CabDto cab; 
}
