package com.airline.app.services;

import com.airline.app.entities.Aircraft;

import java.util.List;

public interface IAircraftService {

    public Aircraft save(Aircraft aircraft);

    public void delete(long id);

    public Aircraft get(long id);

    public List<Aircraft> getAll();

    public Aircraft getByModelName(String modelName);
}
