
package entity;

import java.util.List;
import util.IConstant;
import util.Validate;


public class Intern extends Candidate{
    private String major;
    private int semester;
    private String university;

    public Intern() {
    }

    public Intern(int id, String firstname, String lastname, int birthdate, String address, String phone, String email,
            int type, String major, int semester, String university) {
        super(id, firstname, lastname, birthdate, address, phone, email, type);
        this.major = major;
        this.semester = semester;
        this.university = university;
    }
    
//    create intern
    public void create(List<Candidate> list){
        super.create(list);
        this.major = Validate.getString("enter major: ", "major invalid!", IConstant.TEXT);
        this.semester = Validate.getInt("Enter semester: ", 1, 9);
        this.university = Validate.getString("enter university: ", "university invalid!", IConstant.TEXT);
        this.setType(2);
    }
}
