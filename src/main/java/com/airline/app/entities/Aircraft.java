package com.airline.app.entities;

public interface Aircraft {
    void goUp();

    void goDown();

    int getPassengerCapacity();

    int getCarryingCapacity();

    int getFlightRange();

    float getFuelConsumption();
}
