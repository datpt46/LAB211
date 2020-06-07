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

/**
 *
 * @author Administrator
 */
public class Manage implements ManageInterface {

    validation.Validate CHECK = new validation.Validate();

    public void menu() {
        System.out.println("======Candidate management system======");
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Internship");
        System.out.println("4. Searching");
        System.out.println("5. Exit");
    }

    @Override
    public void add(ArrayList<Candidate> candidates, int type) {

        while (true) {
            String id = CHECK.getId(candidates);
            System.out.println("enter your first name: ");
            String fName = CHECK.getString();
            System.out.println("enter your last name: ");
            String lName = CHECK.getString();
            int birthDate = CHECK.getInt("enter your birthDate: ", 1900, Calendar.getInstance().get(Calendar.YEAR));
            System.out.println("enter your address: ");
            String address = CHECK.getString();
            System.out.println("enter phone number: ");
            String phone = CHECK.getphoneNumber(candidates);
            System.out.println("enter email: ");
            String email = CHECK.getEmail(candidates);

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

            System.out.println("Do you want to continue? (Y/N)");
            if (!CHECK.chooseYN()) {
                return;
            }

        }

    }

    @Override
    public void createExperience(ArrayList<Candidate> candidates, Candidate cd) {
        int yearExperience = CHECK.getYearOfExperience(cd.getBirthDate());
        System.out.println("enter professional skill: ");
        String proSkill = CHECK.getString();

        candidates.add(new Experience(yearExperience, proSkill,
                cd.getId(), cd.getFirstName(), cd.getLastName(),
                cd.getBirthDate(), cd.getAddress(),
                cd.getPhone(), cd.getEmail(), cd.getType()));
        System.out.println("experience created!");
    }

    @Override
    public void createFresher(ArrayList<Candidate> candidates, Candidate cd) {
        System.out.println("enter graduation date: ");
        String graDate = CHECK.getString();
        System.out.println("enter graduation rank: ");
        String graRank = CHECK.getString();
        System.out.println("enter university: ");
        String education = CHECK.getString();

        candidates.add(new Fresher(graDate, graRank, education,
                cd.getId(), cd.getFirstName(), cd.getLastName(),
                cd.getBirthDate(), cd.getAddress(),
                cd.getPhone(), cd.getEmail(), cd.getType()));
        System.out.println("fresher created!");
    }

    @Override
    public void createIntern(ArrayList<Candidate> candidates, Candidate cd) {
        System.out.println("enter major: ");
        String major = CHECK.getString();
        int semester = CHECK.getInt("enter semester: ", 1, 9);
        System.out.println("enter university: ");
        String university = CHECK.getString();

        candidates.add(new Intern(major, semester, university,
                cd.getId(), cd.getFirstName(), cd.getLastName(),
                cd.getBirthDate(), cd.getAddress(), cd.getPhone(),
                cd.getEmail(), cd.getType()));
        System.out.println("Intern created!");
    }

    @Override
    public void search(ArrayList<Candidate> candidates) {
        displayListCandidate(candidates);

        System.out.println("enter first name or last name of candidate: ");
        String nameSearch = CHECK.getString();
        int cdType = CHECK.getInt("enter candidate type: ", 0, 2);

        for (Candidate cd : candidates) {
            if (cdType == cd.getType()
                    && (cd.getFirstName().contains(nameSearch)
                    || cd.getLastName().contains(nameSearch))) {
                System.out.println(cd.toString());
                return;
            }
        }

        System.out.println("candidate not found!");

    }

    @Override
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
