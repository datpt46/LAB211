/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import entity.Candidate;
import java.util.ArrayList;
import java.util.Calendar;
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
    private static final String PHONE_REGEX = "\\d{10,11}";
    private static final String EMAIL_REGEX = "[A-Za-z]+[\\w\\d]*@[\\w]+(\\.[A-Za-z]+){1,3}";
    
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
            String result = SC.nextLine().trim();
            if (!result.isEmpty()) {
                return result;
            } else {
                System.out.println("cannot empty, enter again: ");
            }
        }
    }
    
    public boolean chooseYN() {
        while(true) {
            String input = getString().toLowerCase().substring(0, 1);
            
            switch(input) {
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    System.out.println("Y/N only. enter again: ");
            }
        }
    }
    
    public String getPhoneNumber() {
        while(true) {
            String input = getString();
            if(input.matches(PHONE_REGEX)) {
                return input;
            } else {
                System.out.println("phone number is minimum 10 characters. Enter again: ");
            }           
        }
    }
    
    public String getEmail() {
        while(true) {
            String input = getString();
            if(input.matches(EMAIL_REGEX)) {
                return input;
            } else {
                System.out.println("email format <account name>@<domain>. Enter again: ");
            }
            
        }
    }
    
    public String getRankOfGraduation() {
        while(true) {
            String input = getString();
            
            switch(input) {
                case "Excellence":
                    return input;
                case "Good":
                    return input;
                case "Fair":
                    return input;
                case "Poor":
                    return input;
                default:
                    System.out.println("Excellence, Good, Fair, Poor only. Enter again: ");
            }
        }
    }
    
    public int getInputExperience(int birthDate) {
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int age = yearCurrent - birthDate;
        
        while(true) {
            int yearExperience = getInt("enter year of experience: ", 0, 100);
            if(yearExperience < age) {
                return yearExperience;
            } else {
                System.out.println("experience year must be smaller than age");
            }
        }
    }
    
    public boolean isCandidateId(ArrayList<Candidate> candidates, String id) {
        for(Candidate candidate : candidates) {
            if(id.equalsIgnoreCase(candidate.getId())) {
                System.out.println("id found!");
                return true;
            }
        }
        return false;
    }
    
}
