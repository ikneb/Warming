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

    @Column(name = "thick")
    private int thick;

    @Column(name = "material")
    private String material;

    @Column(name = "density")
    private int density;

    @Column(name = "density")
    private int price;


    public Customer(){

    }
    public Customer(String name,int quad,int number,){
        this.name = name;
        this.quad = quad;
        this.number = number;
        this.thick = thick;
        this.material = material;
        this.density = density;
    }


    public int getThick() {
        return thick;
    }

    public void setThick(int thick) {
        this.thick = thick;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getDensity() {
        return density;
    }

    public void setDensity(int density) {
        this.density = density;
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


