package is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities;


import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Receipt> receipts;

    public String uName;

    public String password;

    public User() {
    }

    /**
     * getId()
     * @return users id
     */
    public long getId() {
        return id;
    }

    /**
     * setId(long id)
     * @param id sets users id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * toString()
     * @return values of the user (id, uName and password) as a string
     */
    @Override
    public String toString() {
        return ""+id+" "+uName+" "+password;
    }

    /**
     * getuName()
     * @return users username
     */
    public String getuName() {
        return uName;
    }

    /**
     * setuName(String uName)
     * @param uName sets the users username
     */
    public void setuName(String uName) {
        this.uName = uName;
    }

    /**
     * getPassword()
     * @return users password
     */
    public String getPassword() {
        return password;
    }

    /**
     * setPassword(String password)
     * @param password sets the users password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * getReceipts()
     * @return list of all receipt made by the user
     */
    public List<Receipt> getReceipts() {return receipts;}

    /**
     * User(String uName, String password)
     * @param uName sets the users username
     * @param password sets the users password
     */
    public User(String uName, String password) {
        this.uName = uName;
        this.password = password;
    }
}