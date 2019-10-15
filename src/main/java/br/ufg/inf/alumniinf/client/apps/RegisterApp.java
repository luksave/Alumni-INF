package br.ufg.inf.alumniinf.client.apps;

import java.util.Scanner;

import br.ufg.inf.alumniinf.client.forms.Register;

public class RegisterApp {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		System.out.println("Cadastro de usuário\n"
							+"1 - Para usuário ex-aluno\n"
							+"2 - Para usuário externo\n"
							+"0 - Sair do Sistema\n: ");
		
		int option = scanner.nextInt();
		
		if(option == 0){
			scanner.close();
			System.exit(0);
			
		}else{
			scanner.close();
			Register.main(option);
			
		} 
		
	}

}
