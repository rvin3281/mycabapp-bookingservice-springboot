package com.atsmart.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.atsmart.registration.dto.BookOrderDto;
import com.atsmart.registration.dto.BookRegisterDto;
import com.atsmart.registration.dto.travelResponse.ResponseDto;
import com.atsmart.registration.dto.travelResponse.TravelDetailDto;
import com.atsmart.registration.entity.BookingTravel;
import com.atsmart.registration.exception.BookingException;
import com.atsmart.registration.mapper.BookingMapper;
import com.atsmart.registration.repo.BookingRepo;

@Service
public class BookingService {

	@Autowired
	BookingMapper mapper;
	
	@Autowired
	BookingRepo repo;
	
	public BookRegisterDto calculateCost(BookOrderDto bookOrderdto) {
		
		try {
			
			BookRegisterDto bookRegisterDto = new BookRegisterDto();
			int travelId = bookOrderdto.getTravelId().intValue();
			
			RestTemplate temp = new RestTemplate();
			
			String url = "http://localhost:8082/api/v1/travel/"+travelId;
			
			ResponseEntity<ResponseDto> responseEntity = temp.getForEntity(url, ResponseDto.class);
			
			ResponseDto responseBody = responseEntity.getBody();
			
			// Now you can access the travel details like this:
			TravelDetailDto travelDetail = responseBody.getData();
			
			if(travelDetail != null) {
				
				int perDayPrice = Integer.parseInt(travelDetail.getTravelCost());
				int totalDays = Integer.parseInt(bookOrderdto.getDays());
				int calculateTotalCost  = perDayPrice * totalDays;
				
				bookRegisterDto.setTravelDestination(travelDetail.getTravelDestination());
				bookRegisterDto.setTravelSource(travelDetail.getTravelSource());
				bookRegisterDto.setTravel_time(travelDetail.getTravel_time());
				bookRegisterDto.setTravelDate(travelDetail.getTravelDate());
				bookRegisterDto.setTravelDays(bookOrderdto.getDays());
				bookRegisterDto.setTravelPerDayCost(travelDetail.getTravelCost());
				bookRegisterDto.setTravelTotalCost(calculateTotalCost);
				bookRegisterDto.setStatus(0);
				
				BookingTravel book = mapper.BookingRegisterDtoToEntity(bookRegisterDto);
				
				BookingTravel savedBook = repo.save(book);
				
				BookRegisterDto savedRegister = mapper.EntityToBookRegisterDto(savedBook);
				
				return savedRegister;
				
			}else {
				throw new BookingException("Travel not found");
			}
			
		}catch(Exception ex) {
			throw new BookingException("Unexpected Error "+ex.getMessage());
		}
		
	}
	
	public BookRegisterDto getBookingById (int id) {
		
		try {
			BookingTravel bookingTravel = repo.findById(id).orElseThrow(()-> new BookingException("Booking Not Found"));
			BookRegisterDto bookRegisterDto = mapper.EntityToBookRegisterDto(bookingTravel);
			return bookRegisterDto;
			
		}catch(Exception ex) {
			throw new BookingException("Unexpected Error "+ex.getMessage());
		}
		
		
	}
	
}
