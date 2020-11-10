package is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.ReceiptType.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Receipt")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User user;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date date;
    private LocalTime time;
    private Type type;
    private int amount;

    /**
     * getId
     * @return id of receipt
     */
    public long getId() {
        return id;
    }

    @Override
    public String toString(){
        return "" + id + "\n" + date + "\n" + time + "\n" + type + "\n" + amount;
    }
    public Receipt() {

    }

    /**
     * setUser(User user)
     * @param user user entity to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *  setId(Long id)
     * @param id id of receipt to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * getDate()
     * @return date of receipt
     */
    public Date getDate() {
        return date;
    }

    /**
     * setDate(Date date)
     * @param date date of receipt to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * getTime()
     * @return time of the receipt
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     * setTime(LocalTime time)
     * @param time time to receipt set
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    /**
     * getType()
     * @return type of the receipt
     */
    public Type getType() {
        return type;
    }

    /**
     * setType(Type type)
     * @param type type of receipt to set
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * getAmount()
     * @return amount of the receipt
     */
    public int getAmount() {
        return amount;
    }

    /**
     * setAmount(int amount)
     * @param amount amount of the receipt to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * Receipt(Date date, LocalTime time, Type type, int amount)
     * @param date date of the receipt
     * @param time time of the receipt
     * @param type type of the receipt
     * @param amount amount of the receipt
     */
    public Receipt(Date date, LocalTime time, Type type, int amount) {
        this.date = date;
        this.time = time;
        this.type = type;
        this.amount = amount;
    }

    public Receipt(int amount) {
        this.amount = amount;
    }
}
