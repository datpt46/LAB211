/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bo.ManageWorker;
import entity.SalaryHistory;
import entity.Worker;
import java.util.ArrayList;
import validation.Validate;

/**
 *
 * @author Administrator
 */
public class main {

    private static final validation.Validate CHECK = new Validate();
    private static final ManageWorker MANAGE = new ManageWorker();
    private static final ArrayList<Worker> LW = new ArrayList<Worker>();
    private static final ArrayList<SalaryHistory> LSH = new ArrayList<SalaryHistory>();

    public static void main(String[] args) {

        while (true) {
            MANAGE.menu();
            int choose = CHECK.getInt("please enter 1-5: ", 1, 5);
            switch (choose) {
                case 1:
                    MANAGE.addWorker(LW);
                    break;
                case 2:
                    MANAGE.changeSalary(LW, LSH, 1);
                    break;
                case 3:
                    MANAGE.changeSalary(LW, LSH, 2);
                    break;
                case 4:
                    MANAGE.getInformationSalary(LSH);
                    break;
                case 5:
                    return;
            }
        }

    }
}
