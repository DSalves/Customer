package br.com.customer.service.impl;

import br.com.customer.exception.CustomerException;
import br.com.customer.model.Customer;
import br.com.customer.repositories.CustomerRepository;
import br.com.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static br.com.customer.utils.Constants.MESSAGE_CUSTOMER_NOT_FOUND;
import static br.com.customer.utils.Constants.MESSAGE_CUSTOMER_NOT_SAVE;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomer(String cpf) {
        try {
            return customerRepository.findByCpf(cpf);
        } catch (CustomerException ce){
            throw new CustomerException(MESSAGE_CUSTOMER_NOT_FOUND);
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<Customer>();
        customerRepository.findAll().forEach(customer -> customers.add(customer));
        return customers;
    }

    @Override
    public Customer deleteCustomer(String cpf) {
        Customer customer = customerRepository.findByCpf(cpf);
        customerRepository.deleteById(customer.getId());
        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return createCustomer(customer);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        try {
            return customerRepository.save(customer);
        } catch (CustomerException ce){
            throw new CustomerException(MESSAGE_CUSTOMER_NOT_SAVE);
        }

    }
}
