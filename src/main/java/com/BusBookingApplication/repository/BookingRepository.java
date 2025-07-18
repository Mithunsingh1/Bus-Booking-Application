package com.BusBookingApplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BusBookingApplication.entity.Booking;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    // Custom query to find bookings by user ID
    List<Booking> findByUser_Id(Long userId);
}