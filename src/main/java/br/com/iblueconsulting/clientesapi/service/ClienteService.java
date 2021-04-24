package br.com.iblueconsulting.clientesapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.iblueconsulting.clientesapi.dao.ClienteDao;
import br.com.iblueconsulting.clientesapi.entity.Cliente;
import br.com.iblueconsulting.clientesapi.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> getAllClientes(){
		return clienteRepository.findAll(); 	
	}

	public Cliente getByEmail(String email) {
		Optional<Cliente> cliente = clienteRepository.findByEmail(email);
		
		if(cliente.isPresent()) {
			return cliente.get();
		}else {
			return new Cliente();
		}
	}

	public ClienteDao saveCliente(ClienteDao cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	public ClienteDao updateCliente(ClienteDao cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	public ClienteDao deleteCliente(ClienteDao cliente) {
		// TODO Auto-generated method stub
		return null;
	}


}
