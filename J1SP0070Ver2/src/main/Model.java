/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bo.GetAccountInfo;
import java.util.Locale;


public class Model {
    
    /** 
     * Choose english or vietnamese language
     */
    public void runTPBank() {
        validation.Validate validate = new validation.Validate();
        
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("1. English");
            System.out.println("2. Vietnam");
            System.out.println("3. Exit");
            System.out.println("Please choose 1-3: ");
            int choose = validate.getInt(1, 3);

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
    
    
    /** 
     * ask user to input account info
     */
    public void display() {
        GetAccountInfo gainfo = new GetAccountInfo();
        gainfo.getAccount();
        gainfo.getPassword();
        gainfo.getCaptcha();
        gainfo.loginSuccess();

    }
    
}
