package br.ufg.inf.alumniinf.persistence.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufg.inf.alumniinf.persistence.connection.ConnectionFactory;
import br.ufg.inf.alumniinf.persistence.model.bean.AlumnusUser;
import br.ufg.inf.alumniinf.persistence.model.bean.ExternalUser;

public class UserDAO {

	// Cria um usuário no BD.
	// Se e o usuário criado não é do tipo externo.
	public void create(AlumnusUser user){
		
		
		Connection        con  = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet         rs   = null;

		try {
			stmt = con.prepareStatement("INSERT INTO User (fullName, userName, userPassword, userType, tellphone, email)"
					                             + "VALUES(?,        ?,        ?,            ?,        ?,         ?    )");
		
			
			stmt.setString(1, user.getFullName());
			stmt.setString(2, user.getUserName().toString());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, "alumnus");
			stmt.setString(5, user.getTellphone());			
			stmt.setString(6, user.getEmail());
			
			stmt.executeUpdate();
			
			System.out.println("Salvo com sucesso em User");
			
		}catch (SQLException e) {
			System.out.println("Erro ao salvar em User. " +e);
			
		} 
		
		
		// Select para recuperar o id da usuário que acaba de ser inserido
		try {			
			stmt = con.prepareStatement("SELECT idUser FROM User WHERE userName = ?");
			stmt.setString(1, user.getUserName());
			
			rs   = stmt.executeQuery();
			
			if(rs.next()) System.out.println("ID do ex-aluno sendo cadastrado: " +rs.getInt("idUser"));
			else 		  System.out.println("Nenhum id recuperado");	

		} catch (SQLException e) {
			System.out.println("Erro ao recuperar id do usuário inserido: " +e);

		}
		
		
		try {
			stmt = con.prepareStatement("INSERT INTO Alumnus (idUser, birthDate, CPF, activeAcc, registration)"
                                                    + "VALUES(?,      ?,         ?,   ?,         ?           )");
			
			
			stmt.setInt    (1, rs.getInt("idUser"));
			stmt.setDate   (2, user.getBirthDate());
			stmt.setInt    (3, user.getCPF());
			stmt.setBoolean(4, true);
			stmt.setInt    (5, user.getRegistration());
			
			stmt.executeUpdate();
			
			System.out.println("Salvo com sucesso");
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir como Alumnus. " +e);

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
			
		}
		
		
	}
	
	// Cria um usuário no BD.
	public void create(ExternalUser user){
		
		Connection        con  = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet         rs   = null;

		try {
			stmt = con.prepareStatement("INSERT INTO User (fullName, userName, userPassword, userType, tellphone, email)"
												 + "VALUES(?,        ?,        ?,            ?,        ?,         ?    )");

			stmt.setString(1, user.getFullName());
			stmt.setString(2, user.getUserName().toString());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, "external");
			stmt.setString(5, user.getTellphone());			
			stmt.setString(6, user.getEmail());
			
			stmt.executeUpdate();
			
			System.out.println("Salvo com sucesso em User");
		
			
		}catch (SQLException e) {
			System.out.println("Erro ao salvar em User. " +e);
			
		}
		
		// Select para recuperar o id da usuário que acaba de ser inserido
		try {			
			stmt = con.prepareStatement("SELECT idUser FROM User WHERE userName = ?");
			stmt.setString(1, user.getUserName());
			
			rs   = stmt.executeQuery();
			
			if(rs.next()) System.out.println("ID do ex-aluno sendo cadastrado: " +rs.getInt("idUser"));
			else 		  System.out.println("Nenhum id recuperado");	

		} catch (SQLException e) {
			System.out.println("Erro ao recuperar id do usuário inserido: " +e);

		}
		
		try {
			stmt = con.prepareStatement("INSERT INTO External (idUser, CPF, CNPJ, razaoSocial, nameRepresentedCo)"
                                                     + "VALUES(?,      ?,   ?,    ?,           ?                )");
			
			stmt.setInt    (1, rs.getInt("idUser"));
			stmt.setInt    (2, user.getCPF());
			stmt.setInt	   (3, user.getCNPJ());
			stmt.setString (4, user.getRazaoSocial());
			stmt.setString (5, user.getRepresentedCompany());
			
			stmt.executeUpdate();
			
			System.out.println("Salvo com sucesso");
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir como Alumnus. " +e);

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
			
		}
		
	}
	
	
	public String loginUser(String userName, String userPass){
		
		Connection        con  = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet         rs   = null;
		
		try {
			stmt = con.prepareStatement("SELECT idUser, fullName, email, tellphone, userType "
					                   +"FROM User "
					                   +"WHERE userName = ? AND userPassword = ?");
			
			stmt.setString(1, userName);
			stmt.setString(2, userPass);
			
			rs = stmt.executeQuery();
			rs.next();	
		
			return rs.getString("userType");
			
			
				
		} catch (SQLException e) {
			System.out.println("Falha na execução da query Login User. " +e);
			return null;
			
		}
		
		
	}
	
	// Retornar para a classe Login o usuário alumnus logado (ISSO NÃO ARMAZENA UM NOVO USUÁRIO E SENHA NO BD)
	public static AlumnusUser loginAlumnusUser(String userName, String userPass){
		
		System.out.println("\n----------Alumnus LOGADO----------");
		
		Connection        con  = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet         rs   = null;
		
		try {
			stmt = con.prepareStatement("SELECT fullName, CPF, email, tellphone "
					                   +"FROM User, Alumnus "
					                   +"WHERE userName = ? AND userPassword = ?");
			
			stmt.setString(1, userName);
			stmt.setString(2, userPass);
			
			rs = stmt.executeQuery();
			rs.next();	
		
			AlumnusUser user = new AlumnusUser(userName, rs.getString("fullName"), rs.getInt("CPF"), rs.getString("email"), rs.getString("tellphone"));
			
			return user;
			
			
				
		} catch (SQLException e) {
			System.out.println("Falha na execução da query Login User. " +e);
			return null;
			
		}

	}
	
	
	// Vou retornar para a classe Login o usuário externo logado (ISSO NÃO ARMAZENA UM NOVO USUÁRIO E SENHA NO BD)
	public static ExternalUser loginExternalUser(String userName, String userPass){
		
		System.out.println("\n----------External LOGADO----------");
			
		Connection        con  = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet         rs   = null;
		
		try {
			stmt = con.prepareStatement("SELECT fullName, CNPJ, razaoSocial, nameRepresentedCo "
					                   +"FROM User, External "
					                   +"WHERE userName = ? AND userPassword = ?");
			
			stmt.setString(1, userName);
			stmt.setString(2, userPass);
			
			rs = stmt.executeQuery();
			rs.next();	
		
			ExternalUser user = new ExternalUser(userName, rs.getString("fullName"), rs.getInt("CNPJ"), rs.getString("razaoSocial"), rs.getString("nameRepresentedCo"));
			
			return user;
			
			
		} catch (SQLException e) {
			System.out.println("Falha na execução da query Login User. " +e);
			return null;
			
		}
		
	}
	
	
	public ExternalUser getExternalUser(String userName, String userPass){
		
		Connection        con  = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet         rs   = null;

		//TODO - ALTERAR ESTE SELECT
		try {
			stmt = con.prepareStatement("SELECT User.idUser, fullName, razaoSocial, CPF, CNPJ, email, tellphone, nameRepresentedCo "
									   +"FROM User, External "
									   +"WHERE userName = ? AND userPassword = ?");
			
			stmt.setString(1, userName);
			stmt.setString(2, userPass);
			
			rs = stmt.executeQuery();
			
			
			//Retorna false se não há rows armazenadas.
			if(rs.next()){
				System.out.println("\n----------- Usuário Externo Encontrado -----------");
				ExternalUser user = new ExternalUser(rs.getString("fullname"), rs.getString("razaoSocial"), rs.getInt("CPF"), rs.getInt("CNPJ"),
                                                     rs.getString("email"),    rs.getString("tellphone"),   rs.getString("nameRepresentedCo"));
				
				user.setID(rs.getInt("idUser"));
				
				return user;
				
			}else{
				System.out.println("\n------- Falha na Procura de Usuário Externo-------");
				return null;
				
			}
			
		} catch (SQLException e) {
			System.out.println("Falha na execução da query. " +e);
			return null;
			
		}

	}
	
	
}
