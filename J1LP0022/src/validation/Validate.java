package validation;

import entity.Candidate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Validate {

    static Scanner in = new Scanner(System.in);

    public String getString() {
        while (true) {
            String res = in.nextLine().trim();

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
            if (isCandidateId(candidates, id) == -1) {
                return id;
            } else {
                System.out.println("id existed!");
            }
        }
    }

    public String getphoneNumber(ArrayList<Candidate> candidates) {
        while (true) {
            String phoneNumber = getString();

            if (phoneNumber.matches("^\\d{10,11}$")) {
                return phoneNumber;
            } else {
                System.out.println("phone number minimum 10 numbers");
            }
        }

    }

    public String getEmail(ArrayList<Candidate> candidates) {
        while (true) {
            String email = getString();
            if (email.matches("^[a-zA-Z]+[a-zA-Z0-9]*@[a-zA-Z]+(\\.[A-Za-z0-9]+){1,3}$")) {
                return email;
            } else {
                System.out.println("format <account name>@<domain>.");
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

    public int isCandidateId(ArrayList<Candidate> candidates, String id) {
        for (int i = 0; i < candidates.size(); i++) {
            if (id.equalsIgnoreCase(candidates.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }
}
