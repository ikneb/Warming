package Dao;

import table.Customer;
import java.sql.SQLException;
import java.util.List;


public interface CustomerDao {
    public void addCustomer(Customer customer)throws SQLException;
    public void deleteCustomer(Customer customer) throws SQLException;
    public Customer getCustomer(int id)throws SQLException;
    public List<Customer> getCustomer()throws SQLException;
}
