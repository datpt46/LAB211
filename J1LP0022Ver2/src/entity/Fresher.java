
package entity;

import java.util.List;
import util.Helper;
import util.IConstant;
import util.Validate;

public class Fresher extends Candidate {

    private int gradudationDate;
    private String graduationRank;
    private String education;

    public Fresher() {
    }

    public Fresher(int id, String firstname, String lastname, int birthdate, String address, String phone, String email, int type,
            int gradudationDate, String graduationRank, String education) {
        super(id, firstname, lastname, birthdate, address, phone, email, type);
        this.gradudationDate = gradudationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    private String getRankOfGraduation() {
        System.out.println("1. Excellence");
        System.out.println("2. Good");
        System.out.println("3. Fair");
        System.out.println("4. Poor");

        while (true) {
            int choice = Validate.getInt("enter rank of graduation: ",
                    1, 4);

            switch (choice) {
                case 1:
                    return "Excellence";
                case 2:
                    return "Good";
                case 3:
                    return "Fair";
                case 4:
                    return "Poor";
                default:
                    System.out.println("Excellence, Good, Fair or Poor only!!");
            }
        }
    }
    
//    create fresher cdd
    public void create(List<Candidate> list){
        super.create(list);
        this.gradudationDate = Validate.getInt("Enter graduation time: ",
                1900, Helper.getCurrentYear());
        this.graduationRank = getRankOfGraduation();
        this.education = Validate.getString("Enter education: ", "education invalid!", IConstant.TEXT);
        this.setType(1);
    }
}
