package br.ufg.inf.alumniinf.client.forms;

import java.util.Scanner;

import br.ufg.inf.alumniinf.persistence.model.bean.User;
import br.ufg.inf.alumniinf.services.LoginUser;

public class Login {

	static Scanner scanner = new Scanner(System.in);
	
	public static User realizeLogin(){
		
		System.out.print("Usuário: ");
		String userName = scanner.nextLine();
		
		System.out.print("Senha: ");
		String userPass = scanner.nextLine();

		scanner.close();
		
		User user = LoginUser.main(userName, userPass);
		
		return user;
		
	}
	
}
