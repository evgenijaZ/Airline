package com.airline.app.services;

import com.airline.app.entities.Aircraft;
import com.airline.app.entities.Airline;
import com.airline.app.repositories.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AircraftService implements IAircraftService{
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
        return repository.findById(id);
    }

    public List<Aircraft> getAll() {
        return repository.findAll();
    }

    @Override
    public Aircraft getByModelName(String modelName) {
        return repository.findByModelName(modelName);
    }

    @Override
    public Page<Aircraft> findAllPageable(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Aircraft> searchAllByName(String name) {
        return repository.findAllByModelNameContains(name);
    }

    public List<Aircraft> getAllAirships() {
        return repository.findAllAirships();
    }

    public List<Aircraft> getAllHelicopters() {
        return repository.findAllHelicopters();
    }

    public List<Aircraft> getAllAirplanes() {
        return repository.findAllAirplanes();
    }

}
