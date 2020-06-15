/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Administrator
 */
public class Triangle extends Shape {
     private double sideA;
    private double sideB;
    private double sideC;

    public Triangle() {
    }

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }
      

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double getArea() {
        double p = getPerimeter()/2;
        return Math.sqrt(p *(p-sideA) *(p-sideB) * (p-sideC));
    }

    @Override
    public void printResult() {
        System.out.println("-------Triangle---------");
        System.out.println("Side A:" + sideA);
        System.out.println("Side B:" + sideB);
        System.out.println("Side C:" + sideC);
        System.out.println("Area:" + getArea());
        System.out.println("Perimeter:" + getPerimeter());
    }
}
