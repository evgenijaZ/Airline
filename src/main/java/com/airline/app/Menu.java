package com.airline.app;

import java.util.Scanner;

/**
 * @author Yevheniia Zubrych on 05.02.2018.
 */
class Menu {
    static void execute(Airline airline) {
        int swValue;
        System.out.println("=========================================================");
        System.out.println("|                         MENU                          |");
        System.out.println("=========================================================");
        System.out.println("| 1.Print the airline                                   |");
        System.out.println("| 2.Calculate total capacity, total carrying capacity   |");
        System.out.println("| 3.Display the list of aircraft sorted by flight range |");
        System.out.println("| 4.Find airplanes corresponding to                     |" +
                "\n|\t\t   a given range of fuel consumption parameters |");
        System.out.println("| 5.Exit                                                |");
        do {
            System.out.println("=========================================================");
            swValue = Menu.inInt("Select option: ");
            switch (swValue) {
                case 1:
                    airline.print();
                    break;
                case 2:
                    System.out.println("Total capacity is " + airline.getTotalCapacity());
                    System.out.println("Total carrying capacity is " + airline.getTotalCarryingCapacity() + "kg");
                    break;
                case 3:
                    System.out.println("Airplanes is sorted by flight range");
                    airline.sortAirplanesByFlightRange();
                    airline.print();
                    break;
                case 4:
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter lower bound:");
                    int min = scanner.nextInt();
                    System.out.println("Enter higher bound:");
                    int max = scanner.nextInt();
                    System.out.println("All airplanes corresponding to the specified range of fuel consumption parameters:");
                    airline.filterByFuelConsumption(min,max).forEach(airplane-> System.out.println(airplane.toString()));
                    break;
                case 5:
                    System.out.println("Exit selected");
                    break;
                default:
                    System.out.println("Invalid selection");
            }
        } while (swValue != 5);

    }

    private static void printPrompt(String prompt) {
        System.out.print(prompt);
        System.out.flush();
    }

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
