package machinecoding.gymbooking.customer.repository;

import machinecoding.gymbooking.customer.model.Customer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomerRepository {

    private static CustomerRepository instance = null;
    private int customerIdx;
    private final Map<Integer, Customer> customerMap;

    private CustomerRepository() {
        this.customerMap = new ConcurrentHashMap<>();
        this.customerIdx = 0;
    }

    public static CustomerRepository getInstance() {
        if (instance == null) {
            synchronized (CustomerRepository.class) {
                if (instance == null) {
                    instance = new CustomerRepository();
                }
            }
        }
        return instance;
    }

    public Customer saveCustomer(String name, String email) {
        Customer customer =  new Customer.CustomerBuilder(customerIdx + 1, name)
                .withEmail(email)
                .build();
        customerMap.put(customer.getId(), customer);
        customerIdx++;
        return customer;
    }
}
