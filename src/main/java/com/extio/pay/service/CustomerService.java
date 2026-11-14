package com.extio.pay.service;

import com.extio.pay.entity.Customer;
import com.extio.pay.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

public void deleteCustomer(Long id){
    customerRepository.deleteById(id);
}


}
