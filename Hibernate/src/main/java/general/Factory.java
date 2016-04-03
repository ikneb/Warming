package general;

import Dao.CustomerDao;
import Dao.SmsDao;
import Dao.impl.CustomerDaoImpl;
import Dao.impl.SmsDaoImpl;

/**
 * Created by Benki on 18.03.2016.
 */
public class Factory {
    public static Factory instance = new Factory();
    public CustomerDao customerDao;
    public SmsDao smsDao;



    private Factory(){}

    public static Factory getInstance(){
        return Factory.instance;
    }

    public CustomerDao getCustomerDao(){
        if(customerDao == null)customerDao = new CustomerDaoImpl();
        return customerDao;
    }

    public  SmsDao getSmsDao(){
        if(smsDao == null)smsDao = new SmsDaoImpl();
        return smsDao;
    }
}
