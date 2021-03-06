package com.airline.app.services;

import com.airline.app.entities.Airline;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

/**
 * @author Yevheniia Zubrych on 05.02.2018.
 */
public class Menu {
    @Autowired
    private static AirlineUtilService airlineUtilService;
    /**
     * The main menu method that executes it
     *
     * @param airline the airline you need to work with
     */
   public static void execute(Airline airline) {
        int selectedOption;
        Scanner scanner = new Scanner(System.in);
        System.out.println("===============================================================================");
        System.out.println("|                         MENU                                                 |");
        System.out.println("===============================================================================");
        System.out.println("| 1.Print the airline                                                          |");
        System.out.println("| 2.Calculate total capacity, total carrying capacity                          |");
        System.out.println("| 3.Display the list of aircraftList sorted by flight range                        |");
        System.out.println("| 4.Find airplanes corresponding to range of fuel consumption parameters       |");
        System.out.println("| 5.Go up an airplane                                                          |");
        System.out.println("| 6.Go down an airplane                                                        |");
        System.out.println("| 7.Exit                                                                       |");
        do {
            System.out.println("===============================================================================");
            selectedOption = Menu.inInt("Select option: ");
            switch (selectedOption) {
                case 1:
                    airline.print();
                    break;
                case 2:
                    System.out.println("Total capacity is " + airlineUtilService.getTotalPassengerCapacity(airline));
                    System.out.println("Total carrying capacity is " +  airlineUtilService.getTotalCarryingCapacity(airline)+ "kg");
                    break;
                case 3:
                    System.out.println("Airplanes is sorted by flight range");
                    airlineUtilService.getSortedByFlightRangeAircraftList(airline);
                    airline.print();
                    break;
                case 4:
                    int min, max = 0;
                    System.out.println("Enter lower bound:");
                    if (scanner.hasNextInt())
                        min = scanner.nextInt();
                    else {
                        scanner.next();
                        System.out.println("Value should be an integer. Try again");
                        continue;
                    }
                    System.out.println("Enter higher bound:");
                    if (scanner.hasNextInt()) {
                        max = scanner.nextInt();
                    } else {
                        scanner.next();
                        System.out.println("Value should be an integer. Try again");
                    }
                    System.out.println("All airplanes corresponding to the specified range of fuel consumption parameters:");
                    airlineUtilService.getFilteredByFuelConsumptionAircraftList(airline, min, max).forEach(airplane -> System.out.println(airplane.toString()));
                    break;
                case 5:
                    System.out.println("Enter index of plane:");
                    int index_up;
                    scanner = new Scanner(System.in);
                    if (scanner.hasNextInt()) {
                        index_up = scanner.nextInt();
                        try {
                            airline.getAircraft(index_up).goUp();
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println(e.toString()+ ". Try again");
                        } catch (NullPointerException e) {
                            System.out.println("Null pointer exception. Try again");
                        }
                    } else {
                        scanner.next();
                        System.out.println("Value should be an integer. Try again");
                    }
                    break;
                case 6:
                    System.out.println("Enter index of plane:");
                    int index_down;
                    scanner = new Scanner(System.in);
                    if (scanner.hasNextInt()) {
                        index_down = scanner.nextInt();
                        try {
                            airline.getAircraft(index_down).goDown();
                        } catch (NullPointerException e) {
                            System.out.println("Invalid index. Null pointer exception. Try again");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        scanner.next();
                        System.out.println("Value should be an integer. Try again");
                    }
                    break;
                case 7:
                    System.out.println("Exit selected");
                    break;
                default:
                    System.out.println("Invalid selection");
            }
        } while (selectedOption != 7);
    }

    /**
     * Display a prompt for option selection
     *
     * @param prompt the prompt value
     */
    private static void printPrompt(String prompt) {
        System.out.print(prompt);
        System.out.flush();
    }

    /**
     * Convert input data to int
     *
     * @param prompt prompt for option selection
     * @return value as an integer
     */
    private static int inInt(String prompt) {
        while (true) {
            printPrompt(prompt);
            try {
                return Integer.valueOf(inString().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Not an integer");
            }
        }
    }

    /**
     * Present input data as String
     *
     * @return data as String
     */
    private static String inString() {
        int aChar;
        StringBuilder resultString = new StringBuilder();
        boolean isFinished = false;

        while (!isFinished) {
            try {
                aChar = System.in.read();
                if (aChar < 0 || (char) aChar == '\n')
                    isFinished = true;
                else if ((char) aChar != '\r')
                    resultString.append((char) aChar);
            } catch (java.io.IOException e) {
                System.out.println("Input error");
                isFinished = true;
            }
        }
        return resultString.toString();
    }
}
