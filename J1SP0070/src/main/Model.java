/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bo.Login;
import java.util.ArrayList;
import java.util.List;
import validation.Validate;

/**
 *
 * @author Administrator
 */
public class Model {
    
    private static final List<String> LIST_CAPTCHA = new ArrayList();
    
    private static final validation.Validate CHECK = new Validate();
    private static final Login LOGIN_FUNCTION = new Login();
    
    public void chooseLanguage() {
        while(true) {
            LOGIN_FUNCTION.menuLanguage();
            int choose = CHECK.getInt("enter 1-3: ", 1, 3);
            
            switch(choose) {
                case 1:
                    break;
                case 2:
                    runTPBank();
                    break;
                case 3:
                    return;
            }
        }
    }
    
    public void runTPBank() {
        while(true) {
            LOGIN_FUNCTION.menuTPBank();
            int choose = CHECK.getInt("enter 1-5: ", 1, 5);
            
            switch(choose) {
                case 1:
                    String accountNumber = CHECK.getString();
                    String messageAccount = LOGIN_FUNCTION.checkAccountNumber(accountNumber);
                    System.out.println(messageAccount);
                    break;
                case 2:
                    String passWord = CHECK.getString();
                    String messagePassWord = LOGIN_FUNCTION.checkPassword(passWord);
                    System.out.println(messagePassWord);
                    break;
                case 3:
                    LIST_CAPTCHA.clear();
                    String captchaValue = LOGIN_FUNCTION.generateCaptcha();
                    LIST_CAPTCHA.add(captchaValue);
                    System.out.println("captcha: " + captchaValue);
                    break;
                case 4:
                    String inputCaptcha = CHECK.getString();
                    boolean result = LOGIN_FUNCTION.isCorrectCaptcha(LIST_CAPTCHA, inputCaptcha);
                    System.out.println((result) ? "correct" : "incorrect");                    
                    break;
                case 5:
                    return;
            }
        }
    }
    
}
