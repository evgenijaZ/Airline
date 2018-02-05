package com.airline.app;

import java.util.Scanner;

/**
 * @author Yevheniia Zubrych on 05.02.2018.
 */
class Menu {
    /**
     * The main menu method that executes is
     * @param airline the airline you need to work with
     */
    static void execute(Airline airline) {
        int selectedOption;
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========================================================");
        System.out.println("|                         MENU                          |");
        System.out.println("=========================================================");
        System.out.println("| 1.Print the airline                                   |");
        System.out.println("| 2.Calculate total capacity, total carrying capacity   |");
        System.out.println("| 3.Display the list of aircraft sorted by flight range |");
        System.out.println("| 4.Find airplanes corresponding to                     |" +
                "\n|\t\t   a given range of fuel consumption parameters |");
        System.out.println("| 5.Go up an airplane                                   |");
        System.out.println("| 6.Go down an airplane                                 |");
        System.out.println("| 7.Exit                                                |");
        do {
            System.out.println("=========================================================");
            selectedOption = Menu.inInt("Select option: ");
            switch (selectedOption) {
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
                    int min, max;
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
                        System.out.println("All airplanes corresponding to the specified range of fuel consumption parameters:");
                        airline.filterByFuelConsumption(min, max).forEach(airplane -> System.out.println(airplane.toString()));
                    } else {
                        scanner.next();
                        System.out.println("Value should be an integer. Try again");
                    }
                    scanner.close();
                    break;
                case 5:
                    System.out.println("Enter index of plane:");
                    int index_up;
                    scanner = new Scanner(System.in);
                    if (scanner.hasNextInt()) {
                        index_up = scanner.nextInt();
                        try {
                            airline.getAirplane(index_up).goUp();
                        } catch (NullPointerException e) {
                            System.out.println("Invalid index. Null pointer exception. Try again");
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
                            airline.getAirplane(index_down).goDown();
                        } catch (NullPointerException e) {
                            System.out.println("Invalid index. Null pointer exception. Try again");
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
     * @param prompt the prompt value
     */
    private static void printPrompt(String prompt) {
        System.out.print(prompt);
        System.out.flush();
    }

    /**
     * Convert input data to int
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
