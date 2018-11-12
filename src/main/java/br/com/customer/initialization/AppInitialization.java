package br.com.customer.initialization;

import br.com.customer.exception.CustomerException;
import br.com.customer.model.Customer;
import br.com.customer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppInitialization implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws CustomerException {
        createCustomers();
    }

    /**
     * Cria 4 Customers
     */
    private void createCustomers() {

        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Customer customer3 = new Customer();
        Customer customer4 = new Customer();

        //Customer 1
        customer1.setName("José silva");
        customer1.setBirth("20/02/2005");
        customer1.setCpf("56557582020");
        customer1.setHeight("1.90");
        customer1.setMotherName("Maria Francisca");
        customer1.setWeight("78.920");
        customer1.setPhones("+55 11 92234-2323");

        //Customer 2
        customer2.setName("Keuli Saypi");
        customer2.setBirth("04/04/1990");
        customer2.setCpf("69177644000");
        customer2.setHeight("1.76");
        customer2.setMotherName("Receo Bluon");
        customer2.setWeight("67.765");
        customer2.setPhones("+55 11 92234-2323");

        //Customer 3
        customer3.setName("Giunmuir Dohar");
        customer3.setBirth("10/12/1989");
        customer3.setCpf("11257798022");
        customer3.setHeight("1.89");
        customer3.setMotherName("Syuhe Anvair");
        customer3.setWeight("90.345");
        customer3.setPhones("+55 11 92234-2323");

        //Customer 4
        customer4.setName("Anaskoka Vecluco");
        customer4.setBirth("16/11/1960");
        customer4.setCpf("57334227000");
        customer4.setHeight("1.65");
        customer4.setMotherName("Geapa Undo");
        customer4.setWeight("54.890");
        customer4.setPhones("+55 11 92234-2323");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
    }

}
