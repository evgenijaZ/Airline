package com.airline.app.services;

import com.airline.app.entities.Airline;
import com.airline.app.entities.Aircraft;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AirlineService {

    /**
     * Calculate total passenger capacity of all aircraftList in the airline
     *
     * @param airline the airline
     * @return total capacity
     */
    public static int getTotalPassengerCapacity(Airline airline) {
        List<Aircraft> aircraftList = airline.getAircraftList();
        int totalCapacity = 0;
        for (Aircraft airplane : aircraftList) {
            totalCapacity += airplane.getPassengerCapacity();
        }
        return totalCapacity;
    }


    /**
     * Calculate total carrying capacity of all aircraftList in the airline
     *
     * @param airline the airline
     * @return total carrying capacity
     */
    public static int getTotalCarryingCapacity(Airline airline) {
        List<Aircraft> aircraftList = airline.getAircraftList();
        int totalCapacity = 0;
        for (Aircraft airplane : aircraftList) {
            totalCapacity += airplane.getCarryingCapacity();
        }
        return totalCapacity;
    }

    /**
     * Sort all airplanes in the airline by flight range from smaller to larger
     *
     * @param airline the airline
     */
    public static void sortAirplanesByFlightRange(Airline airline) {
        List<Aircraft> aircraftList = airline.getAircraftList();
        aircraftList.sort(Comparator.comparingInt(Aircraft::getFlightRange));
    }

    /**
     * Find  all airplanes corresponding to the specified range of fuel consumption parameters (liters per hour)
     *
     * @param airline  the airline
     * @param minValue lower bound of fuel consumption values
     * @param maxValue higher bound of fuel consumption values
     * @return list of elements that satisfy the conditions
     */
    public static List<Aircraft> filterByFuelConsumption(Airline airline, int minValue, int maxValue) {
        List<Aircraft> aircraftList = airline.getAircraftList();
        Iterable<Aircraft> filtered = aircraftList.stream().filter(airplane -> airplane.getFuelConsumption() >= minValue && airplane.getFuelConsumption() <= maxValue).collect(Collectors.toList());
        return (List<Aircraft>) filtered;
    }
}
