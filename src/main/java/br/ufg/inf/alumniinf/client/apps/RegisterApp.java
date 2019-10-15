package br.ufg.inf.alumniinf.client.apps;

import java.util.Scanner;

import br.ufg.inf.alumniinf.client.forms.Register;

public class RegisterApp {

	private static Scanner scanner = new Scanner(System.in);
	private static int     option;
	
	public static void main(String[] args) {
		
		
		System.out.println("Cadastro de usuário\n"
							+"1 - Para usuário ex-aluno\n"
							+"2 - Para usuário externo\n"
							+"0 - Sair do Sistema\n: ");
		
		option = scanner.nextInt();
		
		if(option == 0){
			scanner.close();
			System.exit(0);
			
		}else{
			scanner.close();
			Register.main(option);
			
		} 
		
	}

}
