package com.airline.app.entities;

import com.airline.app.entities.exceptions.NoPassengersOnBoardException;
import com.airline.app.entities.exceptions.NotEnoughPlacesException;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * Class passenger plane
 * passenger version of the airplane
 *
 * @author Yevheniia Zubrych on 04.02.2018.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@JsonDeserialize(using = JsonDeserializer.None.class)
public class PassengerPlane extends Airplane {
    /**
     * Number of passengers on the plane
     */
    private int numberOfPassengers;

    /**
     * Inherited from the Airplane method of takeoff
     */
    @Override
    public void goUp() {
        if (seatPassengers())
            super.goUp();
    }

    /**
     * Inherited from the Airplane method of landing
     */
    @Override
    public void goDown() {
        super.goDown();
        freeSeats();
    }

    /**
     * Seat the passengers of the plane by places
     *
     * @return true if all passengers are on the board, false if something went wrong
     */
    public boolean seatPassengers() {
        if (numberOfPassengers > getPassengerCapacity()) {
            throw new NotEnoughPlacesException(numberOfPassengers, getPassengerCapacity(), getModelName());
        } else if (numberOfPassengers == 0) {
            throw new NoPassengersOnBoardException(getPassengerCapacity(), getModelName());
        } else
            System.out.println("All " + numberOfPassengers + " passengers are already on the board of " + getModelName() + ".");
        return true;
    }

    /**
     * Release passenger seats
     */
    private void freeSeats() {
        System.out.println("All passengers left the the board of " + getModelName());
    }

    /**
     * Represents the passenger plane as string
     *
     * @return plane as string
     */
    @Override
    public String toString() {
        return "The passenger plane " + super.toString() +
                "\tnumber of passengers: " + numberOfPassengers + ";\n";
    }
}
