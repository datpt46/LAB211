package main;

import bo.Calculate;
import java.util.Scanner;
import validation.Validate;

public class Model {

    private static final Scanner IN = new Scanner(System.in);
    static final Calculate CAL = new Calculate();
    static final validation.Validate CHECK = new Validate();

    public void runningCaculator() {
        System.out.println("======Caculator Program======");
        System.out.println("1. Normal Caculator");
        System.out.println("2. BMI Caculator");
        System.out.println("3. Exit");

        while (true) {
           int choose = CHECK.getInt("choose 1-3: ", 1, 3);

            switch (choose) {
                case 1:
                    CAL.caculate();
                    break;
                case 2:
                    CAL.caculateBMI();
                    break;
                case 3:
                    return;
            }
        }
    }
}
