package Dao.impl;

import Dao.SmsDao;
import org.hibernate.Session;
import table.Customer;
import table.Sms;
import util.HibernateUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Benki on 03.04.2016.
 */
public class SmsDaoImpl implements SmsDao {
    @Override
    public void addSms(Sms sms) throws SQLException {
        Session session = null;
        try {//open session
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(sms);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }

    }

    @Override
    public void deleteSms(Sms sms) throws SQLException {
        Session session = null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(sms);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen()))session.close();
        }

    }

    @Override
    public Sms getSms(int id) throws SQLException {
        Sms result = null;
        Session session = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            result = (Sms)session.get(Sms.class,id);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if((session!= null)&&(session.isOpen()))session.close();
        }
        return result;
    }

    @Override
    public List<Sms> getSms() throws SQLException {
        List<Sms> smses = null;
        Session session = null;

        try{
            session =HibernateUtil.getSessionFactory().openSession();
            smses = session.createCriteria(Customer.class).list();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if((session!= null)&&(session.isOpen()))session.close();
        }

        return smses;
    }
}
