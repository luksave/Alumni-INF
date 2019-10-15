package br.ufg.inf.alumniinf.persistence.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufg.inf.alumniinf.persistence.connection.ConnectionFactory;
import br.ufg.inf.alumniinf.persistence.model.bean.JobOpportunity;

public class JobOpportunityDAO {
	
	// Cria um usuário no BD.
	public void createOpportunity(JobOpportunity job, int ID){
	
		Connection        con  = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;		
		ResultSet         rs   = null;

		// Insert para oportunidade
		try {
			stmt = con.prepareStatement("INSERT INTO jobOpportunity (title, actingCity, minSalary, maxSalary, offererID)"
												           + "VALUES(?,     ?,          ?,         ?,         ?        )");
		
			stmt.setString(1, job.getDescriptiveTitle());
			stmt.setString(2, job.getActingCity());
			stmt.setDouble(3, job.getMinSalary());
			stmt.setDouble(4, job.getMaxSalary());
			stmt.setInt   (5, ID);
			
			stmt.executeUpdate();
				
			System.out.println("Salvo com sucesso");
			
		} catch (SQLException e) {
			System.out.println("Erro ao salvar oportunidade. " +e);
			
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
			
		}
		
		
		// Select para recuperar o id da oportunidade que acaba de ser inserida
		try {
			stmt = con.prepareStatement("SELECT idJobOpportunity FROM jobOpportunity WHERE offererID = " +ID);
			rs   = stmt.executeQuery();
			
		} catch (SQLException e) {
			System.out.println("Erro ao recuperar id da oportunidade cadastrada. " +e);

		}

		
		// Insert para skills
		try {
			String[] skills = job.getSkills();
			
			for(String str : skills){
				stmt = con.prepareStatement("INSERT INTO Skills (idOpportunity, description)"
						   + "VALUES(?,             ?          )");

				stmt.setInt   (1, rs.getInt("idJobOpportunity"));
				stmt.setString(2, str);
				
				stmt.executeUpdate();
				
				System.out.println("Salvo com sucesso");
				
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao salvar habilidade. " +e);
			
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
			
		}
		
		
		// Insert para formation
		try {
			String[] formation = job.getAcademicFormation();
			
			for(String str : formation){
				stmt = con.prepareStatement("INSERT INTO Formation (idOpportunity, description)"
					      + "VALUES(?,             ?          )");

				stmt.setInt   (1, rs.getInt("idJobOpportunity"));
				stmt.setString(2, str);
				
				stmt.executeUpdate();
				
				System.out.println("Salvo com sucesso");
				
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao salvar habilidade. " +e);
			
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
			
		}
		
		
		// Insert para activities
		try {
			String[] activities = job.getActivities();
			
			for(String str : activities){
				stmt = con.prepareStatement("INSERT INTO Activities (idOpportunity, description)"
													       + "VALUES(?,             ?          )");
				
				stmt.setInt   (1, rs.getInt("idJobOpportunity"));
				stmt.setString(2, str);
			
				stmt.executeUpdate();
				
				System.out.println("Salvo com sucesso");
				
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao salvar habilidade. " +e);
			
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
			
		}
		
	}
	
	//Retorna uma lista de oportunidades de acordo com a cidade de atuação
	public ResultSet findOpportunity(String city){

		Connection        con  = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet         rs   = null;
		
		try {
			stmt = con.prepareStatement("SELECT title, actingCity, minSalary, maxSalary FROM jobOpportunity WHERE actingCity = " +city);
			
			rs = stmt.executeQuery();
			
			System.out.println("Recuperado com sucesso");
			
			return rs;
			
		} catch (SQLException e) {
			System.out.println("Erro ao consultar oportunidades. " +e);
			
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
			
		}
		
		return null;
		
	}
	
	
	//Retorna a lista de habilidades para uma oportunidade de acordo com a id da oportunidade
	public ResultSet findOpportunitySkills(int id){

		Connection 		  con  = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet         rs   = null;
		
		try {
			stmt = con.prepareStatement("SELECT description FROM Skills WHERE idOpportunity = " +id);
			
			rs = stmt.executeQuery();
			
			System.out.println("Recuperado com sucesso");
			
			return rs;
			
		} catch (SQLException e) {
			System.out.println("Erro ao consultar habilidades necessárias. " +e);
			
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
			
		}
		
		return null;
		
	}
	
	
	//Retorna a lista de habilidades para uma oportunidade de acordo com a id da oportunidade
	public ResultSet findOpportunityFormation(int id){

		Connection 		  con  = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet         rs   = null;
		
		try {
			stmt = con.prepareStatement("SELECT description FROM Formation WHERE idOpportunity = " +id);
			
			rs = stmt.executeQuery();
			
			System.out.println("Recuperado com sucesso");
			
			return rs;
			
		} catch (SQLException e) {
			System.out.println("Erro ao consultar formação necessária. " +e);
			
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
			
		}
		
		return null;
		
	}
	
	
	//Retorna a lista de atividades para uma oportunidade de acordo com a id da oportunidade
		public ResultSet findOpportunityActivities(int id){

			Connection 		  con  = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			ResultSet         rs   = null;
			
			try {
				stmt = con.prepareStatement("SELECT description FROM Activities WHERE idOpportunity = " +id);
				
				rs = stmt.executeQuery();
				
				System.out.println("Recuperado com sucesso");
				
				return rs;
				
			} catch (SQLException e) {
				System.out.println("Erro ao consultar formação necessária. " +e);
				
			} finally {
				ConnectionFactory.closeConnection(con, stmt);
				
			}
			
			return null;
			
		}
	
}
