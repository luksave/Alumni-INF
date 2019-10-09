package br.ufg.inf.alumniinf.utils.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

	// Classe localizada no driver da jdbc
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL    = "jdbc:mysql://localhost:3306/dbAlumniINF";
	private static final String USER   = "root";
	private static final String PASS   = "22101996";
	
	
	public static Connection getConnection(){
		
		try{
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);
			
		}catch (ClassNotFoundException | SQLException ex) {
			throw new RuntimeException("Erro na conexão");
			
		}
		
	}
	
	
	// Sempre que uma conexão acaba, ela precisa ser finalizada
	public static void closeConnection(Connection con){
		
		if(con != null)
			try {
				con.close();
				
			} catch (SQLException e) {
				Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
				
			}
		
	}
	
	// Sempre que uma conexão acaba, ela precisa ser finalizada
	public static void closeConnection(Connection con, PreparedStatement stmt){
		
		closeConnection(con);
		
		try {
			if(stmt != null) stmt.close();
			
		} catch (SQLException e) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
			
		}
		
	}

	
	// Sempre que uma conexão acaba, ela precisa ser finalizada
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
		
		closeConnection(con, stmt);
		
		try {
			if(rs != null) rs.close();
			
		} catch (SQLException e) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
			
		}
		
	}
	
}
