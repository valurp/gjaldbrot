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

    public long getId() {
        return id;
    }

    public Receipt() {

    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Receipt(Date date, LocalTime time, Type type, int amount) {
        this.date = date;
        this.time = time;
        this.type = type;
        this.amount = amount;
    }
}
