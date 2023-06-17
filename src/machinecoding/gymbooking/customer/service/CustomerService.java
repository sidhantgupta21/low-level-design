package machinecoding.gymbooking.customer.service;

import machinecoding.gymbooking.customer.model.Customer;

public class CustomerService {

    private static CustomerService instance = null;

    private CustomerService() { }

    public static CustomerService getInstance() {
        if (instance == null) {
            synchronized (CustomerService.class) {
                if (instance == null) {
                    instance = new CustomerService();
                }
            }
        }
        return instance;
    }

    public Customer createCustomer(String name, String email) {
        return new Customer.CustomerBuilder(name)
                            .withEmail(email)
                            .build();
    }
}
