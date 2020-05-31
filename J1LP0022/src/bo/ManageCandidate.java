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
import validation.Validate;

/**
 *
 * @author Administrator
 */
public class ManageCandidate {

    static final validation.Validate CHECK = new Validate();

    public void menu() {
        System.out.println("CANDIDATE MANAGEMENT SYSTEM");
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. InternShip");
        System.out.println("4. Searching");
        System.out.println("5. Exỉt");
    }

    //function 1
    public void createCandidate(ArrayList<Candidate> candidates, int type) {
        while (true) {
            System.out.println("enter candidate id: ");
            String id = CHECK.getString();
            System.out.println("enter candidate first name: ");
            String firstName = CHECK.getString();
            System.out.println("enter candidate last name: ");
            String lastName = CHECK.getString();
            int birthDate = CHECK.getInt("enter birthdate(year): ", 1900, Calendar.getInstance().get(Calendar.YEAR));
            System.out.println("enter address: ");
            String address = CHECK.getString();
            System.out.println("enter phone: ");
            String phone = CHECK.getPhoneNumber();
            System.out.println("enter email: ");
            String email = CHECK.getEmail();

            Candidate candidate = new Candidate(id, firstName, lastName, birthDate, address, phone, email, type);

            if (!CHECK.isCandidateId(candidates, id)) {
                switch (type) {
                    case 0:
                        createExperience(candidates, candidate);
                        break;
                    case 1:
                        createFresher(candidates, candidate);
                        break;
                    case 2:
                        createIntern(candidates, candidate);
                        break;
                }
            } else {
                System.out.println("Candidate id existed!");
            }

            System.out.println("Do you want to continue(Y/N) ?");
            if (!CHECK.chooseYN()) {
                return;
            }

        }
    }

    // function 1.5: 3 smaller function
    public void createExperience(ArrayList<Candidate> candidates, Candidate candidate) {
        int expYear = CHECK.getInputExperience(candidate.getBirthDate());
        System.out.println("enter professional skill: ");
        String proSkill = CHECK.getString();

        candidates.add(new Experience(expYear, proSkill, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate(),
                candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getType()));
        System.out.println("experience added!");

    }

    public void createFresher(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.println("enter graduation date: ");
        String graduationDate = CHECK.getString();
        System.out.println("enter graduation rank: ");
        String graduationRank = CHECK.getString();
        System.out.println("enter education(university name): ");
        String education = CHECK.getString();

        candidates.add(new Fresher(graduationDate, graduationRank, education,
                candidate.getId(), candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(),
                candidate.getEmail(), candidate.getType()));
        System.out.println("fresher added!");

    }

    public void createIntern(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.println("enter major: ");
        String major = CHECK.getString();
        int semester = CHECK.getInt("enter semester(1-9): ", 1, 9);
        System.out.println("enter university name: ");
        String university = CHECK.getString();

        candidates.add(new Intern(major, semester, university,
                candidate.getId(), candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(),
                candidate.getEmail(), candidate.getType()));
        System.out.println("intern added!");

    }

    //function 2: search candidate by name
    public void searchCandidate(ArrayList<Candidate> candidates) {
        displayCandidateName(candidates);

        System.out.println("enter name (firstname or lastname): ");
        String nameToFind = CHECK.getString();
        int typeToFind = CHECK.getInt("enter type of candidate(0-2): ", 0, 2);

        for (Candidate cd : candidates) {
            if (typeToFind == cd.getType()
                    && (cd.getFirstName().contains(nameToFind)
                    || cd.getLastName().contains(nameToFind))) {
                System.out.println(cd.displayCandidateInfo());
            }
        }

    }

    //function 3: display intern
    public void displayCandidateName(ArrayList<Candidate> candidates) {
        System.out.println("======Experience Candidate=====");
        for (Candidate cd : candidates) {
            if (cd instanceof Experience) {
                System.out.println(cd.getFirstName() + " " + cd.getLastName());
            }
        }

        System.out.println("======Fresher Candidate=====");
        for (Candidate cd : candidates) {
            if (cd instanceof Fresher) {
                System.out.println(cd.getFirstName() + " " + cd.getLastName());
            }
        }

        System.out.println("======Internship Candidate=====");
        for (Candidate cd : candidates) {
            if (cd instanceof Intern) {
                System.out.println(cd.getFirstName() + " " + cd.getLastName());
            }
        }
    }
}
