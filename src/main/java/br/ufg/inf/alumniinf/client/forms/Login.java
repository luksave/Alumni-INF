package br.ufg.inf.alumniinf.client.forms;

import java.util.Scanner;

import br.ufg.inf.alumniinf.dao.model.UserDAO;
import br.ufg.inf.alumniinf.persistence.model.bean.ExternalUser;

public class Login {

	static Scanner scanner = new Scanner(System.in);
	
	public static ExternalUser realizeLogin(){
		
		UserDAO daoUser = new UserDAO();
		
		System.out.print("Usuário: ");
		//String user = "Lucas FelipL87";
		String userName = scanner.nextLine();
		
		System.out.print("Senha: ");
		//String pass = "WhQjq_p+Nl";
		String userPass = scanner.nextLine();

		scanner.close();
		
		ExternalUser user = daoUser.loginExternalUser(userName, userPass);
		
		return user;
		
	}
	
}
