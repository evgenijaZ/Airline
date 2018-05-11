package com.airline.app.services;

import com.airline.app.entities.AbstractAircraft;
import com.airline.app.entities.Aircraft;
import com.airline.app.repositories.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AircraftService {
    private final AircraftRepository repository;

    @Autowired
    public AircraftService(AircraftRepository repository) {
        this.repository = repository;
    }

    public void add(AbstractAircraft aircraft){
        repository.save(aircraft);
    }

    public void update(AbstractAircraft aircraft){
        repository.save(aircraft);
    }

    public void delete(AbstractAircraft aircraft){
        repository.delete(aircraft);
    }

}
