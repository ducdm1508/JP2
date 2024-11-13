package Service;

import Entity.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerService {
    private List<Customer> customers;

    public CustomerService(List<Customer> customers) {
        this.customers = customers;
    }

    public void add(Customer customer) {
        customers.add(customer);
    }

    public Customer getCusByCode(String code) {
        Optional<Customer> customer = customers.stream().filter(c -> c.getCode().equals(code)).findFirst();
        if (customer.isPresent()) {
            return customer.get();
        }else {
            return null;
        }
    }
}
