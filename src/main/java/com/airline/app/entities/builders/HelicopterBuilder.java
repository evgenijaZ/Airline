package com.airline.app.entities.builders;

import com.airline.app.entities.Helicopter;

public class HelicopterBuilder extends AircraftBuilder {
    private double rotorDiameter;
    private double velocity;

    public HelicopterBuilder setRotorDiameter(double rotorDiameter) {
        this.rotorDiameter = rotorDiameter;
        return this;
    }

    public HelicopterBuilder setVelocity(double velocity) {
        this.velocity = velocity;
        return this;
    }

    @Override
    public Helicopter build() {
        Helicopter helicopter = new Helicopter();
        copyProperties(helicopter);
        return helicopter;
    }

    void copyProperties(Helicopter helicopter) {
        super.copyProperties(helicopter);
        helicopter.setRotorDiameter(this.rotorDiameter);
        helicopter.setVelocity(this.velocity);
    }
}
