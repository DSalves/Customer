package br.com.customer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity(name = "Customer")
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome não pode ser vazio ou nulo!")
    @Size(min = 4, max = 40, message = "Nome informado inválido!")
    private String name;

    @NotBlank(message = "Favor informar a data de nascimento!")
    @Size(min = 10, max = 10, message = "Favor informar uma data de nascimento no formato dd/MM/yyyy")
    private String birth;

    @NotBlank(message = "Favor informar o CPF!")
    @CPF(message = "CPF informado é inválido!")
    private String cpf;

    @NotBlank(message = "Favor informar o nome da mãe!")
    @Size(min = 4, max = 40, message = "Nome informado inválido!")
    private String motherName;

    @NotBlank(message = "Favor informar a altura!")
    private String height;

    @NotBlank(message = "Favor informar o peso!")
    private String weight;

    @NotBlank(message = "Favor informar ao menos 1 numero de telefone!")
    private String phones;

}
