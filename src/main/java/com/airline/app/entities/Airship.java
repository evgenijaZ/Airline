package com.airline.app.entities;

import com.airline.app.entities.exceptions.IsAlreadyFlyingException;
import com.airline.app.entities.exceptions.IsNotFlyingYetException;

/**
 * Class Airship
 *
 * @author Yevheniia Zubrych on 04.02.2018.
 */
public class Airship extends AbstractAircraft {
    /**
     * Inherited from the AbstractAircraft method of takeoff
     */
    @Override
    public void goUp() {
        if (isFlying()) {
            throw new IsAlreadyFlyingException("airship",getModelName());
        }
        prepareForLaunch();
        setFlying(true);
        System.out.println("The airship " + getModelName() + " goes up.");
    }

    /**
     * Inherited from the AbstractAircraft method of landing
     */
    @Override
    public void goDown() {
        if (!isFlying()) {
            throw new IsNotFlyingYetException("airship",getModelName());
        }
        prepareForApproach();
        setFlying(false);
        System.out.println("The airship " + getModelName() + " goes down.");
    }

    /**
     * Preparation of an airship for departure
     */
    private void prepareForLaunch() {
        System.out.println("The balloon is filled with helium");
        System.out.println("Engines are running");
        System.out.println("The airship " + getModelName() + " is ready for flight.");
    }

    /**
     * Preparation of an airship for docking
     */
    private void prepareForApproach() {
        System.out.println("The landing site is freed");
        System.out.println("The ropes are fixed");
        System.out.println("The airship " + getModelName() + " is ready for docking.");
    }
}
