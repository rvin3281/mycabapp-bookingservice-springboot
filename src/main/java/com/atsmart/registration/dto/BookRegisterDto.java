package com.atsmart.registration.dto;

import java.sql.Date;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRegisterDto {

	private Integer bookingId;
	private String travelDestination;
	private String travelSource;
	private LocalTime travel_time;
	private Date travelDate;
	private String travelDays;
	private String travelPerDayCost;
	private int travelTotalCost;
	private int status;
	
}
