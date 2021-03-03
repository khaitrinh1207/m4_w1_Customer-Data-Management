package DAO;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomerDAO{
    public static List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer(1,"Khải","khaitrinh1207@gmail.com","Nghệ An"));
        customers.add(new Customer(2,"Mai","mai123@gmail.com","Thái Bình"));
        customers.add(new Customer(3,"Thao","thao1123@gmail.com","Nam Định"));
        customers.add(new Customer(4,"Nam","namtao1233@gmail.com","Hà Nội"));
        customers.add(new Customer(5,"Lam","lamgiang@gmail.com","Thanh Hóa"));
        customers.add(new Customer(6,"Thomas","thomasedison@gmail.com","Canada"));
        customers.add(new Customer(7,"James","jamesbond@gmail.com","Paris"));
        customers.add(new Customer(8,"Victor","victorhigo@gmail.com","London"));
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = CustomerDAO.customers;
        return customers;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        for (int i = 0; i < customers.size(); i++) {
            if(id == customers.get(i).getId()){
                customer = customers.get(i);
            }
        }
        return customer;
    }

    @Override
    public void save(Customer customer) {

        customers.add(customer);
    }

    @Override
    public void update(int id, Customer customer) {
        for (int i = 0; i < customers.size(); i++) {
            if (id == customers.get(i).getId()){
                customers.set(i,customer);
            }
        }
    }

    @Override
    public void remote(int id) {
        customers.remove(id);
    }
}
