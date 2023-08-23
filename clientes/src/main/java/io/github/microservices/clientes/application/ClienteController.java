package io.github.microservices.clientes.application;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.github.microservices.clientes.application.representation.ClienteSaveRequest;
import io.github.microservices.clientes.service.ClienteService;

@RestController
@RequestMapping("clientes")
public class ClienteController {

	private ClienteService clienteService;

	public String status() {
		return "Ok";

	}

	public ResponseEntity<?> save(@RequestBody ClienteSaveRequest request) {

		var cliente = request.toModel();
		clienteService.clienteSave(cliente);
		URI headerLocation = ServletUriComponentsBuilder.fromCurrentRequest().query("cpf	={cpf}")
				.buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(headerLocation).build();

	}
	
	
	public ResponseEntity <?>dadosDoCliebte(@RequestParam("cpf") String cpf) {
		var cliente = clienteService.getByCpf(cpf);
		if(cliente.isEmpty()) {
			return  ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(cliente);
		}
		
		
		
		
	}

}
