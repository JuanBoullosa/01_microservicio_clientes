package com.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market.Service.ClientesService;
import com.market.model.Cliente;

@RestController
public class ClientesController {

	@Autowired
	ClientesService  clientesService;
	
	
	@GetMapping(value="autenticar", produces = MediaType.APPLICATION_JSON_VALUE)
	/*le dice que lo vamos a llamar autenticar y lo pasa como json para que lo lea el frontend*/
	public Cliente autenticar (@RequestParam("usuario") String usuario,@RequestParam("password")  String password)
	{
		return clientesService.autentificarCliente(usuario, password);
		
	}
	
	@PostMapping(value="registrar", consumes= MediaType.APPLICATION_JSON_VALUE )
	//consumes es para ver en que formato viene desde las ventanas.
	public ResponseEntity<Void> registrar (@RequestBody Cliente cliente)
	{
		if(clientesService.registrarCliente(cliente))
		{
			return new ResponseEntity<> (HttpStatus.OK);		
		}else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
}
