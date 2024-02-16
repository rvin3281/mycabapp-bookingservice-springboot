package com.atsmart.registration.entity;


import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingTravel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="booking_id", nullable=false)
	private Integer bookingId;
	
	@Column(name="travel_destination", nullable=false)
	private String travelDestination;
	
	@Column(name="travel_source", nullable=false)
	private String travelSource;
	
	@Column(name="travel_time", nullable=false)
	private LocalTime travel_time;
	
	@Column(name = "travel_date", nullable=false)
	private Date travelDate;
	
	@Column(name = "travel_days", nullable = false)
	private String travelDays;
	
	@Column(name = "travel_perday_cost", nullable = false)
	private String travelPerDayCost;
	
	@Column(name = "travel_total_cost", nullable = false)
	private String travelTotalCost;
	
	@Column(name = "created_timestamp", nullable=false)
	private Timestamp createdTimestamp;
	
	@Column(name = "updated_timestamp", nullable=false)
	private Timestamp updatedTimestamp;
	
	@Column(name = "status", nullable=false)
	private int status;
	
	@PrePersist
	protected void onCreate() {
		createdTimestamp = new Timestamp(System.currentTimeMillis());
		updatedTimestamp = new Timestamp(System.currentTimeMillis());
	}
	
	@PreUpdate
	protected void onUpdate() {
		updatedTimestamp = new Timestamp(System.currentTimeMillis());
	}
}
