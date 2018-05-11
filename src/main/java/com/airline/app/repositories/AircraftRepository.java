package com.airline.app.repositories;

import com.airline.app.entities.AbstractAircraft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AircraftRepository extends JpaRepository<AbstractAircraft, Long> {
}
