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
    static Scanner in = new Scanner(System.in);
    //check user input string
    public String getString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
    
    public int getInt(String message, int min, int max) {
        boolean flag = true;
        int number = 0;

        while (flag) {
            System.out.println(message);
            try {
                number = Integer.parseInt(getString());
                if (number >= min && number <= max) {
                    flag = false;
                } else {
                    System.out.println("number out of range!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Number invalid!");
            }
        }

        return number;
    }
    
    public double getDouble(String message, double min, double max) {
        boolean flag = true;
        double number = 0;

        while (flag) {
            System.out.println(message);
            try {
                number = Double.parseDouble(getString());
                if (number >= min && number <= max) {
                    flag = false;
                } else {
                    System.out.println("number out of range!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Number invalid!");
            }
        }

        return number;
    }

    public String getperator() {

        while (true) {
            String operator = in.nextLine();
            if (operator.isEmpty()) {
                System.out.println("cannot empty");
            } else {
                switch (operator) {
                    case "+":
                        return operator;
                    case "-":
                        return operator;
                    case "*":
                        return operator;
                    case "/":
                        return operator;
                    case "^":
                        return operator;
                    case "=":
                        return operator;
                    default:
                        System.out.println("Please input (+, -, *, /, ^)");
                }
            }
        }

    }

}
