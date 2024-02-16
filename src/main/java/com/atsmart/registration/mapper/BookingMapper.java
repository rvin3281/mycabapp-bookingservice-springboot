package com.atsmart.registration.mapper;

import org.mapstruct.Mapper;

import com.atsmart.registration.dto.BookOrderDto;
import com.atsmart.registration.dto.BookRegisterDto;
import com.atsmart.registration.entity.BookingTravel;

@Mapper(componentModel="spring")
public interface BookingMapper {

	public BookingTravel BookingRegisterDtoToEntity (BookRegisterDto bookRegisterDto);
	
	public BookRegisterDto EntityToBookRegisterDto (BookingTravel bookingTravel);
	
}
