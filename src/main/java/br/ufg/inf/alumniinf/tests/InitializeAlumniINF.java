package br.ufg.inf.alumniinf.tests;

import br.ufg.inf.alumniinf.negocio.autenticacao.Login;
import br.ufg.inf.alumniinf.negocio.autenticacao.Register;
import br.ufg.inf.alumniinf.negocio.sistema.OfferJobOpportunity;
import br.ufg.inf.alumniinf.utils.model.bean.ExternalUser;



public class InitializeAlumniINF {

	// Teste: Realizar o cadastro de um usuário, logar o usuário e 
	// realizar o cadastro de uma oportunidade de emprego
	public static void main(String[] args) {
		
		//Tentativa de Cadastro de usuário
		Register.main();
		
		//Tentativa de Login
		//	Sucesso: Retorna usuário
		ExternalUser user = Login.realizeLogin();

		//Tentativa de Cadastro de oportunidade
		//	Passa como argumento um usuário externo
		OfferJobOpportunity.main(user);
		
	}

}
