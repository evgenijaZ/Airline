package com.airline.app.entities;

public interface IAircraft {
    void goUp();

    void goDown();

    int getPassengerCapacity();

    int getCarryingCapacity();

    int getFlightRange();

    float getFuelConsumption();
}
