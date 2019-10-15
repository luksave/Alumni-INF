package br.ufg.inf.alumniinf.services;

import br.ufg.inf.alumniinf.persistence.model.UserDAO;
import br.ufg.inf.alumniinf.persistence.model.bean.ExternalUser;

public class RegisterExternalUser {
	public static ExternalUser main(String fullName, String razaoSoc,  int CPF, int CNPJ, 
			                        String email,    String tellphone, String represented) {
		
		ExternalUser user = new ExternalUser(fullName, razaoSoc, CPF, CNPJ, email, tellphone, represented);
		UserDAO   daoUser = new UserDAO();
		
		daoUser.create(user);
		
		// TODO - Trocar por métodos de acesso a BD.
		System.out.println("Usuário externo cadastrado: " +user.getFullName()    + " - "
														  +user.getRazaoSocial() + " - "
													      +user.getCPF()         + " - "
													      +user.getCNPJ()        + " - "
													      +user.getEmail()       + " - "
													      +user.getTellphone()   + ".  ");
		
		return user;
		
	}
	
}
