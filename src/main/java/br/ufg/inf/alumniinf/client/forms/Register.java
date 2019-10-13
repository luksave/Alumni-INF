package br.ufg.inf.alumniinf.client.forms;

import br.ufg.inf.alumniinf.dao.model.UserDAO;
import br.ufg.inf.alumniinf.persistence.model.bean.ExternalUser;
import br.ufg.inf.alumniinf.persistence.model.bean.User;

public class Register {

	public  static int registerQuantity = 0;
	
	public static void main(int type) {
		
		if(type == 1){
			System.out.println("Registro de usuário");
			
			String fullName  = "Lucas Felipe"; 
			int    CPF       =  219389384;
			String email     = "lucasfelipems@gmail.com";
			String tellphone = "01290494029";
			
			User normalUser = new User(fullName, CPF, email, tellphone, false);
			UserDAO daoUser = new UserDAO();
			
			daoUser.create(normalUser);
			
			// TODO - Trocar por métodos de acesso a BD.
			System.out.println("Usuário cadastrado: " +normalUser.getFullName()    + " - "
												      +normalUser.getCPF()         + " - "
												      +normalUser.getEmail()       + " - "
												      +normalUser.getTellphone()   + ".  ");
			
			registerQuantity++;

		}else{
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
	
}
