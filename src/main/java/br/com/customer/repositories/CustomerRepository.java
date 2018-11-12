package br.com.customer.repositories;

import br.com.customer.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findByCpf(final String cpf);
}
