package Entity;

import Dao.CustomerDao;

import general.Factory;

import table.Customer;
import unlimit.MyServlet;
import util.HibernateUtil;


import java.sql.SQLException;


/**
 * Created by Benki on 18.02.2016.
 */
public class Main {

    double price;


    public static void recordDB() {

        int warmQuantity;
        int glueQuantity;
        int puttiQuantity;
        int gridQuantity;
        int paintQuantity;

        warmQuantity = QuantityMaterial.warmQuantity(MyServlet.material, MyServlet.quad);
        glueQuantity = QuantityMaterial.glueQuantity(MyServlet.quad);
        puttiQuantity = QuantityMaterial.puttiQuantity(MyServlet.quad);
        gridQuantity = QuantityMaterial.qridQuantity(MyServlet.quad);
        paintQuantity = QuantityMaterial.paintQuantity(MyServlet.quad);


        Factory factory = Factory.getInstance();
        CustomerDao customerDao = factory.getCustomerDao();

        Customer customer = new Customer();
        customer.setName(MyServlet.name);
        customer.setQuad(MyServlet.quad);
        customer.setNumber(MyServlet.number);
        customer.setThick(MyServlet.thick);
        customer.setMaterial(MyServlet.material);
        customer.setDensity(MyServlet.density);


        //add in data base
        try {
            customerDao.addCustomer(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //close SessionFactory
        HibernateUtil.close();


    }


    public static double calkPrice() {
        String name;
        String thick;
        int number;
        int depth;
        int quadrature;
        double result = 0;


        //выщитываем стоимость

        thick = MyServlet.material;

        if (thick.equals("styrofoam")) {

            int density = MyServlet.density;                           //плотность
            depth = MyServlet.thick;
            quadrature = MyServlet.quad;
            Styrofoam styrofoam = new Styrofoam();
            result = styrofoam.price(quadrature, depth, density);


        } else if (thick.equals("expanded_polystyrene")) {
            depth = MyServlet.thick;
            quadrature = MyServlet.quad;
            ExtrudedPolystyrene extrudedPolystyrene = new ExtrudedPolystyrene();
            result = extrudedPolystyrene.price(quadrature, depth);

        } else if (thick.equals("mineral_wool")) {

            depth = MyServlet.thick;
            quadrature = MyServlet.quad;

            MineralWool mineralWool = new MineralWool();
            result = mineralWool.price(quadrature, depth);
        }


        return result;

    }


}
