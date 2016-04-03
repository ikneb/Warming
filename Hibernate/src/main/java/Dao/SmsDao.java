package Dao;

import table.Sms;
import java.sql.SQLException;
import java.util.List;


public interface SmsDao {
    public void addSms(Sms sms)throws SQLException;
    public void deleteSms(Sms sms) throws SQLException;
    public Sms getSms(int id)throws SQLException;
    public List<Sms> getSms()throws SQLException;
}
