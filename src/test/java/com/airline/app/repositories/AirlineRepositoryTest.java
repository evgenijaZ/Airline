package com.airline.app.repositories;

import com.airline.app.entities.Airline;
import com.airline.app.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@DataJpaTest
public class AirlineRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private  AirlineRepository airlineRepository;

    @Test
    public void whenFindByName_thenReturnAirline() {
        // given
        Airline airline=new Airline();
        airline.setName("WindRose");
        User author = new User();
        author.setEmail("email@example.com");
        author.setPassword("password");
        airline.setAuthor(author);
        entityManager.persist(author);
        entityManager.persist(airline);
        entityManager.flush();

        // when
        Airline found = airlineRepository.findByName(airline.getName());

        // then
        assertEquals(found.getName(),airline.getName());
    }
}