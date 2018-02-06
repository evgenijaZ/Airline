package com.airline.app.aircrafts;

/**
 * Class Aircraft
 *
 * @author Yevheniia Zubrych on 03.02.2018.
 */
public abstract class Aircraft {
    /**
     * The model name of the aircraft,
     * It is defined in the constructor
     */
    String modelName;
    /**
     * The passenger capacity of the aircraft,
     * It is defined in the constructor
     */
    int capacity;
    /**
     * Maximum carrying capacity of the aircraft in kilograms,
     * It is defined in the constructor
     */
    int carryingCapacity_kg;
    /**
     * Maximum flight range of the aircraft in kilometers,
     * It is defined in the constructor
     */
    int flightRange_km;
    /**
     * Is there an airplane in flight,
     * Default value is false
     */
    boolean isFlying;

    /**
     * Constructor for class Aircraft
     *
     * @param modelName           model name
     * @param capacity            aircraft capacity
     * @param carryingCapacity_kg carrying capacity
     * @param flightRange_km      flight range
     */
    Aircraft(String modelName, int capacity, int carryingCapacity_kg, int flightRange_km) {
        if(capacity<0||carryingCapacity_kg<0||flightRange_km<0)
            throw new IllegalArgumentException("Arguments should be positive");
        this.modelName = modelName;
        this.capacity = capacity;
        this.carryingCapacity_kg = carryingCapacity_kg;
        this.flightRange_km = flightRange_km;
        this.isFlying = false;
    }

    /**
     * Abstract method of takeoff of an aircraft
     */
    public abstract void goUp();

    /**
     * Abstract method of landing an aircraft
     */
    public abstract void goDown() throws Exception;

    /**
     * Return model name passed to the constructor
     *
     * @return model name
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Return capacity passed to the constructor
     *
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Return carrying capacity passed to the constructor
     *
     * @return carrying capacity
     */
    public int getCarryingCapacity_kg() {
        return carryingCapacity_kg;
    }

    /**
     * Return flight range passed to the constructor
     *
     * @return flight range
     */
    public int getFlightRange_km() {
        return flightRange_km;
    }

    /**
     * @return true if the aircraft is flying
     */
    public boolean isFlying() {
        return isFlying;
    }
}
