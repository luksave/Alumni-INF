package br.ufg.inf.alumniinf.app;

import java.util.Scanner;

import br.ufg.inf.alumniinf.client.forms.Login;
import br.ufg.inf.alumniinf.client.forms.Register;
import br.ufg.inf.alumniinf.persistence.model.bean.User;
import br.ufg.inf.alumniinf.services.OfferJobOpportunity;



public class Main {

	// Teste: Realizar o cadastro de um usuário, logar o usuário e 
	// realizar o cadastro de uma oportunidade de emprego
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		//TODO - Criar lógica de interface para registro e login de usuários
		// Recuperar o tipo do usuário na hora do login para que este possa realizar diferentes operações
				
		//Tentativa de Cadastro de usuário
		System.out.println("Cadastro de usuário\n"
							+"1 - Usuário normal\n"
							+"2 - Usuário externo\n:");
		
		int option = scanner.nextInt();
		Register.main(option);

		//Tentativa de Cadastro de login
		System.out.println("1 - Realizar Login\n"
						  +"2 - Sair do sistema\n:");
		
		option = scanner.nextInt();
		
		if(option == 1){
			User user = Login.realizeLogin();
		
			if(!user.isExternal()){
				System.out.println("Escolha a opção"
								  +"1 - Consultar oportunidade\n"
								  +"2 - Sair do sistema\n:");
				
				option = scanner.nextInt();
				
				
			}else{
				System.out.println("Escolha a opção"
						  		+"1 - Oferecer oportunidade\n"
						  		+"2 - Sair do sistema\n:");

				option = scanner.nextInt();
				
				
			}
	
		}else{
			System.exit(0);
			
		}
			
			 	

		//Tentativa de Cadastro de oportunidade
		//	Passa como argumento um usuário externo
		//  Deixar OfferJobOpportunity.main(user); dentro de uma das telas de login
	
		scanner.close();
		
	}

}
