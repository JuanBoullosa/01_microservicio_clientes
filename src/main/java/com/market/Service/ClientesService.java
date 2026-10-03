package com.market.Service;

import com.market.model.Cliente;

public interface ClientesService {

	Cliente autentificarCliente(String usuario, String password);
	boolean registrarCliente(Cliente cliente);
	

}
