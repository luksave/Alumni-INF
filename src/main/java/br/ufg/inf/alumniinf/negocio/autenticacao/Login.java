package br.ufg.inf.alumniinf.negocio.autenticacao;

import java.util.Scanner;

import br.ufg.inf.alumniinf.utils.model.bean.ExternalUser;
import br.ufg.inf.alumniinf.utils.model.dao.UserDAO;

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
