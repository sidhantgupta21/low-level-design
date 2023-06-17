package machinecoding.gymbooking.customer.service;

import machinecoding.gymbooking.customer.model.Customer;
import machinecoding.gymbooking.customer.repository.CustomerRepository;

public class CustomerService {

    private static CustomerService instance = null;
    private final CustomerRepository customerRepository;

    private CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static CustomerService getInstance(CustomerRepository customerRepository) {
        if (instance == null) {
            synchronized (CustomerService.class) {
                if (instance == null) {
                    instance = new CustomerService(customerRepository);
                }
            }
        }
        return instance;
    }

    public Customer createCustomer(String name, String email) {
        return customerRepository.saveCustomer(name, email);
    }
}
