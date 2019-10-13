package br.ufg.inf.alumniinf.dao.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.ufg.inf.alumniinf.dao.connection.ConnectionFactory;
import br.ufg.inf.alumniinf.persistence.model.bean.JobOpportunity;

public class JobOpportunityDAO {
	// Cria um usuário no BD.
		// A oportunidade de emprego deve vir acompanhada do CNPJ de quem a está criando.
		public void create(JobOpportunity job, int CNPJ){
			
			//Abrir conexão
			Connection con = ConnectionFactory.getConnection();
			
			//Prepara a requisição ao mysql
			PreparedStatement stmt = null;
			
			try {
		
				stmt = con.prepareStatement("INSERT INTO jobOpportunity (title, city, formation, skils, minSalary, maxSalary, offererCNPJ)"
													           + "VALUES(?,     ?,    ?,         ?,     ?,         ?,         ?          )");
				// Define o valor de Title na tabela
				stmt.setString(1, job.getDescriptiveTitle());
				
				// Define o valor de City tabela
				stmt.setString(2, job.getActingCity());
				
				// Define o valor de Formation na tabela	
				stmt.setString(3, job.getAcademicFormation());
				
				// Define o valor de Skils na tabela	
				stmt.setString(4, job.getSkils());
				
				// Define o valor de MinSalary na tabela	
				stmt.setDouble(5, job.getMinSalary());
				
				// Define o valor de MaxSalary na tabela
				stmt.setDouble(6, job.getMaxSalary());

				// Define o valor de offererCNPJ na tabela
				stmt.setInt(7, CNPJ);
				
				stmt.executeUpdate();
				System.out.println("Salvo com sucesso");
				
			}catch (SQLException e) {
				System.out.println("Erro ao salvar. " +e);
				
			} finally {
				ConnectionFactory.closeConnection(con, stmt);
				
			}
			
		}
}
