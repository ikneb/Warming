package general;

import Dao.CustomerDao;
import Dao.impl.CustomerDaoImpl;

/**
 * Created by Benki on 18.03.2016.
 */
public class Factory {
    public static Factory instance = new Factory();
    public CustomerDao customerDao;


    private Factory(){}

    public static Factory getInstance(){
        return Factory.instance;
    }

    public CustomerDao getCustomerDao(){
        if(customerDao == null)customerDao = new CustomerDaoImpl();
        return customerDao;
    }
}
