package com.airline.app.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Airline can contain aircraftList,
 * has methods for calculating total capacity and carrying capacity of all the aircraftList in the airline,
 * for sorting the aircraftList by flight range (from smaller to larger)
 * and for filtering aircraftList corresponding to the specified range of fuel consumption parameters (liters per hour).
 *
 * @author Yevheniia Zubrych on 04.02.2018.
 */
@Getter
@Setter
public class Airline {
    private static class AirlineHolder {
        static final Airline HOLDER_INSTANCE = new Airline();
    }

    public static Airline getInstance() {
        return AirlineHolder.HOLDER_INSTANCE;
    }

    private Airline() {
        aircraftList = new ArrayList<>();
    }

    /**
     * Name of the airline
     */
    private String name = "";
    /**
     * List of aircraftList,
     * an airline can contain both passenger and cargo aircraftList
     */
    private List<Aircraft> aircraftList;

    /**
     * Get aircraftList by index
     *
     * @return index of the aircraftList
     */
    public Aircraft getAircraft(int index) {
        if (index < 0 || index >= aircraftList.size()) {
            throw new IndexOutOfBoundsException("Incorrect index. Value should be between 0 and " + (aircraftList.size() - 1));
        }
        return aircraftList.get(index);
    }

    /**
     * Add a new one aircraft to the airline
     *
     * @param aircraft a new one aircraft
     */
    public void addAircraft(Aircraft aircraft) {
        aircraftList.add(aircraft);
    }

    /**
     * Remove the aircraft from airline
     *
     * @param aircraft an aircraft to remove
     */
    void removeAircraft(Aircraft aircraft) {
        aircraftList.remove(aircraft);
    }

    /**
     * Print airline to console
     */
    public void print() {
        System.out.println(this.toString());
    }

    /**
     * Get size of aircraftList list
     *
     * @return size of aircraftList list
     */
    public int getSize() {
        return aircraftList.size();
    }

    @Override
    public String toString() {
        int i = 0;
        StringBuilder result = new StringBuilder("Airline '" + name + "'\n");
        for (Aircraft a : aircraftList) {
            result.append(i++).append(". ").append(a.toString()).append("\n");
        }
        return result.toString();
    }
}
