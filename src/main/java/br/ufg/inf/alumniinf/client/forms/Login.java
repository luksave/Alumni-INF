package br.ufg.inf.alumniinf.client.forms;

import java.util.Scanner;

import br.ufg.inf.alumniinf.persistence.model.UserDAO;
import br.ufg.inf.alumniinf.persistence.model.bean.AlumnusUser;
import br.ufg.inf.alumniinf.persistence.model.bean.ExternalUser;
import br.ufg.inf.alumniinf.persistence.model.bean.User;
import br.ufg.inf.alumniinf.services.LoginUser;

public class Login {

	static Scanner scanner = new Scanner(System.in);

	static AlumnusUser  userA;
	static ExternalUser userE;
	
	public static User realizeLogin(){
		
		System.out.print("Usuário: ");
		String userName = scanner.nextLine();
		
		System.out.print("Senha: ");
		String userPass = scanner.nextLine();

		scanner.close();
		
		String type = LoginUser.login(userName, userPass);
		
		System.out.println("Tipo logado: " +type);
		
		if(type == "alumnus"){
			userA = UserDAO.loginAlumnusUser (userName, userPass);
			System.out.println("Usuário atual: " + userA.getUserName());
		
		}  
		
		if(type == "external"){
			userE = LoginUser.loginExternal(userName, userPass);
			System.out.println("Usuário atual: " + userE.getUserName());
		
		} 

		return null;
		
	}
	
}
