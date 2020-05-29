/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import validation.Validate;

/**
 *
 * @author Administrator
 */
public class GenerateCaptcha {

    private static final String ALPHA = "abcdefghiklmnopqrstuvwxyz".toUpperCase();
    private static final String DIGITS = "0123456789";
    private static final String ALPHA_NUMERIC = ALPHA + DIGITS;
    
    //generate random number, list to store captcha, check function include String, integer,..
    private static final Random RD = new Random();
    private static final List<String> CAPTCHA = new ArrayList();
    private static final validation.Validate CHECK = new Validate();
    
    public static List<String> generateListCaptcha() {
        
//        int times = CHECK.getInt("enter number of captcha"
//                + " to generate", 1, Integer.MAX_VALUE);
        int times = 1;
        while (times > 0) {
            String captcha1 = generateCaptcha(8);
            System.out.println("captcha: " + captcha1);
            CAPTCHA.add(captcha1);
            times--;
        }
        return CAPTCHA;
    }
    
    public static String generateCaptcha(int numberOfCharacters) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<numberOfCharacters; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length()-1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }
        
        return sb.toString();

    }

    public static int randomNumber(int min, int max) {
        return RD.nextInt(max - min + 1) + min;
    }

}
