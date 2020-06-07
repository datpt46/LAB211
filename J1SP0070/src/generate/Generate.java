/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generate;

import java.util.Random;

/**
 *
 * @author Administrator
 */
public class Generate {

    static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
    static final String ALPHA_UPPERCASE = ALPHA.toUpperCase();
    static final String DIGITS = "0123456789";
    static final String ALPHA_NUMERIC = ALPHA + ALPHA_UPPERCASE + DIGITS;
    static final Random RD = new Random();

    public int randomRange(int min, int max) {
        return RD.nextInt(max - min + 1) + min;
    }

    public String generateCaptcha() {
        String res = "";
        for (int i = 0; i < 5; i++) {
            res += ALPHA_NUMERIC.charAt(randomRange(0, ALPHA_NUMERIC.length() - 1));
        }

        return res;
    }
}
