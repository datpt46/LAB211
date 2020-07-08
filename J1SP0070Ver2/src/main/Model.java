/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entity.Language;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Model {
    
    
    public void runTPBank() {
        boolean isRunning = true;
        while (isRunning) {
            Scanner sc = new Scanner(System.in);
            System.out.println("1. English");
            System.out.println("2. Vietnam");
            System.out.println("3. Exit");
            int choose = sc.nextInt();

            switch (choose) {
                case 1:
                    Locale.setDefault(new Locale("en", "US"));
                    display();
                    break;
                case 2:
                    Locale.setDefault(new Locale("vi", "VN"));
                    display();
                    break;
                case 3:
                    isRunning = false;
                    break;
            }
        }
    }

    public void display() {
        Language language = new Language();
        System.out.println(language.account);
        System.out.println(language.accountInvalid);
        System.out.println(language.password);
        System.out.println(language.passInvalid);
        System.out.println(language.captcha);
        System.out.println(language.accountInvalid);
        System.out.println(language.login);
        System.out.println(language.loginFail);
    }
}
