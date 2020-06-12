/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class getInput {

    static final Scanner IN = new Scanner(System.in);
    static final String REGEX_PLAN = "^\\d{1,2}\\.5|\\d{1,2}\\.0$";

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

    public double getDouble(String message, int min, int max) {
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

    public String getTaskNameById(String message) {
        while (true) {
            System.out.println(message);
            int taskTdType = getInt("enter task type 1-4: ", 1, 4);
            switch (taskTdType) {
                case 1:
                    return "Code";
                case 2:
                    return "Test";
                case 3:
                    return "Design";
                case 4:
                    return "Review";
            }
        }
    }

    public String getDate(String message) {
        while (true) {
            try {
                System.out.println(message);
                String dateInput = getString();

                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy");
                Date date = format.parse(dateInput);

                if (dateInput.equalsIgnoreCase(format.format(date))) {
                    return dateInput;
                } else {
                    System.out.println("enter again: ");
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    }

    public double getPlaneTime(String message) {
        boolean planRange = Double.parseDouble(REGEX_PLAN) >= 8 && Double.parseDouble(REGEX_PLAN) <= 17.5;
        while (true) {
            System.out.println(message);
            String plan = getString();

            if (plan.matches(REGEX_PLAN) && planRange) {
                return Double.parseDouble(plan);
            } else {
                System.out.println("please input again: ");
            }
        }
    }

    public double getPlanFromPlanTo(String message, int mode) {

        while (true) {
            double planFrom = getPlaneTime("enter plan from: ");
            double planTo = getPlaneTime("enter plan to: ");

            while (planFrom >= planTo) {
                System.out.println("planFrom cannot be higher or equal plan to!");
                planFrom = getPlaneTime("enter plan from: ");
                planTo = getPlaneTime("enter plan to: ");
            }

            switch (mode) {
                case 1:
                    return planFrom;
                case 2:
                    return planTo;
            }
        }
    }
}
