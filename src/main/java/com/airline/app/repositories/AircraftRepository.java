package com.airline.app.repositories;

import com.airline.app.entities.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AircraftRepository extends JpaRepository<Aircraft, Long> {
    Aircraft findByModelName(String modelName);

    Aircraft findById(long id);

    List<Aircraft> findAllByModelNameContains(String name);

    @Query("SELECT a FROM Airship a")
    List<Aircraft> findAllAirships();

    @Query("SELECT h FROM Helicopter h")
    List<Aircraft> findAllHelicopters();

    @Query("SELECT a FROM Airplane a")
    List<Aircraft> findAllAirplanes();

    //@Query("SELECT a FROM Aircraft a WHERE a.class=:type")
    //List<Aircraft> findAllAircraftByClass(@Param("type") Class type);
}
