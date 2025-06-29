package com.BusBookingApplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BusBookingApplication.entity.Bus;

import java.util.Optional;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
    // Custom query to find a bus by its bus number
    Optional<Bus> findByBusNumber(String busNumber);
}