package com.airline.app;

/**
 * @author Yevheniia Zubrych on 04.02.2018.
 */
public class Airship extends Aircraft{
    Airship(String modelName, int capacity, int carryingCapacity_kg, int flightRange_km) {
        super(modelName, capacity, carryingCapacity_kg, flightRange_km);
    }

    /**
     * abstract method of takeoff of an aircraft
     */
    @Override
    public void goUp() {
        if (isFlying) {
            System.out.println("The airship " + modelName + " is already flying.");
            return;
        }
        prepareForLaunch();
        isFlying = true;
        System.out.println("The airship " + modelName + " goes up.");
    }

    /**
     * abstract method of landing an aircraft
     */
    @Override
    public void goDown() {
        if (!this.isFlying) {
            System.out.println("The airship " + modelName + " is not in flight yet.");
            return;
        }
        prepareForApproach();
        isFlying = false;
        System.out.println("The airship " + modelName + " goes down.");
    }

    /**
     * preparation of an airship for departure
     */
    private void prepareForLaunch(){
        System.out.println("The balloon is filled with helium");
        System.out.println("Engines are running");
        System.out.println("The airship " + modelName + " is ready for flight.");
    }

    /**
     * preparation of an airship for docking
     */
    private void prepareForApproach(){
        System.out.println("The landing site is freed");
        System.out.println("The ropes are fixed");
        System.out.println("The airship " + modelName + " is ready for docking.");
    }
}
