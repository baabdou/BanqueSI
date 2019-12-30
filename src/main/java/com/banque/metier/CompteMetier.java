package com.banque.metier;

import java.util.List;
import java.util.Optional;

import com.banque.entities.Compte;

public interface CompteMetier {
	public Optional<Compte> getComptes(String code);
	public Compte saveCompte(Compte c);
}
