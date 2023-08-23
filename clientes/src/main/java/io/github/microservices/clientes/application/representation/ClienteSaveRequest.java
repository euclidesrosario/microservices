package io.github.microservices.clientes.application.representation;

import io.github.microservices.clientes.domain.Cliente;
import lombok.Data;

@Data
public class ClienteSaveRequest {
	private Long id;
	private String cpf;
	private String nome;
	private Integer idade;
	
	public Cliente toModel () {
		return new Cliente(cpf, nome, idade);
		
	}
	
	

}
