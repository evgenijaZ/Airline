package com.airline.app.entities.builders;

import com.airline.app.entities.Airship;

public class AirshipBuilder extends AircraftBuilder {
    @Override
    public Airship build() {
        Airship airship = new Airship();
        copyProperties(airship);
        return airship;
    }

    protected void copyProperties(Airship airship) {
        super.copyProperties(airship);
    }
}
