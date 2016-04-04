package Entity;

import Dao.CustomerDao;
import Dao.SmsDao;
import general.Factory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import table.Customer;
import table.Sms;
import unlimit.MyServlet;
import unlimit.MyServletSms;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    double price;

    public void recordDB() {
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

    public JSONObject allall() {
        List<Customer> customers = new ArrayList<>();
        JSONObject resultJson = new JSONObject();
        Factory factory = Factory.getInstance();
        CustomerDao customerDao = factory.getCustomerDao();

        JSONArray names = new JSONArray();
        JSONArray numbers = new JSONArray();
        JSONArray quads = new JSONArray();
        JSONArray thicks = new JSONArray();
        JSONArray materials = new JSONArray();
        JSONArray densities = new JSONArray();
        try {
            customers = customerDao.getCustomer();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Customer customer : customers) {
            names.add(customer.getName());
        }
        for (Customer customer : customers) {
            numbers.add(customer.getNumber());
        }
        for (Customer customer : customers) {
            quads.add(customer.getQuad());
        }
        for (Customer customer : customers) {
            thicks.add(customer.getThick());
        }
        for (Customer customer : customers) {
            materials.add(customer.getMaterial());
        }
        for (Customer customer : customers) {
            densities.add(customer.getDensity());
        }

        resultJson.put("count",names.size());
        resultJson.put("name",names);
        resultJson.put("number",numbers);
        resultJson.put("quad",quads);
        resultJson.put("thick",thicks);
        resultJson.put("material",materials);
        resultJson.put("densities",densities);


        System.out.println(resultJson);
        return resultJson;
    }

    public static void sms() {
        Factory factory = Factory.getInstance();
        SmsDao smsDao = factory.getSmsDao();

        Sms sms = new Sms();
        sms.setName(MyServletSms.name);
        sms.setEmail(MyServletSms.email);
        sms.setNumber(MyServletSms.number);
        sms.setSms(MyServletSms.sms);

        //add in data base
        try {
            smsDao.addSms(sms);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
