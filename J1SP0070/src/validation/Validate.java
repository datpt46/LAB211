/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Validate {

    private static final String REGEX_INT = "-?\\d+";
    private static final String REGEX_DECIMAL = "-?\\d+\\.\\d+";
    private static final String REGEX_DOUBLE = REGEX_INT + "|" + REGEX_DECIMAL;
    private static final Scanner SC = new Scanner(System.in);

    public int getInt(String message, int min, int max) {
        boolean flag = true;
        int number = 0;

        while (flag) {
            System.out.println(message);
            String strInput = SC.nextLine().trim();

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
        boolean flag = true;
        double number = 0;

        while (flag) {
            System.out.println(message);
            String strInput = SC.nextLine().trim();

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

    public String getString() {
        while (true) {
            System.out.println("enter a string: ");
            String result = SC.nextLine().trim();
            if (!result.isEmpty()) {
                return result;
            } else {
                System.out.println("cannot empty, enter again: ");
            }
        }
    }

    // purpose: check 10 digits account number
    public long getAccountNumber() {
        boolean flag = true;
        long number = 0;

        while (flag) {
            System.out.println("enter account number: must be 10 digits");
            String accountStr = getString();

            if (accountStr.matches("\\d{10}")) {
                number = Integer.valueOf(accountStr);
                flag = false;
            } else {
                System.out.println("Number invalid!");
            }
        }
        return number;
    }

    public String getPassword() {

        String password = "";
        boolean flag = true;

        while (flag) {
            System.out.println("enter password: ");
            password = getString();

            if (password.matches("[a-zA-Z0-9]{8,31}")) {
                flag = false;
            } else {
                System.out.println("password must in range 8-31"
                        + " and contain only number and alphabet character");
            }
        }

        return password;
    }
    
    public boolean isCaptcha(List<String> captcha, String inputCaptcha) {
        boolean flag = false;
        for(String cap : captcha) {
            if(cap.equals(inputCaptcha)) {
                flag = true;
            }
        }
        return flag;
    }

}
