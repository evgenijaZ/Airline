package com.airline.app;

/**
 * @author Yevheniia Zubrych on 05.02.2018.
 */
public class Menu {

    private static void printPrompt(String prompt) {
        System.out.print(prompt);
        System.out.flush();
    }

    public static int inInt(String prompt) {
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
