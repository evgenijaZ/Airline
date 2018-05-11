package com.airline.app.entities.builders;

import com.airline.app.entities.Airplane;
import com.airline.app.entities.CargoPlane;

public class CargoPlaneBuilder extends AirplaneBuilder {
    private int cargoWeight;

    public CargoPlaneBuilder setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
        return this;
    }

    @Override
    public CargoPlane build() {
        Airplane airplane = super.build();
        CargoPlane cargoPlane = new CargoPlane();
        copyProperties(cargoPlane);
        return cargoPlane;
    }

    void copyProperties(CargoPlane plane) {
        super.copyProperties(plane);
        plane.setCargoWeight(this.cargoWeight);
    }
}
