/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bo.ManageCandidate;
import entity.Candidate;
import java.util.ArrayList;
import validation.Validate;

/**
 *
 * @author Administrator
 */
public class Main {
    
    static final ArrayList<Candidate> CANDIDATES = new ArrayList<Candidate>();
    static final validation.Validate CHECK = new Validate();
    static final ManageCandidate MANAGE = new ManageCandidate();
    
    public static void main(String[] args) {
        while(true) {
            MANAGE.menu();
            int choose = CHECK.getInt("choose 1-5 ", 1, 5);
            
            switch(choose) {
                case 1:
                    MANAGE.createCandidate(CANDIDATES, 0);
                    break;
                case 2:
                    MANAGE.createCandidate(CANDIDATES, 1);
                    break;
                case 3:
                    MANAGE.createCandidate(CANDIDATES, 2);
                    break;
                case 4:
                    MANAGE.searchCandidate(CANDIDATES);
                    break;
                case 5:
                    return;
            }
        }
    }
            
}
