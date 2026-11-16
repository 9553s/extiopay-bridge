package com.extio.pay.service;

import com.extio.pay.entity.Customer;
import com.extio.pay.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;



@Service
public class CustomerService {

private final CustomerRepository customerRepository;

public CustomerService(CustomerRepository customerRepository){
    this.customerRepository = customerRepository;
}

public  Customer saveCustomer(Customer customer){
    return customerRepository.save(customer);
}

public Optional<Customer> getCustomerById(Long id){
    return customerRepository.findById(id);

}
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

public void deleteCustomer(Long id){
    customerRepository.deleteById(id);
}


}
