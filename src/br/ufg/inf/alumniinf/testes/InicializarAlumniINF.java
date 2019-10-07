package br.ufg.inf.alumniinf.testes;

import br.ufg.inf.alumniinf.negocio.autenticacao.Login;
import br.ufg.inf.alumniinf.negocio.autenticacao.Register;
import br.ufg.inf.alumniinf.negocio.sistema.OfferJobOpportunity;



public class InicializarAlumniINF {

	// Teste: Realizar o cadastro de um usuário, logar o usuário e 
	// realizar o cadastro de uma oportunidade de emprego
	public static void main(String[] args) {
		
		Register.main();
		
		if(Login.realizarLogin()){
			System.out.println("\n----------- LOGADO -----------");
			OfferJobOpportunity.main();

		}else{
			System.out.println("\n------- Falha no Login -------");
			
		}		
	
	}

}
