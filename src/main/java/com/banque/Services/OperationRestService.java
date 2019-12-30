package com.banque.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banque.metier.OperationMetier;
import com.banque.metier.PageOperation;

@RestController
public class OperationRestService {
	
	@Autowired
	private OperationMetier om;
	
	@RequestMapping(value = "/operations", method = RequestMethod.GET)
	public PageOperation getOperation(@RequestParam String codeCompte, 
			@RequestParam int page, @RequestParam int size) {
		return om.getOperation(codeCompte, page, size);
	}

	@RequestMapping(value = "/versement", method = RequestMethod.PUT)
	public boolean verser(@RequestParam String code, 
			@RequestParam double montant, @RequestParam Long codeEmp) {
		return om.verser(code, montant, codeEmp);
	}
	
	@RequestMapping(value = "/retrait", method = RequestMethod.PUT)
	public boolean retirer(@RequestParam String code, 
			@RequestParam double montant, @RequestParam Long codeEmp) {
		return om.retirer(code, montant, codeEmp);
	}
	
	@RequestMapping(value = "/virement", method = RequestMethod.PUT)
	public boolean virer(@RequestParam String cpte1, 
			@RequestParam String cpte2, 
			@RequestParam double montant, 
			@RequestParam Long codeEmp) {
		return om.virer(cpte1, cpte2, montant, codeEmp);
	}
}
