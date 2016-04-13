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
       /* int warmQuantity;
        int glueQuantity;
        int puttiQuantity;
        int gridQuantity;
        int paintQuantity;

        warmQuantity = QuantityMaterial.warmQuantity(MyServlet.material, MyServlet.quad);
        glueQuantity = QuantityMaterial.glueQuantity(MyServlet.quad);
        puttiQuantity = QuantityMaterial.puttiQuantity(MyServlet.quad);
        gridQuantity = QuantityMaterial.qridQuantity(MyServlet.quad);
        paintQuantity = QuantityMaterial.paintQuantity(MyServlet.quad);*/

        Factory factory = Factory.getInstance();
        CustomerDao customerDao = factory.getCustomerDao();

        Customer customer = new Customer();
        customer.setName(MyServlet.name);
        customer.setQuad(MyServlet.quad);
        customer.setNumber(MyServlet.number);
        customer.setThick(MyServlet.thick);
        customer.setMaterial(MyServlet.material);
        customer.setDensity(MyServlet.density);
        customer.setPrice((int) MyServlet.price);

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
        depth = MyServlet.thick;
        quadrature = MyServlet.quad;

        switch (thick) {
            case "styrofoam":
                int density = MyServlet.density;                           //плотность
                Styrofoam styrofoam = new Styrofoam();
                result = styrofoam.price(quadrature, depth, density);
                break;
            case "expanded_polystyrene":
                ExtrudedPolystyrene extrudedPolystyrene = new ExtrudedPolystyrene();
                result = extrudedPolystyrene.price(quadrature, depth);
                break;
            case "mineral_wool":
                MineralWool mineralWool = new MineralWool();
                result = mineralWool.price(quadrature, depth);
                break;
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
        JSONArray prices = new JSONArray();

        try {
            customers = customerDao.getCustomer();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Customer customer : customers) {
            names.add(customer.getName());
            numbers.add(customer.getNumber());
            quads.add(customer.getQuad());
            thicks.add(customer.getThick());
            materials.add(customer.getMaterial());
            densities.add(customer.getDensity());
            prices.add(customer.getPrice());
        }
        resultJson.put("count",names.size());
        resultJson.put("name",names);
        resultJson.put("number",numbers);
        resultJson.put("quad",quads);
        resultJson.put("thick",thicks);
        resultJson.put("material",materials);
        resultJson.put("densities",densities);
        resultJson.put("price",prices);

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

    public JSONObject read(){
        List<Sms> smsAr = new ArrayList<>();
        JSONObject resultJson = new JSONObject();
        Factory factory = Factory.getInstance();
        SmsDao smsDao = factory.getSmsDao();
        JSONArray names = new JSONArray();
        JSONArray numbers = new JSONArray();
        JSONArray emails = new JSONArray();
        JSONArray smses = new JSONArray();

        try {
            smsAr = smsDao.getSms();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Sms s: smsAr) {
            names.add(s.getName());
            numbers.add(s.getNumber());
            emails.add(s.getEmail());
            smses.add(s.getSms());
        }

        resultJson.put("count",names.size());
        resultJson.put("name",names);
        resultJson.put("number",numbers);
        resultJson.put("email",emails);
        resultJson.put("sms",smses);

        System.out.println(resultJson);
        return resultJson;
    }


    public static void deleteAll() {
        List<Sms> smsAr = new ArrayList<>();
        Factory factory = Factory.getInstance();
        SmsDao smsDao = factory.getSmsDao();

        try {
            smsAr = smsDao.getSms();//add all with bd
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Sms s: smsAr){
            try {
                smsDao.deleteSms(s);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
