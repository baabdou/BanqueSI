package com.banque.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banque.entities.Compte;
import com.banque.metier.CompteMetier;

@RestController
public class CompteRestService {
	
	@Autowired
	private CompteMetier compteMetier;

	@RequestMapping(value = "/compte/{code}", method = RequestMethod.GET)
	public Optional<Compte> getComptes(@PathVariable String code) {
		return compteMetier.getComptes(code);
	}
	
	@RequestMapping(value = "/compte", method = RequestMethod.POST)
	public Compte saveCompte(@RequestBody Compte c) {
		return compteMetier.saveCompte(c);
	}
	
	
}
