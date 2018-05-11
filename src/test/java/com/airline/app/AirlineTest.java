package com.airline.app;

import com.airline.app.entities.Aircraft;
import com.airline.app.entities.Airline;
import com.airline.app.entities.builders.CargoPlaneBuilder;
import com.airline.app.entities.builders.PassengerPlaneBuilder;
import com.airline.app.services.AirlineUtilService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Yevheniia Zubrych on 06.02.2018.
 */
public class AirlineTest {
    /**
     * Airline
     */
    private Airline airline;
    private PassengerPlaneBuilder passengerPlaneBuilder = new PassengerPlaneBuilder();
    private CargoPlaneBuilder cargoPlaneBuilder = new CargoPlaneBuilder();

    /**
     * Constructor for class AirlineTest
     * Initialise airline and add few airplanes
     */
    public AirlineTest() {
//      airline = Airline.getInstance();
        airline = new Airline();
        airline.setName("UkraineAir");


        airline.addAircraft(
                ((PassengerPlaneBuilder) passengerPlaneBuilder
                        .setModelName("Boeing 737-300")
                        .setPassengerCapacity(128)
                        .setCarryingCapacity(69_400)
                        .setFlightRange(6230)
                        .setFuelConsumption(2400)
                        .setCruisingSpeed(790))
                        .setNumberOfPassengers(100)
                        .build()
        );

        airline.addAircraft(
                ((PassengerPlaneBuilder) passengerPlaneBuilder
                        .setModelName("Boeing 737-800")
                        .setPassengerCapacity(103)
                        .setCarryingCapacity(52_400)
                        .setFlightRange(5200)
                        .setFuelConsumption(2480)
                        .setCruisingSpeed(840))
                        .setNumberOfPassengers(0)
                        .build()
        );

        airline.addAircraft(
                ((PassengerPlaneBuilder) passengerPlaneBuilder
                        .setModelName("Embraer E-190")
                        .setPassengerCapacity(114)
                        .setCarryingCapacity(51_800)
                        .setFlightRange(4537)
                        .setFuelConsumption(1850)
                        .setCruisingSpeed(852))
                        .setNumberOfPassengers(105)
                        .build()
        );

        airline.addAircraft(
                ((CargoPlaneBuilder) cargoPlaneBuilder
                        .setModelName("Boeing 747-400F")
                        .setCarryingCapacity(396_890)
                        .setFlightRange(8230)
                        .setFuelConsumption(1350)
                        .setCruisingSpeed(980))
                        .setCargoWeight(300_000)
                        .build()
        );

        airline.addAircraft(
                ((CargoPlaneBuilder) cargoPlaneBuilder
                        .setModelName("An-124-100")
                        .setCarryingCapacity(402_000)
                        .setFlightRange(15700)
                        .setFuelConsumption(12_600)
                        .setCruisingSpeed(800))
                        .setCargoWeight(20_000)
                        .build()
        );

    }

    /**
     * Add a new one airplane to airline, check size
     */
    @Test
    public void addAirplane() {
        int size = airline.getSize();
        airline.addAircraft(
                ((CargoPlaneBuilder) cargoPlaneBuilder
                        .setModelName("An-124-100")
                        .setCarryingCapacity(402_000)
                        .setFlightRange(15700)
                        .setFuelConsumption(12_600)
                        .setCruisingSpeed(800))
                        .setCargoWeight(20_000)
                        .build()
        );
        assertEquals(airline.getSize(), size + 1);
        assertNotNull(airline.getAircraft(size));
    }

    /**
     * Sort by flight range
     * Check whether all elements satisfy order
     */
    @Test
    public void sortAirplanesByFlightRange() {

        List<Aircraft> airplanes = AirlineUtilService.getSortedByFlightRangeAircraftList(airline);
        boolean flag = true;
        for (int i = 1; i < airplanes.size(); i++) {
            if (airplanes.get(i - 1).getFlightRange() > airplanes.get(i).getFlightRange())
                flag = false;
        }
        assertTrue(flag);
        airline.addAircraft(
                ((CargoPlaneBuilder) cargoPlaneBuilder
                        .setModelName("An-124-100")
                        .setCarryingCapacity(402_000)
                        .setFlightRange(14700)
                        .setFuelConsumption(12_600)
                        .setCruisingSpeed(800))
                        .setCargoWeight(20_000)
                        .build()
        );
        for (int i = 1; i < airplanes.size(); i++) {
            if (airplanes.get(i - 1).getFlightRange() > airplanes.get(i).getFlightRange())
                flag = false;
        }
        assertFalse(flag);
    }

    /**
     * Filter by fuel consumption
     * Check if all items meet the filtering conditions
     */
    @Test
    public void filterByFuelConsumption() {
        assertEquals(AirlineUtilService.getFilteredByFuelConsumptionAircraftList(airline, 1000, -2000).size(), 0);
        int min = 1000;
        int max = 2000;
        List<Aircraft> airplanes = AirlineUtilService.getFilteredByFuelConsumptionAircraftList(airline, min, max);
        boolean flag = true;
        for (int i = 1; i < airplanes.size(); i++) {
            if (min > airplanes.get(i).getFuelConsumption() ||
                    airplanes.get(i).getFuelConsumption() > max)
                flag = false;
        }
        assertTrue(flag);
    }

    /**
     * Check whether the total capacity values are being counted correctly
     */
    @Test
    public void getTotalCapacity() {
        // assertEquals(Airline.getInstance()).getTotalCapacity(), 0);
        int totalCapacity = AirlineUtilService.getTotalPassengerCapacity(airline);
        airline.addAircraft(((CargoPlaneBuilder) cargoPlaneBuilder
                .setModelName("An-124-100")
                .setCarryingCapacity(402_000)
                .setFlightRange(15700)
                .setFuelConsumption(12_600)
                .setCruisingSpeed(800))
                .setCargoWeight(20_000)
                .build()
        );
        assertEquals(totalCapacity, AirlineUtilService.getTotalPassengerCapacity(airline));
        airline.addAircraft(
                ((PassengerPlaneBuilder) passengerPlaneBuilder
                        .setModelName("Embraer E-190")
                        .setPassengerCapacity(114)
                        .setCarryingCapacity(51_800)
                        .setFlightRange(4537)
                        .setFuelConsumption(1850)
                        .setCruisingSpeed(852))
                        .setNumberOfPassengers(105)
                        .build()
        );
        assertEquals(totalCapacity + 114, AirlineUtilService.getTotalPassengerCapacity(airline));
    }


    /**
     * Check whether the total carrying capacity values are being counted correctly
     */
    @Test
    public void getTotalCarryingCapacity() {
        int totalCapacity = AirlineUtilService.getTotalCarryingCapacity(airline);
        airline.addAircraft(((CargoPlaneBuilder) cargoPlaneBuilder
                .setModelName("An-124-100")
                .setCarryingCapacity(402_000)
                .setFlightRange(15700)
                .setFuelConsumption(12_600)
                .setCruisingSpeed(800))
                .setCargoWeight(20_000)
                .build()
        );

        assertEquals(totalCapacity + 402_000, AirlineUtilService.getTotalCarryingCapacity(airline));
        airline.addAircraft(
                ((PassengerPlaneBuilder) passengerPlaneBuilder
                        .setModelName("Embraer E-190")
                        .setPassengerCapacity(114)
                        .setCarryingCapacity(51_800)
                        .setFlightRange(4537)
                        .setFuelConsumption(1850)
                        .setCruisingSpeed(852))
                        .setNumberOfPassengers(105)
                        .build()
        );
        assertEquals(totalCapacity + 402_000 + 51_800, AirlineUtilService.getTotalCarryingCapacity(airline));

    }

}