package com.airline.app.services;

import com.airline.app.entities.Aircraft;
import com.airline.app.entities.Airline;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAircraftService {

    Aircraft save(Aircraft aircraft);

    void delete(long id);

    Aircraft get(long id);

    List<Aircraft> getAll();

    Aircraft getByModelName(String modelName);

    Page<Aircraft> findAllPageable(Pageable pageable);

    List<Aircraft> searchAllByName(String name);
}
