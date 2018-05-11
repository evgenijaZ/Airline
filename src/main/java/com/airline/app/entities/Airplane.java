package com.airline.app.entities;

import com.airline.app.entities.exceptions.IsAlreadyFlyingException;
import com.airline.app.entities.exceptions.IsNotFlyingYetException;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * Class Airplane
 *
 * @author Yevheniia Zubrych on 04.02.2018.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@JsonDeserialize(using=JsonDeserializer.None.class)
public class Airplane extends Aircraft {

    /**
     * Cruising speed of the airplane in kilometre per hour
     */
    private int cruisingSpeed;

    /**
     * Inherited from the Aircraft method of takeoff
     */
    @Override
    public void goUp() {
        if (isFlying()) {
            throw new IsAlreadyFlyingException("airplane", getModelName());
        }
        System.out.println("The airplane " + getModelName() + " is leaving on a runway, accelerating, taking off.");
        setFlying(true);
        System.out.println("The airplane " + getModelName() + " has gained cruising speed " + this.cruisingSpeed + "km/h and flies.");
    }

    /**
     * Inherited from the Aircraft method of landing
     */
    @Override
    public void goDown() {
        if (!isFlying()) {
            throw new IsNotFlyingYetException("airplane", getModelName());
        }
        System.out.println("The airplane " + getModelName() + " is going down and landing on the runway.");
        setFlying(false);
        System.out.println("The airplane " + getModelName() + " has landed.");
    }

    /**
     * Represents the airplane as string
     *
     * @return airplane as string
     */
    @Override
    public String toString() {
        return (getModelName() + "\n\t" +
                "passenger capacity: " + getPassengerCapacity() + ";\n\t" +
                "carrying capacity: " + getCarryingCapacity() + "kg;\n\t" +
                "flight range: " + getFlightRange() + "km;\n\t" +
                "fuel consumption: " + getFuelConsumption() + "l/h;\n\t" +
                "cruising speed: " + cruisingSpeed + "km/h; \n");
    }
}
