package com.airline.app.repositories;

import com.airline.app.entities.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AirlineRepository extends JpaRepository<Airline, Long>, PagingAndSortingRepository<Airline, Long> {
    Airline findByName(String name);

    List<Airline> findAllByNameContains(String name);
}
