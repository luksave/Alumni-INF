package br.ufg.inf.alumniinf.services;

import br.ufg.inf.alumniinf.persistence.model.UserDAO;
import br.ufg.inf.alumniinf.persistence.model.bean.AlumnusUser;
import br.ufg.inf.alumniinf.persistence.model.bean.ExternalUser;

public class LoginUser {
	
	public static String login(String userName, String userPass) {
		
		UserDAO daoUser = new UserDAO();
		
		String type = daoUser.loginUser(userName, userPass);
		
		return type;
				
	}
	
	
	public static AlumnusUser loginAlumnus(String userName, String userPass){
		return UserDAO.loginAlumnusUser(userName, userPass);
		
	}
	
	public static ExternalUser loginExternal(String userName, String userPass){
		return UserDAO.loginExternalUser(userName, userPass);
		
	}
	
}
