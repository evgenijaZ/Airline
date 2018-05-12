package com.airline.app.entities.builders;

import com.airline.app.entities.CargoPlane;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class CargoPlaneBuilderTest {

    @Autowired
    private CargoPlaneBuilder cargoPlaneBuilder;

    @Test
    public void whetSetCargoWeight_thenCargoWeightShouldBeSet() {
        //given
        cargoPlaneBuilder.setCargoWeight(50_000);

        //when
        CargoPlane cargoPlane = cargoPlaneBuilder.build();

        //then
        assertEquals(50_000, cargoPlane.getCargoWeight());
    }


    @TestConfiguration
    static class CargoPlaneBuilderTestContextConfiguration {
        @Bean
        public CargoPlaneBuilder cargoPlaneBuilder() {
            return new CargoPlaneBuilder();
        }
    }

}