package br.com.customer.controller;

import br.com.customer.model.Customer;
import br.com.customer.service.CustomerService;
import br.com.customer.utils.Constants;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.BASE_URL_API)
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @ApiOperation(value = "Efetuar uma busca por um usuário através de seu cpf")
    @GetMapping("{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomer(@PathVariable String cpf){
        return customerService.getCustomer(cpf);
    }

    @ApiOperation(value = "Salvar um usuário")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@Validated @RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @ApiOperation(value = "Listar todos os usuários salvos")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomers();
    }

    @ApiOperation(value = "Deletar um usuário através do cpf")
    @DeleteMapping("{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public Customer deleteCustomer(@PathVariable String cpf){
        return customerService.deleteCustomer(cpf);
    }

    @ApiOperation(value = "Atualizar dados de um usuário")
    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Customer updateCustomer(@Validated @RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }

}
