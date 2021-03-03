package DAO;

import model.Customer;

import java.util.List;

public interface ICustomerDAO<T> {
    List<T> findAll();

    Customer findById(int id);

    void save(Customer customer);

    void update(int id, Customer customer);

    void remote(int id);


}
