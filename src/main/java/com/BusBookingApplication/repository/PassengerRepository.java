package com.BusBookingApplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BusBookingApplication.entity.Passenger;


@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    // No custom methods needed for now, JpaRepository provides basic CRUD
}