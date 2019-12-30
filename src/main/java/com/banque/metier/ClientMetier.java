package com.banque.metier;

import java.util.List;

import com.banque.entities.Client;

public interface ClientMetier {
	public List<Client> listeClients();
	public Client saveClient(Client c);
}
