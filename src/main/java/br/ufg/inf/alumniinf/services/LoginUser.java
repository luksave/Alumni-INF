package br.ufg.inf.alumniinf.services;

import br.ufg.inf.alumniinf.persistence.model.UserDAO;
import br.ufg.inf.alumniinf.persistence.model.bean.User;

public class LoginUser {

	public static User main(String userName, String userPass) {
		
		UserDAO daoUser = new UserDAO();
		
		User user = daoUser.loginExternalUser(userName, userPass);

		System.out.println("Usuário cadastrado: \n" + user.getUserName() + " - "
													+ user.getPassword());
		
		return user;
		
	}
	
}
