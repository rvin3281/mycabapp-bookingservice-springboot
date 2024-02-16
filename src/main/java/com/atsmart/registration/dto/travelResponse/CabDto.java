package com.atsmart.registration.dto.travelResponse;

import com.atsmart.registration.dto.BookOrderDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CabDto {

	private Long cabId;
    private String cabModel;
    private String cabName;
    private String cabPlateNum;
	
}
