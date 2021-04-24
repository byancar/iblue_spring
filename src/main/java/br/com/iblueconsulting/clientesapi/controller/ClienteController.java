package br.com.iblueconsulting.clientesapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iblueconsulting.clientesapi.dao.ClienteDao;
import br.com.iblueconsulting.clientesapi.entity.Cliente;
import br.com.iblueconsulting.clientesapi.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/clientes")
@Tag(name="Clientes", description="API de gerenciamento de Clientes.")

public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
    @Operation(summary = "Retorna a lista de clientes", description = "Name search by %name% format", tags = { "todos_clientes" })
	@GetMapping("/")
	public List<Cliente> getAllClientes(){
		return clienteService.getAllClientes();
	}
	
	@GetMapping("/email/{email}")
	public Cliente getByEmail(@PathVariable("email") String email){
		return clienteService.getByEmail(email);	
	}
	
	@PostMapping
	public ClienteDao saveCliente(@RequestBody ClienteDao cliente){
		return clienteService.saveCliente(cliente);		
	}
	
	@PutMapping
	public ClienteDao updateCliente(@RequestBody ClienteDao cliente){
		return clienteService.updateCliente(cliente);		
	}
	
	@DeleteMapping
	public ClienteDao deleteCliente(@RequestBody ClienteDao cliente){
		return clienteService.deleteCliente(cliente);	
	}

}
