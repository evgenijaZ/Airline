package com.airline.app;

import com.airline.app.aircrafts.CargoPlane;
import com.airline.app.aircrafts.PassengerPlane;

/**
 * Main class of the airline application
 *
 * @author Yevheniia Zubrych on 03.02.2018.
 */
public class App {
    public static void main(String[] args){

        Airline airline = new Airline("UkraineAir");
        airline.addAirplane(new PassengerPlane("Boeing 737-300", 128, 69400, 6230, 2400, 790, 100));
        airline.addAirplane(new PassengerPlane("Boeing 737-800", 103, 52400, 5200, 2480, 840));
        airline.addAirplane(new PassengerPlane("Embraer E-190", 114, 51800, 4537, 1850, 852, 105));
        airline.addAirplane(new CargoPlane("Boeing 747-400F", 396890, 8230, 1350, 980, 300000));
        airline.addAirplane(new CargoPlane("An-124-100", 402000, 15700, 12600, 800, 20000));
        airline.sortAirplanesByFlightRange();

        Menu.execute(airline);
    }
}
