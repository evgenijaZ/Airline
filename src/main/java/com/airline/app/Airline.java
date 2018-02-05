package com.airline.app;

import com.airline.app.aircrafts.Aircraft;
import com.airline.app.aircrafts.Airplane;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class Airline can contain airplanes,
 * has methods for calculating total capacity and carrying capacity of all the aircraft in the airline,
 * for sorting the airplanes by flight range (from smaller to larger)
 * and for filtering airplanes corresponding to the specified range of fuel consumption parameters (liters per hour).
 *
 * @author Yevheniia Zubrych on 04.02.2018.
 */
public class Airline {
    /**
     * Name of the airline
     */
    private String name;
    /**
     * List of airplanes,
     * an airline can contain both passenger and cargo airplane
     */
    private List <Airplane> airplanes;

    /**
     * Constructor for class Airline
     *
     * @param name name of the airline
     */
    public Airline(String name) {
        this.name = name;
        airplanes = new ArrayList <>();
    }

    /**
     * Get list of airplanes of the airline
     *
     * @return list of airplanes
     */
    List <Airplane> getAirplanes() {
        return airplanes;
    }

    /**
     * Get airplane by index
     *
     * @return index of the airplane
     */
    Airplane getAirplane(int index) {
        if (index < 0 || index >= airplanes.size()) {
            System.out.println("Incorrect index. Value should be between 0 and " + (airplanes.size() - 1));
            return null;
        }
        return airplanes.get(index);
    }

    /**
     * Add a new one airplane to the airline
     *
     * @param airplane a new one airplane
     */
    void addAirplane(Airplane airplane) {
        airplanes.add(airplane);
    }

    /**
     * Remove the airplane from airline
     *
     * @param airplane an airplane to remove
     */
    void removeAirplane(Airplane airplane) {
        airplanes.remove(airplane);
    }

    /**
     * Sort all airplanes in the airline by flight range from smaller to larger
     */
    void sortAirplanesByFlightRange() {
        airplanes.sort(Comparator.comparingInt(Aircraft::getFlightRange_km));
    }

    /**
     * Find  all airplanes corresponding to the specified range of fuel consumption parameters (liters per hour)
     *
     * @param minValue lower bound of fuel consumption values
     * @param maxValue higher bound of fuel consumption values
     * @return list of elements that satisfy the conditions
     */
    List <Airplane> filterByFuelConsumption(int minValue, int maxValue) {
        Iterable <Airplane> filtered = airplanes.stream().filter(airplane -> airplane.getFuelConsumption_lph() >= minValue && airplane.getFuelConsumption_lph() <= maxValue).collect(Collectors.toList());
        return (List <Airplane>) filtered;
    }

    /**
     * Calculate total capacity of all the aircraft in the airline
     *
     * @return total capacity
     */
    int getTotalCapacity() {
        final int[] totalCapacity = {0};
        airplanes.forEach(airplane -> totalCapacity[0] += airplane.getCapacity());
        return totalCapacity[0];
    }

    /**
     * Calculate total carrying capacity of all the aircraft in the airline
     *
     * @return total carrying capacity
     */
    int getTotalCarryingCapacity() {
        final int[] totalCarryingCapacity = {0};
        airplanes.forEach(airplane -> totalCarryingCapacity[0] += airplane.getCarryingCapacity_kg());
        return totalCarryingCapacity[0];
    }

    /**
     * Print airline to console
     */
    void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Airline '" + name + "'\n");
        airplanes.forEach(a -> result.append(a.toString()).append("\n"));
        return result.toString();
    }
}
