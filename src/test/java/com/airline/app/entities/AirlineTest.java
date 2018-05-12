package com.airline.app.entities;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Yevheniia Zubrych on 06.02.2018.
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class AirlineTest {

    @MockBean
    private Airplane airplane;
    @MockBean
    private Airship airship;
    private Airline airline;


    @Before
    public void setUp() {
        airline = new Airline();
        airline.setName("UkraineAir");
    }

    /**
     * Add a new one aircraft to airline
     */
    @Test
    public void addAirplane() {
        // given
        int size = airline.getSize();

        // when
        airline.addAircraft(airplane);

        // then
        assertNotNull(airline.getAircraft(size));
    }


    /**
     * Add a new one aircraft to airline, check size
     */
    @Test
    public void whenAddAircraft_thenSizeShouldIncrease() {
        // given
        int size = airline.getSize();

        // when
        airline.addAircraft(airplane);
        airline.addAircraft(airship);

        // then
        assertEquals(size + 2, airline.getSize());
    }
}