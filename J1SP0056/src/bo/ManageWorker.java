/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.SalaryHistory;
import entity.Worker;
import java.util.ArrayList;
import java.util.Collections;
import validation.Validate;

/**
 *
 * @author Administrator
 */
public class ManageWorker implements ManageWorkerInterface {

    private static final validation.Validate CHECK = new Validate();

    //function 0
    public void menu() {
        System.out.println("======Worker Management======");
        System.out.println("1. Add worker");
        System.out.println("2. Up Salary");
        System.out.println("3. Down Salary");
        System.out.println("4. Display Information Salary");
        System.out.println("5. Exit");
    }

    //function 1
    @Override
    public void addWorker(ArrayList<Worker> lw, ArrayList<SalaryHistory> lh) {
        System.out.println("enter id: ");
        String id = CHECK.getWorker(lw);
        System.out.println("enter name: ");
        String name = CHECK.getString();
        int age = CHECK.getInt("enter age: ", 18, 50);
        double salary = CHECK.getDouble("enter salary: ", 0, Double.MAX_VALUE);
        System.out.println("enter worker location");
        String workerLocation = CHECK.getString();
        lw.add(new Worker(id, name, age, salary, workerLocation));
        lh.add(new SalaryHistory("ORIGIN", CHECK.getCurrentDate(), id, name, age, salary, workerLocation));
        
        
    }

    //function 2,3
    @Override
    public void changeSalary(ArrayList<Worker> lw, ArrayList<SalaryHistory> lh, int mode) {
        //print list worker
        getInformationSalary(lh);
        
        //find worker to change salary
        System.out.println("enter id(code): ");
        String code = CHECK.getString();
        Worker worker = CHECK.getWorkerById(lw, code);

        if (worker != null) {
            double currentSalary = worker.getSalary();
            double salaryUpdate;
            switch (mode) {
                case 1:
                    int salaryIncrease = CHECK.getInt("enter ammount to increase", 0, Integer.MAX_VALUE);
                    salaryUpdate = currentSalary + salaryIncrease;
                    lh.add(new SalaryHistory("UP", CHECK.getCurrentDate(),
                            worker.getId(), worker.getName(), worker.getAge(), salaryUpdate, worker.getWorkLocation()));
                    System.out.println("Updated!");
                    getInformationSalary(lh);
                    break;
                case 2:
                    int salaryDecrease = CHECK.getInt("enter ammount to decrease", 0, Integer.MAX_VALUE);
                    salaryUpdate = currentSalary - salaryDecrease;
                    lh.add(new SalaryHistory("DOWN", CHECK.getCurrentDate(),
                            worker.getId(), worker.getName(), worker.getAge(), salaryUpdate, worker.getWorkLocation()));
                    System.out.println("Updated!");
                    getInformationSalary(lh);
                    break;
            }
        } else {
            System.out.println("worker not exist!");
        }

    }

    //function 4
    @Override
    public void getInformationSalary(ArrayList<SalaryHistory> lh) {
        if (lh.isEmpty()) {
            System.out.println("nothing to show. list empty!");
            return;
        }

        System.out.printf("%5s %15s %15s %15s %15s %15s\n", "Code", "Name",
                "Age", "Salary", "Status", "Date");

        Collections.sort(lh);

        for (SalaryHistory sh : lh) {
            System.out.printf("%5s %15s %15s %15s %15s %15s\n", sh.getId(), sh.getName(),
                    sh.getAge(), sh.getSalary(), sh.getStatus(), sh.getDate());
        }
    }
}
