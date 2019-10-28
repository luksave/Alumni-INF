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
		
		//Abrir conexão
		Connection con = ConnectionFactory.getConnection();
		
		//Prepara a requisição ao mysql
		PreparedStatement stmt = null;
		
		// TODO - ALTERAR ESTE INSERT DE ACORDO COM O NOVO BD
		try {
			// Se ex é false, o usuário não precisa do campo CNPJ e razo?
			stmt = con.prepareStatement("INSERT INTO user (fullName, userName, password, external, razao, CPF, CNPJ, email, telefone)"
					                             + "VALUES(?,        ?,        ?,        ?,        NULL,  ?,   NULL,    ?,     ?    )");
		
			// Define o valor de FullName na tabela
			stmt.setString(1, user.getFullName());
			
			// Define o valor de UserName na tabela
			stmt.setString(2, user.getUserName());
			
			// Define o valor de Password na tabela	
			stmt.setString(3, user.getPassword());
			
			// Define o valor de extenal na tabela	
			stmt.setBoolean(4, false);
			
			// Define o valor de CPF na tabela	
			stmt.setInt(6, user.getCPF());
			
			// Define o valor de Email na tabela
			stmt.setString(8, user.getEmail());
			
			// Define o valor de Tellphone na tabela
			stmt.setString(9, user.getTellphone());
			
			
			stmt.executeUpdate();
			System.out.println("Salvo com sucesso");
			
		}catch (SQLException e) {
			System.out.println("Erro ao salvar. " +e);
			
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
			
		}
		
	}
	
	// Cria um usuário no BD.
	public void create(ExternalUser user){
		
		//Abrir conexão
		Connection con = ConnectionFactory.getConnection();
		
		//Prepara a requisição ao mysql
		PreparedStatement stmt = null;
		
		// TODO - ALTERAR ESTE INSERT DE ACORDO COM O NOVO BD
		try {
			stmt = con.prepareStatement("INSERT INTO user (fullName, userName, password, external, razaoSocial, CPF, CNPJ, email, tellphone)"
												 + "VALUES(?,        ?,        ?,        ?,        ?,           ?,   ?,    ?,     ?        )");
			// Define o valor de FullName na tabela
			stmt.setString(1, user.getFullName());
			
			// Define o valor de UserName na tabela
			stmt.setString(2, user.getUserName());
			
			// Define o valor de Password na tabela	
			stmt.setString(3, user.getPassword());
			
			// Define o valor de extenal na tabela	
			stmt.setBoolean(4, true);
			
			// Define o valor de razao na tabela
			stmt.setString(5, user.getRazaoSocial());
			
			// Define o valor de CPF na tabela	
			stmt.setInt(6, user.getCPF());
			
			// Define o valor de CNPJ na tabela
			stmt.setInt(7, user.getCNPJ());
			
			// Define o valor de Email na tabela
			stmt.setString(8, user.getEmail());
			
			// Define o valor de Tellphone na tabela
			stmt.setString(9, user.getTellphone());
				
			
			stmt.executeUpdate();
			System.out.println("Salvo com sucesso");
			
			
		}catch (SQLException e) {
			System.out.println("Erro ao salvar. " +e);
			
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
			
		}
		
	}
	
	
	// Vou retornar para a classe Login o usuário externo logado (ISSO NÃO ARMAZENA UM NOVO USUÁRIO E SENHA NO BD)
	public AlumnusUser loginAlumnusUser(String userName, String userPass){
		
		Connection        con  = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet         rs   = null;

		try {
			stmt = con.prepareStatement("SELECT fullName, CPF, email, tellphone, type, registration, birthDate "
					                   +"FROM User, Alumnus "
					                   +"WHERE User.userName = " +userName+ " AND User.userPassword = " +userPass);
			rs = stmt.executeQuery();
			
			
			//Retorna false se não há rows armazenadas.
			if(rs.next()){
				System.out.println("\n----------- LOGADO -----------");
				AlumnusUser user = new AlumnusUser(rs.getString("fullName"),  rs.getInt("CPF"),     rs.getString("email"),
						                           rs.getString("tellphone"), rs.getString("type"), rs.getInt("registration"),
						                           rs.getDate("birthDate"));
				
				return user;
				
			}else{
				System.out.println("\n------- Falha no Login -------");
				return null;
				
			}
			
		} catch (SQLException e) {
			System.out.println("Falha na execução da query. " +e);
			return null;
			
		}

	}
	
	
	// Vou retornar para a classe Login o usuário externo logado (ISSO NÃO ARMAZENA UM NOVO USUÁRIO E SENHA NO BD)
	public ExternalUser loginExternalUser(String userName, String userPass){
		
		Connection        con  = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet         rs   = null;

		//TODO - ALTERAR ESTE INSERT
		try {
			stmt = con.prepareStatement("SELECT idUser, fullName, razaoSocial, CPF, CNPJ, email, tellphone "
									   +"FROM User, Alumnus "
									   +"WHERE User.userName = " +userName+ " AND User.password = " +userPass);
			rs = stmt.executeQuery();
			
			
			//Retorna false se não há rows armazenadas.
			if(rs.next()){
				System.out.println("\n----------- LOGADO -----------");
				ExternalUser user = new ExternalUser(rs.getString("fullname"), rs.getString("razaoSocial"), rs.getInt("CPF"), 
						                             rs.getInt("CNPJ"),        rs.getString("email"),       rs.getString("tellphone"));
				
				user.setID(rs.getInt("idUser"));
				
				return user;
				
			}else{
				System.out.println("\n------- Falha no Login -------");
				return null;
				
			}
			
		} catch (SQLException e) {
			System.out.println("Falha na execução da query. " +e);
			return null;
			
		}

	}
	
	
	public ExternalUser getExternalUser(String userName, String userPass){
		
		Connection        con  = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet         rs   = null;

		//TODO - ALTERAR ESTE INSERT
		try {
			stmt = con.prepareStatement("SELECT idUser, fullName, razaoSocial, CPF, CNPJ, email, tellphone "
					                   +"FROM User, Alumnus "
					                   +"WHERE User.userName = " +userName+ " AND User.password = " +userPass);
			rs = stmt.executeQuery();
			
			
			//Retorna false se não há rows armazenadas.
			if(rs.next()){
				System.out.println("\n----------- Usuário Externo Encontrado -----------");
				ExternalUser user = new ExternalUser(rs.getString("fullname"), rs.getString("razaoSocial"), rs.getInt("CPF"), 
						                             rs.getInt("CNPJ"),   rs.getString("email"),    rs.getString("tellphone"));
				
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
