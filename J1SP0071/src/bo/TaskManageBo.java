/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Task;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class TaskManageBo {

    validation.getInput CHECK = new validation.getInput();

    public void menu() {
        System.out.println("======Task Program=====");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Display Task");
        System.out.println("4. Exit");
    }

    public void addTask(ArrayList<Task> taskList, int id) {

        System.out.println("Enter requirement name: ");
        String requireName = CHECK.getString();
        String taskType = CHECK.getTaskNameById();
        String date = CHECK.getDate("enter date: ");
        double planFrom = CHECK.getPlanTime("enter plan from: ");
        double planTo = CHECK.getPlanTime("enter plan to: ");
        System.out.println("Enter assignee: ");
        String assign = CHECK.getString();
        System.out.println("Enter reviewer: ");
        String reviewer = CHECK.getString();

        if (planFrom < planTo) {
            taskList.add(new Task(id, taskType, requireName, date, planFrom, planTo, assign, reviewer));
            System.out.println("added success!");
        } else {
            System.out.println("added fail! plan from must lower than plan to");
        }
    }

    public void deleteTask(ArrayList<Task> taskList) {
        validation.Validate get = new validation.Validate();
        int idFound = get.findTaskById(taskList);

        if (taskList.isEmpty()) {
            System.out.println("nothing to delete!");
        }

        if (idFound != -1) {
            taskList.remove(idFound);
            for (int i = idFound; i < taskList.size(); i++) {
                taskList.get(i).setId(taskList.get(i).getId()-1);
            }
            System.out.println("delete success!");
        } else {
            System.out.println("id not found!");
        }
    }
    
    public void displayTask(ArrayList<Task> taskList){
        if(taskList.isEmpty()){
            System.out.println("Nothing to show!");
            return;
        }
        
        System.out.printf("%5s %15s %15s %15s %15s %15s %15s\n", "Id", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        for(Task t : taskList){
            System.out.printf("%5d %15s %15s %15s %15f %15s %15s\n", 
                    t.getId(), t.getRequirementName(), t.getTaskTypeId(),
                    t.getDate(), t.getPlanTo() - t.getPlanFrom(),
                    t.getAssignee(), t.getReviewer());
        }

    }

}
