package com.airline.app.repositories;

import com.airline.app.entities.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<Airline, Long> {
    Airline findByName(String name);
}
