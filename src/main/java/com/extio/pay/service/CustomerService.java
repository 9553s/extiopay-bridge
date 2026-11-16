package com.extio.pay.service;

import com.extio.pay.dto.CustomerRequest;
import com.extio.pay.dto.CustomerResponse;
import com.extio.pay.entity.Customer;
import com.extio.pay.repository.CustomerRepository;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;



@Service
public class CustomerService {

private final CustomerRepository customerRepository;



public CustomerService(CustomerRepository customerRepository){

    this.customerRepository = customerRepository;
}

private CustomerResponse convertToResponse(Customer customer){

   return new CustomerResponse(
        customer.getId(),
        customer.getCustomerNumber(),
        customer.getFullName(),
        customer.getEmail() );
}

    public CustomerResponse saveCustomer(CustomerRequest request){
        Customer customer = new Customer();

        customer.setCustomerNumber(request.getCustomerNumber());
        customer.setFullName(request.getFullName());
        customer.setEmail(request.getEmail());

        Customer saveCustomer = customerRepository.save(customer);

        return convertToResponse(saveCustomer);

}
    // Get all customers
    public  List<CustomerResponse> getAllCustomers() {

        return customerRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }
    // get customer by ID
    public CustomerResponse getCustomerById(Long id){
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("customer not found") );

        return convertToResponse(customer);

}
    public CustomerResponse updateCustomer(Long id, CustomerRequest request) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Customer not found"));

        customer.setCustomerNumber(request.getCustomerNumber());
        customer.setFullName(request.getFullName());
        customer.setEmail(request.getEmail());

        Customer updatedCustomer = customerRepository.save(customer);

        return convertToResponse(updatedCustomer);
    }

    public void deleteCustomer(Long id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Customer not found"));

        customerRepository.delete(customer);
    }

}
