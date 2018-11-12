package br.com.customer.service;

import br.com.customer.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer getCustomer(String cpf);
    List<Customer> getAllCustomers();
    Customer deleteCustomer(String cpf);
    Customer updateCustomer(Customer customer);
    Customer createCustomer(Customer customer);

}
