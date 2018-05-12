package com.airline.app.entities.builders;

import com.airline.app.entities.Airplane;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class AirplaneBuilderTest {

    @Autowired
    private AirplaneBuilder airplaneBuilder;

    @Test
    public void whetSetCruisingSpeed_thenSpeedShouldBeSet() {
        //given
        airplaneBuilder.setCruisingSpeed(657);

        //when
        Airplane airplane = airplaneBuilder.build();

        //then
        assertEquals(657, airplane.getCruisingSpeed());
    }


    @TestConfiguration
    static class AirplaneBuilderTestContextConfiguration {
        @Bean
        public AirplaneBuilder airplaneBuilder() {
            return new AirplaneBuilder();
        }
    }

}