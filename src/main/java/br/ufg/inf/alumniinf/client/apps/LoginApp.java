package br.ufg.inf.alumniinf.client.apps;

import java.util.Scanner;

import br.ufg.inf.alumniinf.client.forms.Login;
import br.ufg.inf.alumniinf.persistence.model.bean.JobOpportunity;
import br.ufg.inf.alumniinf.persistence.model.bean.User;
import br.ufg.inf.alumniinf.services.ListJobOpportunity;
import br.ufg.inf.alumniinf.services.OfferJobOpportunity;

public class LoginApp {

	private static Scanner scanner;
	
	public static void main(String[] args) {
		System.out.println("1 - Realizar Login\n"
				  		  +"0 - Sair do sistema\n: ");

		int option = scanner.nextInt();
		
		if(option == 1){
			User user = Login.realizeLogin();
		
			if(user.getType() == "alumnus"){
				System.out.println("Escolha a opção"
								  +"1 - Listar oportunidade\n"
								  +"0 - Sair do sistema\n:");
				
				option = scanner.nextInt();
				
				if(option == 1){
					System.out.println("Lista de Oportunidades:\n");
					ListJobOpportunity.main("Goiania");
					
				} else{
					scanner.close();
					System.exit(0);
				
				}
				
			}
			
			if(user.getType() == "external"){
				System.out.println("Escolha a opção"
				  				  +"1 - Oferecer oportunidade\n"
								  +"0 - Sair do sistema\n:");
				
				option = scanner.nextInt();
		
				if(option == 1){
					String title      = "Web Developer";
					String city       = "Goiânia";
					String minVal     = "1000.0"; 
					String maxVal     = "2000.0"; 
					double minSal = Double.valueOf(minVal);
					double maxSal = Double.valueOf(maxVal);

					//Transformar em Array os seguintes:
					String formation[]  = {"Graduação em Engenharia de Software", "Ciência da Computação", "Sistemas de Informação"};
					String skills[]     = {"JavaScript", "WordPress", "HTML5", "CSS","jQuery", "PHP", "Bootstrap", "Putty", "SSH"};
					String activities[] = {"Desenvolvimento Técnico", "Desenvolvimento Visual", "Manutenção de Sites"};		
					
				    // Verificar se o array está vazio
					if(formation.length == 0) formation = null;
					
					if(minVal == "\n") minSal = 0;
					if(maxVal == "\n") maxSal = 0;
					
					JobOpportunity jobOpportunity = new JobOpportunity(title, city, formation, skills, activities, minSal, maxSal);
					
					OfferJobOpportunity.main(user, jobOpportunity);
					
				} else{
					scanner.close();
					System.exit(0);
					
				}
				
			}
			
		
		} else{
			scanner.close();
			System.exit(0);
			
		} 

	}

}
