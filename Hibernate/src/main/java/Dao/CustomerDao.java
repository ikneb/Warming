package Dao;

import table.Customer;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Benki on 18.03.2016.
 */
public interface CustomerDao {
    public void addCustomer(Customer customer)throws SQLException;
    public void deleteCustomer(Customer customer) throws SQLException;
    public Customer getCustomer(int id)throws SQLException;
    public List<Customer> getCustomer()throws SQLException;
}
