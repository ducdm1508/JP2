package Service;

import Entity.Customer;

import java.util.List;

public class CustomerService {

    private List<Customer> customers;
    public CustomerService(List<Customer> customers) {
        this.customers = customers;
    }
    public int getNextId() {
        return customers.size() + 1 ;
    }
    public void add(Customer customer) {
        customers.add(customer);
    }

}
