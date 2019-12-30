package com.banque.metier;

public interface OperationMetier {
	
	public boolean verser(String code, double montant, Long codeEmp);
	public boolean retirer(String code, double montant, Long codeEmp);
	public boolean virer(String cpte1, String cpte2, double montant, Long codeEmp);
	public PageOperation getOperation(String codeCompte, int page, int size);
}
