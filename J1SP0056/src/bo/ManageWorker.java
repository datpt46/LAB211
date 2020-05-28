/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.SalaryHistory;
import entity.Worker;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import validation.Validate;

/**
 *
 * @author Administrator
 */
public class ManageWorker {

    private static final validation.Validate CHECK = new Validate();
    
    //function 0
    public void menu() {
        System.out.println("======Worker Management======");
        System.out.println("======");
        System.out.println("1. Add worker");
        System.out.println("2. Up Salary");
        System.out.println("3. Down Salary");
        System.out.println("4. Display Information Salary");
        System.out.println("5.Exit");
    }
    //function 1
    public void addWorker(ArrayList<Worker> lw) {
        System.out.println("enter id: ");
        String id = CHECK.getString();
        System.out.println("enter name: ");
        String name = CHECK.getString();
        int age = CHECK.getInt("enter age: ", 18, 50);
        double salary = CHECK.getDouble("enter salary: ", 0, Integer.MAX_VALUE);
        System.out.println("enter worker location");
        String workerLocation = CHECK.getString();

        if (CHECK.isExistWorker(lw, id, name, age, salary, workerLocation)) {
            System.out.println("Worker exist!");
        } else {
            lw.add(new Worker(id, name, age, salary, workerLocation));
            System.out.println("Added!");
        }
    }
    
    //function 2,3
    public Worker getWorkerById(ArrayList<Worker> lw, String id) {
        for (Worker worker : lw) {
            if (id.equalsIgnoreCase(worker.getId())) {
                return worker;
            }
        }
        return null;
    }

    public String getCurrentDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        return df.format(cal.getTime());
    }
    
    public void changeSalary(ArrayList<Worker> lw, ArrayList<SalaryHistory> lh, int mode) {
        if (lw.isEmpty()) {
            System.out.println("list worker empty");
            return;
        }

        System.out.println("enter id: ");
        String id = CHECK.getString();
        Worker worker = getWorkerById(lw, id);

        if (worker == null) {
            System.out.println("worker not exist!");
        } else {
            double currentSalary = worker.getSalary();
            double updateSalary;
            
            System.out.println("--------UP/DOWN Salary--------");
            
            switch (mode) {     
                    
                case 1:
                    do {
                        updateSalary = CHECK.getDouble("enter update salary: ",
                                0, Integer.MAX_VALUE);
                    } while (updateSalary <= currentSalary);
                    lh.add(new SalaryHistory("UP", getCurrentDate(), worker.getId(),
                            worker.getName(), worker.getAge(), updateSalary, worker.getWorkLocation()));
                    worker.setSalary(updateSalary);
                    System.out.println("update success!");
                    break;
                case 2:
                    do {
                        updateSalary = CHECK.getDouble("enter update salary: ",
                                0, Integer.MAX_VALUE);
                    } while (updateSalary >= currentSalary);
                    lh.add(new SalaryHistory("DOWN", getCurrentDate(), worker.getId(),
                            worker.getName(), worker.getAge(), updateSalary, worker.getWorkLocation()));
                    worker.setSalary(updateSalary);
                    System.out.println("update success!");
                    break;
            }
        }

    }
    
    //function 4
    public void printHistoryChange(ArrayList<SalaryHistory> lh) {
        if(lh.isEmpty()) {
            System.out.println("nothing change!");
            return;
        }
        
        System.out.println("---------Display Information Salary-------------");
        System.out.printf("%s %15s %15s %15s %15s %15s \n", "Code", "Name", "Age",
                "Salary", "Status", "Update");
        Collections.sort(lh);
        
        for(SalaryHistory history : lh) {
//            System.out.println(history.getId() +"\t" + history.getName() + "\t" + history.getAge()
//            + "\t" + history.getSalary() + "\t" + history.getStatus() + "\t" + history.getDate());
            System.out.printf("%s %15s %15d %15f %15s %15s \n", history.getId(), history.getName(), history.getAge(),
                history.getSalary(), history.getStatus(), history.getDate());
        }
    }
}
