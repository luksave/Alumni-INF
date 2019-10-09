package br.ufg.inf.alumniinf.negocio.autenticacao;

import br.ufg.inf.alumniinf.utils.model.bean.ExternalUser;
import br.ufg.inf.alumniinf.utils.model.dao.UserDAO;

public class Register {

	public  static int registerQuantity = 0;
	
	public static void main() {
		
		System.out.println("Registro de usuário externo");
		
		String fullName  = "Lucas Felipe"; 
		String razaoSoc  = "Luksave C.O";
		int    CPF       =  219389384;
		int    CNPJ      =  910291142;
		String email     = "lucasfelipems@gmail.com";
		String tellphone = "01290494029";
		
		ExternalUser extUser = new ExternalUser(fullName, razaoSoc, CPF, CNPJ, email, tellphone);
		UserDAO      daoUser = new UserDAO();
		
		daoUser.create(extUser);
		
		// TODO - Trocar por métodos de acesso a BD.
		System.out.println("Usuário cadastrado: " +extUser.getFullName()    + " - "
												  +extUser.getRazaoSocial() + " - "
											      +extUser.getCPF()         + " - "
											      +extUser.getCNPJ()        + " - "
											      +extUser.getEmail()       + " - "
											      +extUser.getTellphone()   + ".  ");
		
		registerQuantity++;
		
	}
	
}
