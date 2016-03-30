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

   /* public static void main(String[] args) throws IOException, SQLException {

       *//* BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        int number;


        System.out.println();



        //вычисляем количество материалов

        QuantityMaterial qm = new QuantityMaterial(heater,quadrature);

        System.out.println("Для этой квадратуры понадобится: ");
        System.out.println(qm.quantityWarm() + " листов утеплителя");
        System.out.println(qm.glue() + " мешков клея");
        System.out.println(qm.putti() + " мешков шпаклевки");
        System.out.println(qm.qrid() + " квадратных метров сетки" );
        System.out.println(qm.paint() + " литров краски");
*/


    public static  void recordDB(){

        Factory factory = Factory.getInstance();
        CustomerDao customerDao = factory.getCustomerDao();

        Customer customer = new Customer();
        customer.setName(MyServlet.name);
        customer.setQuad(MyServlet.quad);
        customer.setNumber(MyServlet.number);


        //add in data base
        try {
            customerDao.addCustomer(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }

       /* ApplicationContext context = new ClassPathXmlApplicationContext("all_context");

        customer = (Customer)context.getBean("customer");
        System.out.println(customer);*/


        //close SessionFactory
        HibernateUtil.close();


    }


    public  static double calkPrice(){
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
             result=styrofoam.price(quadrature, depth, density);


        } else if (thick.equals("expanded_polystyrene")){
            depth = MyServlet.thick;
            quadrature = MyServlet.quad;
            ExtrudedPolystyrene extrudedPolystyrene = new ExtrudedPolystyrene();
           result = extrudedPolystyrene.price(quadrature,depth);

        }else if(thick.equals("mineral_wool")){

            depth = MyServlet.thick;
            quadrature = MyServlet.quad;

            MineralWool mineralWool = new MineralWool();
            result = mineralWool.price(quadrature,depth);
        }


        return result;

    }

}
