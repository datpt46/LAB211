/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bo.Manage;
import entity.Candidate;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Model {
    static final validation.Validate CHECK = new validation.Validate();
    static final Manage MANAGE = new Manage();
    static final ArrayList<Candidate> CANDIDATE = new ArrayList<>();

    public void menu() {
        while (true) {
            MANAGE.menu();
            int choose = CHECK.getInt("enter 1-5: ", 1, 5);
            switch (choose) {
                case 1:
                    MANAGE.add(CANDIDATE, 0);
                    break;
                case 2:
                    MANAGE.add(CANDIDATE, 1);
                    break;
                case 3:
                    MANAGE.add(CANDIDATE, 2);
                    break;
                case 4:
                    MANAGE.search(CANDIDATE);
                    break;
                case 5:
                    return;
            }
        }
    }
}
