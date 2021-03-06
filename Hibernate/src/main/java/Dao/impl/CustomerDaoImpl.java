package Dao.impl;

import Dao.CustomerDao;
import org.hibernate.Session;
import table.Customer;
import util.HibernateUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Benki on 18.03.2016.
 */
public class CustomerDaoImpl implements CustomerDao {
    @Override
    public void addCustomer(Customer customer) throws SQLException {
        Session session = null;
        try {//open session
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(customer);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void deleteCustomer(Customer customer) throws SQLException {
        Session session = null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(customer);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen()))session.close();
        }

    }

    @Override
    public Customer getCustomer(int id) throws SQLException {
        Customer result = null;
        Session session = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            result = (Customer)session.get(Customer.class,id);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if((session!= null)&&(session.isOpen()))session.close();
        }
        return result;
    }

    @Override
    public List<Customer> getCustomer() throws SQLException {
        List<Customer> customers = null;
        Session session = null;

        try{
            session =HibernateUtil.getSessionFactory().openSession();
            customers = session.createCriteria(Customer.class).list();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if((session!= null)&&(session.isOpen()))session.close();
        }

        return customers;
    }
}
