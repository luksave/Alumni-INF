package br.ufg.inf.alumniinf.services;

import java.util.Date;

import br.ufg.inf.alumniinf.persistence.model.UserDAO;
import br.ufg.inf.alumniinf.persistence.model.bean.AlumnusUser;

public class RegisterAlumnusUser {
	
		public static AlumnusUser main(String fullName,  int CPF,          String email,    
				                       String tellphone, int registration, Date   birth) {
	
		AlumnusUser user  = new AlumnusUser(fullName, CPF, email, tellphone, "alumnus", registration, birth);
		UserDAO   daoUser = new UserDAO();
		
		daoUser.create(user);
		
		// TODO - Trocar por métodos de acesso a BD.
		System.out.println("Usuário ex-aluno cadastrado: " +user.getFullName()     + " - "
													       +user.getCPF()          + " - "
													       +user.getEmail()        + " - "
													       +user.getRegistration() + " - "
													       +user.getBirthDate()    + " - "
													       +user.getTellphone()    + ".  ");
		
		return user;
		
	}
}
