package com.market.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.model.Cliente;
import com.market.repository.ClienteRepository;
@Service
public class ClientesServicesImpl implements ClientesService {

	@Autowired
	ClienteRepository ClientesRepository;
	@Override
	public Cliente autentificarCliente(String usuario, String password) {
		
		return ClientesRepository.findByUsuarioAndPassword(usuario, password);
	}

	@Override
	public boolean registrarCliente(Cliente cliente) {
		
		if(ClientesRepository.findById(cliente.getUsuario()).isPresent())
		{
			return false;
		}
		ClientesRepository.save(cliente);
		return true;
		
	}

}
