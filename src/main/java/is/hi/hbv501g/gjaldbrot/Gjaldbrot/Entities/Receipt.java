package is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.ReceiptType.Type;

@Entity
@Table(name = "Receipt")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User user;
    
    private Date date;
    private LocalTime time;
    private Type type;
    private int amount;

    /**
     *
     * @return
     */
    public long getId() {
        return id;
    }

    public Receipt() {

    }

    /**
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @return
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     *
     * @param time
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    /**
     *
     * @return
     */
    public Type getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public int getAmount() {
        return amount;
    }

    /**
     *
     * @param amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     *
     * @param date
     * @param time
     * @param type
     * @param amount
     */
    public Receipt(Date date, LocalTime time, Type type, int amount) {
        this.date = date;
        this.time = time;
        this.type = type;
        this.amount = amount;
    }
}
