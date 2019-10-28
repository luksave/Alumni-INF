package br.ufg.inf.alumniinf.client.apps;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1 - Cadastro de Usuário\n"
						  +"2 - Login de Usuário\n"
						  +"0 - Sair do Sistema\n:");
		
		
		int option = scanner.nextInt();
		
		if(option == 1) RegisterApp.main(args);
		if(option == 2) LoginApp.main(args);
		else{
						scanner.close();
						System.exit(0);
			
		} 	

		
		
	}

}
