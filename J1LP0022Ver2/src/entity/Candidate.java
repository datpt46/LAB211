
package entity;

import java.util.List;
import util.Helper;
import util.IConstant;
import util.Validate;

public class Candidate {

    private int id;
    private String firstname;
    private String lastname;
    private int birthdate;
    private String address;
    private String phone;
    private String email;
    private int type;

    public Candidate() {
    }

    public Candidate(int id, String firstname, String lastname, int birthdate, String address, String phone, String email, int type) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.type = type;
    }

    public int getId() {
        return id;
    }


    public int getBirthdate() {
        return birthdate;
    }

    public int getType() {
        return type;
    }
    
    
    public void setType(int type) {
        this.type = type;
    }
   
    @Override
    public String toString() {
        return firstname + " " + lastname
                + " | " + birthdate
                + " | " + address
                + " | " + phone
                + " | " + email
                + " | " + type;
    }
    
    /**
     * get fullname of cdd
     */
    
    public String getFullName(){
        return this.firstname + " " + this.lastname;
    }
    
    /**
     * 
     * @return age of candidate
     */
    public int getAge(){
        return Helper.getCurrentYear() - this.getBirthdate();
    }
    
    //check candidate exists
    private boolean isCddExist(List<Candidate> list, int id){
        for(Candidate c:list){
            if(id == c.getId()){
                return true;
            }
        }
        return false;
    }
    
    /**
     * 
     * @param list: list candidate
     * @return id of cdd that's not exist in the list
     */
    private int getId(List<Candidate> list){
        while(true){
            int id = Validate.getInt("Enter id: ", 1, Integer.MAX_VALUE);
            if(isCddExist(list, id)){
                System.err.println("Id existed!");
            } else {
                return id;
            }
        }
    }
    
    //create candidate
    public void create(List<Candidate> list){
        this.id = getId(list);
        this.firstname = Validate.getString("enter first name: ", "first name invalid!", IConstant.NAME);
        this.lastname = Validate.getString("enter last name: ", "last name invalid!", IConstant.NAME);
        this.birthdate = Validate.getInt("Enter birthdate: ", 1900, Helper.getCurrentYear());
        this.address = Validate.getString("Enter address: ", "address invalid!", IConstant.TEXT);
        this.phone = Validate.getString("Enter phone: ", "phone number invalid!", IConstant.PHONE);
        this.email = Validate.getString("Enter email: ", "Email invalid!", IConstant.EMAIL);
    }
}

