package com.banque.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banque.dao.EmployeRepository;
import com.banque.entities.Employe;

@Service
public class EmployeMetierImpl implements EmployeMetier {
	@Autowired
	private EmployeRepository employeReposiotory;

	@Override
	public List<Employe> listeEmployes() {
		return employeReposiotory.findAll();
	}

	@Override
	public Employe saveEmploye(Employe e) {
		return employeReposiotory.save(e);
	}

}
