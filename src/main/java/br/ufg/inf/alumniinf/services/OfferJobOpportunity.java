package br.ufg.inf.alumniinf.services;

import br.ufg.inf.alumniinf.persistence.model.JobOpportunityDAO;
import br.ufg.inf.alumniinf.persistence.model.UserDAO;
import br.ufg.inf.alumniinf.persistence.model.bean.ExternalUser;
import br.ufg.inf.alumniinf.persistence.model.bean.JobOpportunity;
import br.ufg.inf.alumniinf.persistence.model.bean.User;

public class OfferJobOpportunity {

	public static void main(User externalUser, JobOpportunity jobOpportunity) {
				
		JobOpportunityDAO daoOpportunity = new JobOpportunityDAO();
		UserDAO                  daoUser = new UserDAO();
		
		ExternalUser exUser = daoUser.getExternalUser(externalUser.getUserName(), externalUser.getPassword());
		
		daoOpportunity.createOpportunity(jobOpportunity, exUser.getID());

		System.out.println("Oportunidade de emprego cadastrada: \n" +jobOpportunity.getDescriptiveTitle() + " - "
																	+jobOpportunity.getActingCity()       + "\nFormação exigida: "
																	+jobOpportunity.getAcademicFormation()+ "\nHabilidades necessárias: "
																	+jobOpportunity.getSkills()            + "\nFaixa salarial: "
																	+jobOpportunity.getSalaryRange());
		
	}
	

}

