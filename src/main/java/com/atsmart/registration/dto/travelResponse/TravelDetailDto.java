package com.atsmart.registration.dto.travelResponse;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravelDetailDto {

	private Long travelId;
    private String travelSource;
    private String travelDestination;
    private LocalTime travel_time; // Consider using LocalTime or a similar time class
    private Date travelDate; // Consider using LocalDate
    private String travelCost; // Consider using BigDecimal for currency values
    private DriverDto driver;
    private CabDto cab;
	
}
