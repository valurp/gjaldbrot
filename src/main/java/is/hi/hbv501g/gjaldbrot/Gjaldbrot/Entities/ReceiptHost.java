package is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.ReceiptType.Type;

/**
 * Klasi notaður til þess að geyma gögn úr ThymeLeaf á strengjaformi,
 * Svo gögn geti verið rétt parsed þegar þau eru sett í gagnagrunn
 */
@Entity
public class ReceiptHost {
    @Id
    private int id;
    private String date;
    private String time;
    private String type;
    private int amount;

    public ReceiptHost(){

    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }



    @Override
    public String toString(){
        return "" + "\n" + date + "\n" + time + "\n" + type + "\n" + amount;
    }

    public ReceiptHost(String date, String time, String type, int amount) {
        this.date = date;
        this.time = time;
        this.type = type;
        this.amount = amount;
    }

    public Receipt createReceipt() throws Exception{
        Receipt r = new Receipt();
        r.setAmount(this.amount);
        System.out.println(this.date);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = df.parse(this.date);
        System.out.println(d);
        r.setDate(d);
        LocalTime t = LocalTime.parse(this.time);
        r.setTime(t);
        r.setAmount(this.amount);
        return r;
        //Látum type vera null (í bili)



    }
}
