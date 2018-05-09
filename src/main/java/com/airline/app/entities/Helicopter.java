package com.airline.app.entities;

import com.airline.app.entities.exceptions.IsAlreadyFlyingException;
import com.airline.app.entities.exceptions.IsNotFlyingYetException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class Helicopter
 *
 * @author Yevheniia Zubrych on 04.02.2018.
 */
@Getter
@Setter
@NoArgsConstructor
public class Helicopter extends AbstractAircraft {
    /**
     * The main rotor diameter in meters
     */
    private double rotorDiameter;
    /**
     * Speed of the helicopter blades in meters per second
     */
    private double velocity;

    /**
     * Inherited from the AbstractAircraft method of takeoff
     */
    @Override
    public void goUp() {
        if (isFlying()) {
            throw new IsAlreadyFlyingException("helicopter",getModelName());
        }
        rotate();
        setFlying(true);
        System.out.println("The helicopter " + getModelName() + " goes up.");
    }

    /**
     * Inherited from the AbstractAircraft method of landing
     */
    @Override
    public void goDown() {
        if (!isFlying()) {
            throw new IsNotFlyingYetException("helicopter",getModelName());
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
