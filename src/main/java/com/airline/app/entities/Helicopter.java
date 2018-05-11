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
 * Class Helicopter
 *
 * @author Yevheniia Zubrych on 04.02.2018.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@JsonDeserialize(using=JsonDeserializer.None.class)
public class Helicopter extends Aircraft {
    /**
     * The main rotor diameter in meters
     */
    private double rotorDiameter;
    /**
     * Speed of the helicopter blades in meters per second
     */
    private double velocity;

    /**
     * Inherited from the Aircraft method of takeoff
     */
    @Override
    public void goUp() {
        if (isFlying()) {
            throw new IsAlreadyFlyingException("helicopter", getModelName());
        }
        rotate();
        setFlying(true);
        System.out.println("The helicopter " + getModelName() + " goes up.");
    }

    /**
     * Inherited from the Aircraft method of landing
     */
    @Override
    public void goDown() {
        if (!isFlying()) {
            throw new IsNotFlyingYetException("helicopter", getModelName());
        }
        this.velocity = 0;
        setFlying(false);
        System.out.println("The helicopter " + getModelName() + " goes down.");
    }

    /**
     * Rotate the blades of a helicopter
     */
    private void rotate() {
        velocity = (rotorDiameter / 2) * (3.14 * 190 / 30);
        System.out.println("The helicopter rotates. Speed of the helicopter blades is " + this.velocity + " mps");
    }
}
