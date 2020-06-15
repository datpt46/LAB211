/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Validate {
    private static final String REGEX_INT = "-?\\d+";
    private static final String REGEX_DECIMAL = "-?\\d+\\.\\d+";
    private static final String REGEX_DOUBLE = REGEX_INT + "|" + REGEX_DECIMAL;

    public int getInt(String message, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        int number = 0;

        while (flag) {
            System.out.println(message);
            String strInput = scanner.nextLine().trim();

            if (strInput.isEmpty()) {
                System.out.println("You cannot enter an empty value!");
            } else {
                if (strInput.matches(REGEX_INT)) {
                    number = Integer.valueOf(strInput);
                    if (number >= min && number <= max) {
                        flag = false;
                    } else {
                        System.out.println("Number out of range.");
                    }

                } else {
                    System.out.println("Number invalid!");
                }
            }
        }
        return number;
    }
   

    public double getDouble(String message, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        double number = 0;

        while (flag) {
            System.out.println(message);
            String strInput = scanner.nextLine().trim();

            if (strInput.isEmpty()) {
                System.out.println("You cannot enter an empty value!");
            } else {
                if (strInput.matches(REGEX_DOUBLE)) {
                    number = Double.valueOf(strInput);
                    if (number >= min && number <= max) {
                        flag = false;
                    } else {
                        System.out.println("Number out of range.");
                    }

                } else {
                    System.out.println("Number invalid!");
                }
            }

        }
        return number;
    }
}
