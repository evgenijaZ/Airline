package com.airline.app.repositories;

import com.airline.app.entities.Aircraft;
import com.airline.app.entities.Helicopter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AircraftRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AircraftRepository aircraftRepository;

    @Test
    public void whenFindByModelName_thenReturnAircraft() {
        // given
        Aircraft helicopter = new Helicopter();
        helicopter.setModelName("Sikorsky XBLR-3");
        entityManager.persist(helicopter);
        entityManager.flush();

        // when
        Aircraft found = aircraftRepository.findByModelName(helicopter.getModelName());

        // then
        assertEquals(found.getModelName(), helicopter.getModelName());
    }
}