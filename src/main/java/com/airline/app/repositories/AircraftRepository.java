package com.airline.app.repositories;

import com.airline.app.entities.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AircraftRepository extends JpaRepository<Aircraft, Long> {
    Aircraft findByModelName(String modelName);
    Aircraft findById(long id);
}
