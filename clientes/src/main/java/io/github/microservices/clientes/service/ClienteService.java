package io.github.microservices.clientes.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import io.github.microservices.clientes.domain.Cliente;
import io.github.microservices.clientes.infra.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
	
	private final ClienteRepository clienteRepository;
	
	

	
	public Cliente clienteSave(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	
	public Optional<Cliente> getByCpf(String cpf){
		return clienteRepository.getByCpf(cpf);
		
		
	}
}
