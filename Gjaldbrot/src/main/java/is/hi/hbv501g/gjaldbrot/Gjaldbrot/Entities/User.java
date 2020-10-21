package is.hi.hbv501.gjaldbrot.Gjaldbrot.Entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public String userFName;
    public String userLName;
    public String userEmail;
    public String userPass;

    public User() {
    }

    /**
     * 
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * 
     * 
     */
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return userFName + " " + userLName;
    }
    
    /**
     * 
     * 
     */
    public String getFirstName() {
        return userFName;
    }

    /**
     * 
     * 
     */
    public String getLastName() {
        return userLName;
    }

    /**
     * 
     * 
     */
    public String getPassword() {
        return userPass;
    }

    /**
     * 
     * 
     */
    public void setPassword(String password) {
        this.password = userPass;
    }
    /**
     * User 
     * 
     */
    public User(String email, String password) {
        this.email = userEmail;
        this.password = userPass;
    }

    // public createCurReceipt(int amount, Type t, Date d, Time tm) {

    // }
    
    // public createReceipt(curReceipt) {

    // }

    // public deleteReceipt(CurrentReceipt) {

    // }

    // public changeCurReceipt(CurrentReceipt) {

    // }
}
