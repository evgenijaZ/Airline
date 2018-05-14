package com.airline.app.entities.builders;

import com.airline.app.entities.Airplane;
import org.springframework.stereotype.Component;

public class AirplaneBuilder extends AircraftBuilder {
    private int cruisingSpeed;

    public AirplaneBuilder setCruisingSpeed(int cruisingSpeed) {
        this.cruisingSpeed = cruisingSpeed;
        return this;
    }

    @Override
    public Airplane build() {
        Airplane airplane = new Airplane();
        copyProperties(airplane);
        return airplane;
    }

    protected void copyProperties(Airplane plane) {
        super.copyProperties(plane);
        plane.setCruisingSpeed(this.cruisingSpeed);

    }
}
