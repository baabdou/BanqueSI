package com.banque.metier;

import java.util.Date;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banque.dao.CompteRepository;
import com.banque.dao.EmployeRepository;
import com.banque.dao.OperationRepository;
import com.banque.entities.Compte;
import com.banque.entities.Employe;
import com.banque.entities.Operation;
import com.banque.entities.Retrait;
import com.banque.entities.Versement;

@Service
public class OperationMetierImpl implements OperationMetier {

	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private EmployeRepository employeRepository;
	
	@Override
	@Transactional
	public boolean verser(String code, double montant, Long codeEmp) {
//		Optional<Compte> c = compteRepository.findById(code);
		Compte c = compteRepository.getOne(code);
//		Optional<Employe> emp = employeRepository.findById(codeEmp);
		Employe emp = employeRepository.getOne(codeEmp);
		Operation o = new Versement();
		o.setDateOperation(new Date());
		o.setCompte(c);
		o.setEmploye(emp);
		o.setMontant(montant);
		operationRepository.save(o);
		c.setSolde(c.getSolde() + montant);
		
		return true;
	}

	@Override
	@Transactional
	public boolean retirer(String code, double montant, Long codeEmp) {
//		Optional<Compte> c = compteRepository.findById(code);
		Compte c = compteRepository.getOne(code);
		if(c.getSolde() < montant) throw new RuntimeException("Solde Insufisant");
//		Optional<Employe> emp = employeRepository.findById(codeEmp);
		Employe emp = employeRepository.getOne(codeEmp);
		Operation o = new Retrait();
		o.setDateOperation(new Date());
		o.setCompte(c);
		o.setEmploye(emp);
		o.setMontant(montant);
		operationRepository.save(o);
		c.setSolde(c.getSolde() - montant);
		
		return true;
	}

	@Override
	@Transactional
	public boolean virer(String cpte1, String cpte2, double montant, Long codeEmp) {
		retirer(cpte1, montant, codeEmp);
		verser(cpte2, montant, codeEmp);
		return true;
	}

	@Override
	public PageOperation getOperation(String codeCompte, int page, int size) {
		Page<Operation> ops = operationRepository.getOperations(codeCompte, PageRequest.of(page, size));
		
		PageOperation pop = new PageOperation();
		pop.setOperations(ops.getContent());
		pop.setNombreOperations(ops.getNumberOfElements());
		pop.setPage(ops.getNumber());
		pop.setTotalPage(ops.getTotalPages());
		pop.setTotalOperation((int) ops.getTotalElements());
		return pop;
	}

}
