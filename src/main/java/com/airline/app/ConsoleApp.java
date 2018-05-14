package com.airline.app;

import com.airline.app.entities.Airline;
import com.airline.app.entities.builders.AirplaneBuilder;
import com.airline.app.entities.builders.CargoPlaneBuilder;
import com.airline.app.entities.builders.PassengerPlaneBuilder;
import com.airline.app.services.Menu;
//import com.airline.app.services.Menu;

/**
 * Main class of the airline application
 *
 * @author Yevheniia Zubrych on 03.02.2018.
 */
public class ConsoleApp {
    public static void main(String[] args) {
//      Airline airline = Airline.getInstance();
        Airline airline = new Airline();
        airline.setName("UkraineAir");

//        PassengerPlaneBuilder passengerPlaneBuilder = new PassengerPlaneBuilder();
//        CargoPlaneBuilder cargoPlaneBuilder = new CargoPlaneBuilder();

//        airline.addAircraft(
//                ((PassengerPlaneBuilder)
//                        ((AirplaneBuilder)
//                                passengerPlaneBuilder
//                                        .setModelName("Boeing 737-300")
//                                        .setPassengerCapacity(128)
//                                        .setCarryingCapacity(69_400)
//                                        .setFlightRange(6230)
//                                        .setFuelConsumption(2400))
//                                .setCruisingSpeed(790))
//                        .setNumberOfPassengers(100)
//                        .build()
//        );
//
//        airline.addAircraft(
//                ((PassengerPlaneBuilder)
//                        ((AirplaneBuilder) passengerPlaneBuilder
//                                .setModelName("Boeing 737-800")
//                                .setPassengerCapacity(103)
//                                .setCarryingCapacity(52_400)
//                                .setFlightRange(5200)
//                                .setFuelConsumption(2480))
//                                .setCruisingSpeed(840))
//                        .setNumberOfPassengers(0)
//                        .build()
//        );
//
//        airline.addAircraft(
//                ((PassengerPlaneBuilder)
//                        ((AirplaneBuilder)
//                                passengerPlaneBuilder
//                                        .setModelName("Embraer E-190")
//                                        .setPassengerCapacity(114)
//                                        .setCarryingCapacity(51_800)
//                                        .setFlightRange(4537)
//                                        .setFuelConsumption(1850))
//                                .setCruisingSpeed(852))
//                        .setNumberOfPassengers(105)
//                        .build()
//        );
//
//        airline.addAircraft(
//                ((CargoPlaneBuilder)
//                        ((AirplaneBuilder) cargoPlaneBuilder
//                                .setModelName("Boeing 747-400F")
//                                .setCarryingCapacity(396_890)
//                                .setFlightRange(8230)
//                                .setFuelConsumption(1350))
//                                .setCruisingSpeed(980))
//                        .setCargoWeight(300_000)
//                        .build()
//        );
//
//        airline.addAircraft(
//                ((CargoPlaneBuilder)
//                        ((AirplaneBuilder)
//                                cargoPlaneBuilder
//                                        .setModelName("An-124-100")
//                                        .setCarryingCapacity(402_000)
//                                        .setFlightRange(15700)
//                                        .setFuelConsumption(12_600))
//                                .setCruisingSpeed(800))
//                        .setCargoWeight(20_000)
//                        .build()
//        );

        Menu.execute(airline);
    }
}
