package table;

import javax.persistence.*;

@Entity
@Table(name = "bdcustomer")
public class Customer {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "quad")
    private int quad;

    @Column(name = "number")
    private int number;


    public Customer(){

    }
    public Customer(String name,int quad,int number){
        this.name = name;
        this.quad = quad;
        this.number = number;

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

    public int getQuad() {
        return quad;
    }

    public void setQuad(int quad) {
        this.quad = quad;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}


