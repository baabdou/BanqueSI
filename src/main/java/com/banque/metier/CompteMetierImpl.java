package com.banque.metier;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banque.dao.CompteRepository;
import com.banque.entities.Compte;

@Service
public class CompteMetierImpl implements CompteMetier{
	@Autowired
	private CompteRepository compteRepository;

	@Override
	public Optional<Compte> getComptes(String code) {
		return compteRepository.findById(code);
	}

	@Override
	public Compte saveCompte(Compte c) {
		c.setDateCreation(new Date());
		return compteRepository.save(c);
	}

}
