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

    static final Scanner IN = new Scanner(System.in);
    static final ValidateBoolean VB = new ValidateBoolean();

    public String getString() {
        while (true) {
            String res = IN.nextLine().trim();

            if (!res.isEmpty()) {
                return res;
            } else {
                System.out.println("you cannot enter empty!");
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

    public boolean chooseYN() {
        while (true) {
            String choose = getString().toLowerCase().substring(0, 1);

            switch (choose) {
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    System.out.println("enter Y/N only!");
            }
        }
    }

    public String getId(ArrayList<Candidate> candidates) {

        while (true) {
            System.out.println("enter id: ");
            String id = getString();
            if (!VB.isCandidateId(candidates, id)) {
                return id;
            } else {
                System.out.println("id existed!");
            }
        }
    }

    public String getphoneNumber(ArrayList<Candidate> candidates) {

        while (true) {
            String phoneNumber = getString();

            if (!VB.isCandidatePhone(candidates, phoneNumber)) {
                if (phoneNumber.matches("^\\d{10}$")) {
                    return phoneNumber;
                } else {
                    System.out.println("phone number minimum 10 numbers");
                }
            } else {
                System.out.println("phone number existed!");
            }

        }
    }

    public String getEmail(ArrayList<Candidate> candidates) {

        while (true) {
            String email = getString();
            if (!VB.isCandidateEmail(candidates, email)) {
                if (email.matches("^[A-Za-z]+[\\w]*@[\\w]+(\\.[A-Za-z]+){1,3}$")) {
                    return email;
                } else {
                    System.out.println("format <account name>@<domain>.");
                }
            } else {
                System.out.println("email existed!");
            }

        }
    }

    public int getYearOfExperience(int birthDate) {
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int age = yearCurrent - birthDate;

        while (true) {
            int yearExperience = getInt("enter year of experience", 0, 100);
            if (yearExperience > age) {
                System.out.println("year of experience must be smaller than age");
            } else {
                return yearExperience;
            }
        }
    }

    public String getRankOfGraduation() {
         while (true) {
             String rank = getString().toLowerCase();

            switch (rank) {
                case "excellence":
                case "good":
                case "fair":
                case "poor":
                    return rank;
                default:
                    System.out.println("excellence, good, fair or poor only!");
        }
    }

}
}
