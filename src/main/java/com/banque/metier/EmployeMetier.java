package com.banque.metier;

import java.util.List;

import com.banque.entities.Employe;

public interface EmployeMetier {

	public List<Employe> listeEmployes();
	public Employe saveEmploye(Employe e);
}
