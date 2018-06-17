package com.airline.app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Airline {
    //    private static class AirlineHolder {
//        static final Airline HOLDER_INSTANCE = new Airline();
//    }
//
//    public static Airline getInstance() {
//        return AirlineHolder.HOLDER_INSTANCE;
//    }
//
    @Id
    @GeneratedValue
    private long id;
    /**
     * Name of the airline
     */
    private String name = "";

    /**
     * List of aircraftList,
     * an airline can contain both passenger and cargo aircraftList
     */
    @OneToMany(targetEntity = Aircraft.class)
    @JoinTable(
            joinColumns = @JoinColumn(name = "airline_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "aircraft_id", referencedColumnName = "id"))
    @Setter(AccessLevel.NONE)
    private List<IAircraft> aircraftList;

    /**
     * Author
     */
    @ManyToOne
    @JoinColumn(name = "author", nullable = false)
    @JsonBackReference
    private User author;

    /**
     * Public constructor
     */
    public Airline() {
        aircraftList = new ArrayList<>();
    }

    /**
     * Get aircraftList by index
     *
     * @return index of the aircraftList
     */
    public IAircraft getAircraft(int index) {
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
    public void addAircraft(IAircraft aircraft) {
        aircraftList.add(aircraft);
    }

    /**
     * Remove the aircraft from airline
     *
     * @param aircraft an aircraft to remove
     */
    void removeAircraft(IAircraft aircraft) {
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
        for (IAircraft a : aircraftList) {
            result.append(i++).append(". ").append(a.toString()).append("\n");
        }
        return result.toString();
    }

    public void setAircraftList(List<IAircraft> aircraftList) {
        this.aircraftList = aircraftList;
    }
}
