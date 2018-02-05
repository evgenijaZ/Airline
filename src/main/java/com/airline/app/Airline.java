package com.airline.app;

import com.airline.app.aircrafts.Aircraft;
import com.airline.app.aircrafts.Airplane;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yevheniia Zubrych on 04.02.2018.
 */
public class Airline {
    private String name;

    private List <Airplane> airplanes;

    public Airline(String name) {
        this.name = name;
        airplanes = new ArrayList <>();
    }

    List <Airplane> getAirplanes() {
        return airplanes;
    }

    void addAirplane(Airplane airplane) {
        airplanes.add(airplane);
    }

    void removeAirplane(Airplane airplane) {
        airplanes.remove(airplane);
    }

    void sortAirplanesByFlightRange() {
        airplanes.sort(Comparator.comparingInt(Aircraft::getFlightRange_km));
    }

    List <Airplane> filterByFuelConsumption(int minValue, int maxValue) {
        Iterable <Airplane> filtered = airplanes.stream().filter(airplane -> airplane.getFuelConsumption_lph() >= minValue && airplane.getFuelConsumption_lph() <= maxValue).collect(Collectors.toList());
        return (List <Airplane>) filtered;
    }

    int getTotalCapacity() {
        final int[] totalCapacity = {0};
        airplanes.forEach(airplane -> totalCapacity[0] = airplane.getCapacity());
        return totalCapacity[0];
    }

    int getTotalCarryingCapacity() {
        final int[] totalCarryingCapacity = {0};
        airplanes.forEach(airplane -> totalCarryingCapacity[0] = airplane.getCarryingCapacity_kg());
        return totalCarryingCapacity[0];
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Airline '" + name + "'\n");
        airplanes.forEach(a -> result.append(a.toString()).append("\n"));
        return result.toString();
    }
}
