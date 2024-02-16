package com.atsmart.registration.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atsmart.registration.entity.BookingTravel;

@Repository
public interface BookingRepo extends JpaRepository<BookingTravel, Integer> {
	
}
