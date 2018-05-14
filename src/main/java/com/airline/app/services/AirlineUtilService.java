package com.airline.app.services;

import com.airline.app.entities.Airline;
import com.airline.app.entities.IAircraft;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class for Airline
 */
@Service
public class AirlineUtilService {

    /**
     * Calculate total passenger capacity of all aircraftList in the airline
     *
     * @param airline the airline
     * @return total capacity
     */
    public int getTotalPassengerCapacity(Airline airline) {
        List<IAircraft> aircraftList = airline.getAircraftList();
        int totalCapacity = 0;
        for (IAircraft airplane : aircraftList) {
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
    public int getTotalCarryingCapacity(Airline airline) {
        List<IAircraft> aircraftList = airline.getAircraftList();
        int totalCapacity = 0;
        for (IAircraft airplane : aircraftList) {
            totalCapacity += airplane.getCarryingCapacity();
        }
        return totalCapacity;
    }

    /**
     * Sort all airplanes in the airline by flight range from smaller to larger
     *
     * @param airline the airline
     */
    public List<IAircraft> getSortedByFlightRangeAircraftList(Airline airline) {
        List<IAircraft> aircraftList = airline.getAircraftList();
        aircraftList.sort(Comparator.comparingInt(IAircraft::getFlightRange));
        return aircraftList;
    }

    /**
     * Find  all airplanes corresponding to the specified range of fuel consumption parameters (liters per hour)
     *
     * @param airline  the airline
     * @param minValue lower bound of fuel consumption values
     * @param maxValue higher bound of fuel consumption values
     * @return list of elements that satisfy the conditions
     */
    public List<IAircraft> getFilteredByFuelConsumptionAircraftList(Airline airline, float minValue, float maxValue) {
        List<IAircraft> aircraftList = airline.getAircraftList();
        Iterable<IAircraft> filtered = aircraftList.stream().filter(airplane -> airplane.getFuelConsumption() >= minValue && airplane.getFuelConsumption() <= maxValue).collect(Collectors.toList());
        return (List<IAircraft>) filtered;
    }

    /**
     * Find  all airplanes corresponding to the passenger capacity and flight range(kmph)
     *
     * @param airline  the airline
     * @param passengerCapacity passenger capacity
     * @param flightRange flight range
     * @return list of elements that satisfy the conditions
     */
    public List<IAircraft> getFilteredByPassengerCapacityAndFlightRangeAircraftList(Airline airline, int passengerCapacity, int flightRange) {
        List<IAircraft> aircraftList = airline.getAircraftList();
        Iterable<IAircraft> filtered = aircraftList.stream().filter(airplane -> airplane.getPassengerCapacity() == passengerCapacity && airplane.getFlightRange() == flightRange).collect(Collectors.toList());
        return (List<IAircraft>) filtered;
    }
}
