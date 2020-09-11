package entity;

import java.util.List;
import util.IConstant;
import util.Validate;

public class Experience extends Candidate {

    private int expInYear;
    private String proSkill;

    public Experience() {
    }

    public Experience(int id, String firstname, String lastname, int birthdate, String address, String phone, String email, int type,
            int expInYear, String proSkill) {
        super(id, firstname, lastname, birthdate, address, phone, email, type);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

//    create experience cdd. Year of experience must lower than candidate age
    @Override
    public void create(List<Candidate> list) {
        super.create(list);
        this.expInYear = Validate.getInt("Enter year of experience: ", 1, super.getAge());
        this.proSkill = Validate.getString("Enter pro skill: ", "pro skill invalid!", IConstant.TEXT);
        this.setType(0);
    }

}
