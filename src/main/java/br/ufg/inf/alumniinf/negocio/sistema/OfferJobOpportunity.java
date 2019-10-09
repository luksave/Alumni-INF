package br.ufg.inf.alumniinf.negocio.sistema;

import br.ufg.inf.alumniinf.utils.model.bean.ExternalUser;
import br.ufg.inf.alumniinf.utils.model.bean.JobOpportunity;
import br.ufg.inf.alumniinf.utils.model.dao.JobOpportunityDAO;

public class OfferJobOpportunity {

	public static void main(ExternalUser user) {
		
		String title     = "Desenvolvedor Java";
		String city      = "Goiânia"; 
		String formation = "Graduação em Engenharia de Software, Ciência da Computação, ou Sistemas de Informação";
		String skils     = "Java e Pacote office";
		String minVal    = "1000.0"; 
		String maxVal    = "2000.0"; 
		
		
		double minSal = Double.valueOf(minVal);
		double maxSal = Double.valueOf(maxVal);
		
		if(formation == "\n") formation = null;
		
		if(minVal == "\n") minSal = 0;
		if(maxVal == "\n") maxSal = 0;

		
		JobOpportunity    opportunity    = new JobOpportunity(title, city, formation, skils, minSal, maxSal);
		JobOpportunityDAO daoOpportunity = new JobOpportunityDAO();
		
		daoOpportunity.create(opportunity, user.getCNPJ());

		System.out.println("Oportunidade de emprego cadastrada: \n" +opportunity.getDescriptiveTitle() + " - "
																	+opportunity.getActingCity()       + "\nFormação exigida: "
																	+opportunity.getAcademicFormation()+ "\nHabilidades necessárias: "
																	+opportunity.getSkils()            + "\nFaixa salarial: "
																	+opportunity.getSalaryRange());
		
	}
	

}

