package br.ufg.inf.alumniinf.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufg.inf.alumniinf.persistence.model.JobOpportunityDAO;

public class ListJobOpportunity {

	public static void main(String city) {
		
		JobOpportunityDAO daoOpportunity = new JobOpportunityDAO();
		
		// O rs recebe uma lista de oportunidades na cidade parâmetro
		ResultSet rsOp = daoOpportunity.findOpportunity(city);
		
		try {
			while(rsOp.next()){
				
				System.out.println("Oportunidade: " +rsOp.getString("title") +" em " +rsOp.getString("actingCity") +".\n");
				
				if(rsOp.getDouble("minSalary") != 0.0 && rsOp.getDouble("maxSalary") != 0.0)	
																System.out.println("Faixa salarial: R$" +rsOp.getDouble("minSalary") +" ~ " 
				                                            											+rsOp.getDouble("maxSalary") +".\n");
				
				else											System.out.println("Faixa salarial não informada.\n");
				
				
				// O rs recebe uma lista de atividades para a oportunidade listada
				try {
					ResultSet rsAc = daoOpportunity.findOpportunityActivities(rsOp.getInt("idJobOpportunity"));
					
					System.out.println("Atividades a desempenhar: ");
					
					while(rsAc.next()){
						System.out.println(rsAc.getString("description") +" - ");
						
					}
					
				} catch (SQLException e) {
					System.out.println("Erro ao ler Result Set de Activities: " +e);
					
				}
				
				
				// O rs recebe uma lista de habilidades para a oportunidade listada
				try {
					ResultSet rsSk = daoOpportunity.findOpportunitySkills(rsOp.getInt("idJobOpportunity"));
					
					System.out.println("Habilidades desejáveis: ");
					
					while(rsSk.next()){
						System.out.println(rsSk.getString("description") +" - ");
						
					}
					
				} catch (SQLException e) {
					System.out.println("Erro ao ler Result Set de Skills: " +e);
					
				}
				
				
				// O rs recebe uma lista de formações para a oportunidade listada
				try {
					ResultSet rsFo = daoOpportunity.findOpportunityFormation(rsOp.getInt("idJobOpportunity"));
					
					System.out.println("Formação necessária: ");
					
					while(rsFo.next()){
						System.out.println(rsFo.getString("description") +" - ");
						
					}
					
				} catch (SQLException e) {
					System.out.println("Erro ao ler Result Set de Formation: " +e);
					
				}
				
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao ler Result Set de JobOpportunity: " +e);
			
		}
		
	}

}
