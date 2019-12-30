package com.banque.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banque.dao.ClientRepository;
import com.banque.entities.Client;

@Service
public class ClientMetierImpl implements ClientMetier {
	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public List<Client> listeClients() {
		return clientRepository.findAll();
	}

	@Override
	public Client saveClient(Client c) {
		return clientRepository.save(c);
	}

}
