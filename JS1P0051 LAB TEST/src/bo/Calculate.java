/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.BMI;
import java.util.Scanner;
import validation.Validate;

/**
 *
 * @author Administrator
 */
public class Calculate implements CaculateBo {

    private static int memory = 0;
    private static final Scanner IN = new Scanner(System.in);
    static final validation.Validate CHECK = new Validate();
    

    @Override
    public void caculate() {
        System.out.println("----Normal Calculator----");
        int number;

        System.out.println("enter number: ");
        number = Integer.parseInt(IN.nextLine());

        memory += number;

        boolean flag = true;

        do {

            System.out.println("enter operator value");
            String op = CHECK.getperator();

            switch (op) {
                case "+":
                    System.out.println("enter number: ");
                    number = Integer.parseInt(IN.nextLine());
                    memory += number;
                    System.out.println("memory = " + memory);
                    break;
                case "-":
                    System.out.println("enter number: ");
                    number = Integer.parseInt(IN.nextLine());
                    memory -= number;
                    System.out.println("memory = " + memory);
                    break;
                case "*":
                    System.out.println("enter number: ");
                    number = Integer.parseInt(IN.nextLine());
                    memory *= number;
                    System.out.println("memory = " + memory);
                    break;
                case "/":
                    try {
                        System.out.println("enter number: ");
                        number = Integer.parseInt(IN.nextLine());
                        memory /= number;
                        System.out.println("memory = " + memory);
                        break;
                    } catch (ArithmeticException ae) {
                        System.out.println(ae.getMessage());
                        break;
                    }
                case "^":
                    System.out.println("enter number: ");
                    number = Integer.parseInt(IN.nextLine());
                    memory = (int) Math.pow(memory, number);
                    System.out.println("memory = " + memory);
                    break;
                case "=":
                    System.out.println("Result = " + memory);
                    flag = false;
                    break;
            }
        } while (flag);

    }
    

    @Override
    public void caculateBMI() {
//        System.out.println("Enter weight(kg): ");
//        double weight = IN.nextDouble();
//        System.out.println("Enter height(cm): ");
//        double height = IN.nextDouble();
        
        double weight = CHECK.getDouble("enter weight: ", 0, Double.MAX_VALUE);
        double height = CHECK.getDouble("enter height: ", 0, Double.MAX_VALUE);

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
//    enum Operator {
//        ADD("+"),
//        SUB("-"),
//        MUL("*"),
//        DIV("/"),
//        EXP("^"),
//        EQUAL("=");
//
//        String op;
//
//        private Operator(String op) {
//            this.op = op;
//        }
//
//        public String getOp() {
//            return op;
//        }
//
//        public void setOp(String op) {
//            this.op = op;
//        }
//
//    }
    

}
