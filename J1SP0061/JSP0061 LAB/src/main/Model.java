/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entity.Circle;
import entity.Rectangle;
import entity.Shape;
import entity.Triangle;
import java.util.Scanner;
import validation.Validate;

/**
 *
 * @author Administrator
 */
public class Model {
    final Scanner scanner = new Scanner(System.in);
    static final validation.Validate CHECK = new Validate();
    
    public Rectangle inputRectangle(){
        double w = CHECK.getDouble("Please input width of Rectangle:", 0, Double.MAX_VALUE);
        double l = CHECK.getDouble("Please input length A of Rectangle:", 0, Double.MAX_VALUE);
        return new Rectangle(w,l);
    }
    
    public Circle inputCircle() {
        double r = CHECK.getDouble("Please input radius of Circle:", 0, Double.MAX_VALUE);
        return new Circle(r);
    }
    
    public Triangle inputTriangle() {
        double s1, s2, s3;
        
        do {
            s1 = CHECK.getDouble("Please input side A of Triangle:", 0, Double.MAX_VALUE);
            s2 = CHECK.getDouble("Please input side B of Triangle:", 0, Double.MAX_VALUE);
            s3 = CHECK.getDouble("Please input side C of Triangle:", 0, Double.MAX_VALUE);
        } while (!((s1 + s2 > s3) && (s2 + s3 > s1) && (s1 + s3 > s2)));
        
        return new Triangle(s1, s2, s3);
    }
    
    public void caculator() {
        System.out.println("==========Caculator Shape Program=========");
        Shape rec = inputRectangle();
        Shape tri = inputTriangle();
        Shape ci = inputCircle();
        
        System.out.println("------------------------------------------");
        rec.printResult();
        tri.printResult();
        ci.printResult();
    }
}
