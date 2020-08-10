package main;

import bo.Calculate;
import java.util.Scanner;
import validation.Validate;

public class Model {

    public void runningCaculator() {
        Calculate cal = new Calculate();
        validation.Validate check = new Validate();
        System.out.println("======Caculator Program======");
        System.out.println("1. Normal Caculator");
        System.out.println("2. BMI Caculator");
        System.out.println("3. Exit");

        while (true) {
            int choose = check.getInt("choose 1-3: ", 1, 3);

            switch (choose) {
                case 1:
                    cal.caculate();
                    break;
                case 2:
                    cal.caculateBMI();
                    break;
                case 3:
                    return;
            }
        }
    }
}
