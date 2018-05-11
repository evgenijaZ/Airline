package com.airline.app.entities;

import com.airline.app.entities.exceptions.IllegalPassengerCapacityForCargoPlaneException;
import com.airline.app.entities.exceptions.IsTooHeavyException;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * Class CargoPlane
 *
 * @author Yevheniia Zubrych on 04.02.2018.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@JsonDeserialize(using=JsonDeserializer.None.class)
public class CargoPlane extends Airplane {
    /**
     * The cargo weight in kilograms
     */
    private int cargoWeight;

    /**
     * Inherited from the Airplane method of takeoff
     */
    @Override
    public void goUp() {
        if (!loadCargo()) {
            throw new IllegalStateException("Flying of " + getModelName() + " is impossible");
        }
        super.goUp();
    }

    /**
     * Inherited from the Airplane method of landing
     */
    @Override
    public void goDown() {
        super.goDown();
        unloadCargo();
    }

    /**
     * Load a cargo on the plane
     *
     * @return true if whole cargo is on the board, false if something went wrong
     */
    private boolean loadCargo() {
        if (cargoWeight > getCarryingCapacity()) {
            throw new IsTooHeavyException(getModelName(), cargoWeight, getCarryingCapacity());
        } else
            System.out.println("Whole cargo (" + cargoWeight + ") is already on the board of " + getModelName());
        return true;
    }

    /**
     * Unload cargo from the plane
     */
    private void unloadCargo() {
        System.out.println("Whole cargo is unloaded");
    }

    @Override
    public void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity == 0)
            super.setPassengerCapacity(passengerCapacity);
        else
            throw new IllegalPassengerCapacityForCargoPlaneException("Cargo plane cannot deliver passengers");
    }

    /**
     * Represents the cargo plane as string
     *
     * @return plane as string
     */
    @Override
    public String toString() {
        return "The cargo plane " + super.toString() +
                "\tcargo weight: " + cargoWeight + "kg;\n";
    }

}
