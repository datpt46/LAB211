package validation;

import entity.Worker;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author datpthe141311
 */
public class Validate {
    
    //check user input string
    public String getString() {
        Scanner in = new Scanner(System.in);
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

    public String getWorker(ArrayList<Worker> lw) {
        boolean flag = true;
        String id = getString();
        while (flag) {
            if (!isExistId(lw, id)) {
                flag = false;
            } else {
                System.out.println("id existed!. Re-enter: ");
                id = getString();
            }
        }
        return id;
    }

    public boolean isExistId(ArrayList<Worker> lw, String id) {
        for (Worker worker : lw) {
            if (id.equalsIgnoreCase(worker.getId())) {
                return true;
            }
        }
        return false;
    }

    public Worker getWorkerById(ArrayList<Worker> lw, String code) {
        for (Worker worker : lw) {
            if (code.equalsIgnoreCase(worker.getId())) {
                return worker;
            }
        }
        return null;
    }

    public String getCurrentDate() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        return df.format(cal.getTime());
    }
}
