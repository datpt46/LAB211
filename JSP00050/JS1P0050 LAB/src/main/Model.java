/*
    purpose: create menu for caculate equation 
 */
package main;

import caculateequation.Caculate;
import java.util.ArrayList;
import validation.Validate;

/**
 *
 * @author Dat
 */
public class Model {
    static final Caculate CAL = new Caculate();
    static final validation.Validate CHECK = new Validate();
    static final ArrayList<Float> LIST_FLOAT = new ArrayList<>();

    void equationProgramMenu() {
        System.out.println("==========Equation Program========\n"
                + "1. Caculate Superlative Equation\n"
                + "2. Caculate Quadratic Equation\n"
                + "3. Exit.\n");
        
        int choose;
        
        do {
            choose = CHECK.getInt("please enter 1-3: ", 1, 3);
            switch(choose) {
                case 1:
                    CAL.outputEquation(LIST_FLOAT);
                    LIST_FLOAT.clear();
                    break;
                case 2:
                    CAL.outputQuadratic(LIST_FLOAT);
                    LIST_FLOAT.clear();
                    break;
                case 3:
                    return;
            }
        } while(choose != 3);
        
    }

}
