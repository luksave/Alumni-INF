package br.ufg.inf.alumniinf.client.apps;

import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	private static int     option;
	
	public static void main(String[] args) {
		
		System.out.println("1 - Cadastro de Usuário\n"
						  +"2 - Login de Usuário\n"
						  +"0 - Sair do Sistema\n:");
		
		option = scanner.nextInt();
		
		if(option == 1) {
			scanner.close();
			RegisterApp.main(args);
			
		}
		
		if(option == 2){
			scanner.close();
			LoginApp.main(args);
			
		} 

		else{
			scanner.close();
			System.exit(0);
			
		} 	

	}

}
