/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Candidate;
import entity.Experience;
import entity.Fresher;
import entity.Intern;
import java.util.ArrayList;
import java.util.Calendar;

public class Manage {

    validation.Validate check = new validation.Validate();

    public void menu() {
        System.out.println("======Candidate management system======");
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Internship");
        System.out.println("4. Searching");
        System.out.println("5. Exit");
    }

    public void add(ArrayList<Candidate> candidates, int type) {

        while (true) {
//            String id = check.getId(candidates);
            System.out.println("enter id: ");
            String id = check.getString();
            if (check.isCandidateId(candidates, id) == -1) {
                System.out.println("enter your first name: ");
                String fName = check.getString();
                System.out.println("enter your last name: ");
                String lName = check.getString();
                int birthDate = check.getInt("enter your birthDate: ", 1900, Calendar.getInstance().get(Calendar.YEAR));
                System.out.println("enter your address: ");
                String address = check.getString();
                System.out.println("enter phone number: ");
                String phone = check.getphoneNumber(candidates);
                System.out.println("enter email: ");
                String email = check.getEmail(candidates);

                Candidate cd = new Candidate(id, fName, lName, birthDate, address, phone, email, type);

                switch (type) {
                    case 0:
                        createExperience(candidates, cd);
                        break;
                    case 1:
                        createFresher(candidates, cd);
                        break;
                    case 2:
                        createIntern(candidates, cd);
                        break;
                }

            } else {
                System.out.println("id existed!");
            }
            System.out.println("Do you want to continue? (Y/N)");
            if (!check.chooseYN()) {
                return;
            }
        }
    }

    public void createExperience(ArrayList<Candidate> candidates, Candidate cd) {
        int yearExperience = check.getYearOfExperience(cd.getBirthDate());
        System.out.println("enter professional skill: ");
        String proSkill = check.getString();

        candidates.add(new Experience(yearExperience, proSkill,
                cd.getId(), cd.getFirstName(), cd.getLastName(),
                cd.getBirthDate(), cd.getAddress(),
                cd.getPhone(), cd.getEmail(), cd.getType()));
        System.out.println("experience created!");
    }

    public void createFresher(ArrayList<Candidate> candidates, Candidate cd) {
        System.out.println("enter graduation date: ");
        String graDate = check.getString();
        System.out.println("enter graduation rank: ");
        String graRank = check.getRankOfGraduation();
        System.out.println("enter university: ");
        String education = check.getString();

        candidates.add(new Fresher(graDate, graRank, education,
                cd.getId(), cd.getFirstName(), cd.getLastName(),
                cd.getBirthDate(), cd.getAddress(),
                cd.getPhone(), cd.getEmail(), cd.getType()));
        System.out.println("fresher created!");
    }

    public void createIntern(ArrayList<Candidate> candidates, Candidate cd) {
        System.out.println("enter major: ");
        String major = check.getString();
        int semester = check.getInt("enter semester: ", 1, 9);
        System.out.println("enter university: ");
        String university = check.getString();

        candidates.add(new Intern(major, semester, university,
                cd.getId(), cd.getFirstName(), cd.getLastName(),
                cd.getBirthDate(), cd.getAddress(), cd.getPhone(),
                cd.getEmail(), cd.getType()));
        System.out.println("Intern created!");
    }

    // add Experience E1, add Fresher F1, add Intern I1. => ArrayList<Candidate>
    public void search(ArrayList<Candidate> candidates) {
        int count = 0;

        displayListCandidate(candidates);
        System.out.println("\nenter name to search: ");
        String nameSearch = check.getString();
        int cdType = check.getInt("enter candidate type: ", 0, 2);

        for (Candidate cd : candidates) {
            if (cdType == cd.getType()
                    && (cd.getFirstName().contains(nameSearch)
                    || cd.getLastName().contains(nameSearch))) {
                count++;
                if (count == 1) {
                    System.out.println("candidate found!");
                }
                System.out.println(cd.toString());
            }
        }
        if (count == 0) {
            System.out.println("candidate not found!");
        }

//        System.out.println((count >= 1) ? "Candidate found!" : "Candidate not found!");
    }

    public void displayListCandidate(ArrayList<Candidate> candidates) {
        System.out.println("=========Experience========");

        for (Candidate cd : candidates) {
            if (cd instanceof Experience) {
                System.out.println(cd.getFirstName() + " " + cd.getLastName());
            }
        }

        System.out.println("\n==========Fresher=========");

        for (Candidate cd : candidates) {
            if (cd instanceof Fresher) {
                System.out.println(cd.getFirstName() + " " + cd.getLastName());
            }
        }

        System.out.println("\n==========Intern==========");

        for (Candidate cd : candidates) {
            if (cd instanceof Intern) {
                System.out.println(cd.getFirstName() + " " + cd.getLastName());
            }
        }
    }

}
