package com.airline.app;

import com.airline.app.aircrafts.Airplane;
import com.airline.app.aircrafts.CargoPlane;
import com.airline.app.aircrafts.PassengerPlane;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Yevheniia Zubrych on 06.02.2018.
 */
public class AirlineTest {
    private Airline airline;

    public AirlineTest() {
        airline = new Airline("UkraineAir");
        airline.addAirplane(new PassengerPlane("Boeing 737-300", 128, 69400, 6230, 2400, 790, 100));
        airline.addAirplane(new PassengerPlane("Boeing 737-800", 103, 52400, 5200, 2480, 840));
        airline.addAirplane(new PassengerPlane("Embraer E-190", 114, 51800, 4537, 1850, 852, 105));
        airline.addAirplane(new CargoPlane("Boeing 747-400F", 396890, 8230, 1350, 980, 300000));
    }

    @Test
    public void addAirplane() throws Exception {
        int size = airline.getSize();
        airline.addAirplane(new CargoPlane("An-124-100", 402000, 15700, 12600, 800, 20000));
        assertEquals(airline.getSize(), size + 1);
        assertNotNull(airline.getAirplane(size));
    }

    @Test
    public void sortAirplanesByFlightRange() throws Exception {
        airline.sortAirplanesByFlightRange();
        List <Airplane> airplanes = airline.getAirplanes();
        boolean flag = true;
        for (int i = 1; i < airplanes.size(); i++) {
            if (airplanes.get(i - 1).getFlightRange_km() > airplanes.get(i).getFlightRange_km())
                flag = false;
        }
        assertTrue(flag);
        airplanes.add(new CargoPlane("An-124-100", 402000, 0, 12600, 800, 20000));
        for (int i = 1; i < airplanes.size(); i++) {
            if (airplanes.get(i - 1).getFlightRange_km() > airplanes.get(i).getFlightRange_km())
                flag = false;
        }
        assertFalse(flag);
    }
    @Test
    public void filterByFuelConsumption() throws Exception {
        assertEquals(airline.filterByFuelConsumption(1000, -2000).size(), 0);
        int min = 1000;
        int max = 2000;
        List <Airplane> airplanes = airline.filterByFuelConsumption(min, max);
        boolean flag = true;
        for (int i = 1; i < airplanes.size(); i++) {
            if (min > airplanes.get(i).getFuelConsumption_lph() ||
                    airplanes.get(i).getFuelConsumption_lph() > max)
                flag = false;
        }
        assertTrue(flag);
    }

    @Test
    public void getTotalCapacity() throws Exception {
        assertEquals((new Airline("Empty airline")).getTotalCapacity(), 0);
        int totalCapacity = airline.getTotalCapacity();
        airline.addAirplane(new CargoPlane("An-124-100", 402000, 15700, 12600, 800, 20000));
        assertEquals(totalCapacity, airline.getTotalCapacity());
        airline.addAirplane(new PassengerPlane("Embraer E-190", 114, 51800, 4537, 1850, 852, 105));
        assertEquals(totalCapacity + 114, airline.getTotalCapacity());

    }

    @Test
    public void getTotalCarryingCapacity() throws Exception {
        assertEquals((new Airline("Empty airline")).getTotalCarryingCapacity(), 0);
        int totalCarryingCapacity = airline.getTotalCarryingCapacity();
        airline.addAirplane(new CargoPlane("An-124-100", 402000, 15700, 12600, 800, 20000));
        totalCarryingCapacity += 402000;
        assertEquals(totalCarryingCapacity, airline.getTotalCarryingCapacity());
        airline.addAirplane(new PassengerPlane("Embraer E-190", 114, 51800, 4537, 1850, 852, 105));
        totalCarryingCapacity += 51800;
        assertEquals(totalCarryingCapacity, airline.getTotalCarryingCapacity());

    }

}