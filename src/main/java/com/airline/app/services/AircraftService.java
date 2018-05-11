package com.airline.app.services;

import com.airline.app.entities.Aircraft;
import com.airline.app.entities.IAircraft;
import com.airline.app.repositories.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AircraftService {
    private final AircraftRepository repository;

    @Autowired
    public AircraftService(AircraftRepository repository) {
        this.repository = repository;
    }

    public Aircraft save(Aircraft aircraft) {
        return repository.save(aircraft);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public Aircraft get(long id) {
        return repository.getOne(id);
    }

    public List<Aircraft> getAll() {
        return repository.findAll();
    }

}
