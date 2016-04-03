package table;

/**
 * Created by Benki on 03.04.2016.
 */

import javax.persistence.*;

@Entity
@Table(name = "sms")
public class Sms {



    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "email")
    String email;
    @Column(name = "number")
    int number;
    @Column(name = "sms")
    String sms;


    public Sms(){

    }

    public Sms(int id, String name, String email, int number, String sms) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.number = number;
        this.sms = sms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }
}
