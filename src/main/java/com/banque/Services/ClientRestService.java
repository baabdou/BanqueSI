package com.banque.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banque.entities.Client;
import com.banque.metier.ClientMetier;

@RestController
public class ClientRestService {
	@Autowired
	private ClientMetier clientMetier;
	
	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public List<Client> listeClients() {
		return clientMetier.listeClients();
	}
	@RequestMapping(value = "/clients", method = RequestMethod.POST)
	public Client saveClient(@RequestBody Client c) {
		return clientMetier.saveClient(c);
	}
	
	
}
