package bo;

import java.util.Scanner;
import validation.Validate;

/**
 *
 * @author datpthe141311
 */
public class Calculate {

    static double memory = 0;
    static validation.Validate check = new Validate();
    
    public void caculate() {
        System.out.println("----Normal Calculator----");
        memory = check.getDouble("enter number: ", Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        double secondNumber;

        while (true) {
            System.out.println("enter operator: +, - ,*, /, ^, =");
            String op = check.getperator();

            if (op.equals("=")) {
                System.out.println("Result: " + memory);
                return;
            }

            secondNumber = getSecondNumber(op);

            if (op.equals("+")) {
                memory += secondNumber;
                System.out.println("Result: " + memory);
            } else if (op.equals("-")) {
                memory -= secondNumber;
                System.out.println("Result: " + memory);
            } else if (op.equals("*")) {
                memory *= secondNumber;
                System.out.println("Result: " + memory);
            } else if (op.equals("/")) {
                memory /= secondNumber;
                System.out.println("Result: " + memory);
            } else if (op.equals("^")){
                memory = Math.pow(memory, secondNumber);
                System.out.println("Result: " + memory);
            }

        }

    }
    
    public double getSecondNumber(String op) {
        double secondNumber = 0;
        do {
            secondNumber = check.getDouble("enter number: ", Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
            if (secondNumber == 0 && op.equals("/")) {
                System.out.println("cannot divide by 0");
            }
        } while (secondNumber == 0 && op.equals("/"));

        return secondNumber;
    }
    
    public void caculateBMI() {
        double weight = check.getDouble("enter weight: ", 0, Double.POSITIVE_INFINITY);
        double height = check.getDouble("enter height: ", 0, Double.POSITIVE_INFINITY);

        height /= 100;

        double BMI = weight / (height * height);
        System.out.println("BMI number: " + BMI);
        if (BMI < 19) {
            System.out.println("UNDER-STANDARD");
        } else if (BMI >= 19 && BMI < 25) {
            System.out.println("STANDARD");
        } else if (BMI >= 25 && BMI < 30) {
            System.out.println("OVERWEIGHT");
        } else if (BMI >= 30 && BMI < 40) {
            System.out.println("FAT");
        } else {
            System.out.println("VERY FAT");
        }
    }

}
