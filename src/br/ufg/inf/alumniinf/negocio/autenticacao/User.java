package br.ufg.inf.alumniinf.negocio.autenticacao;

import java.io.File;

import br.ufg.inf.alumniinf.negocio.sistema.AlumniINFSystem;
import br.ufg.inf.alumniinf.utils.WriterCSV;

public class User {

	private String fullName;
	private String userName;
	private String password;
	
	private File passwordRecord = new File("cadastro/registroCadastros.csv");
	
	public User(String fullName, int passwordSize) {
		this.fullName = fullName;
		
		this.userName  = AlumniINFSystem.generateUsername(fullName);
		this.password  = AlumniINFSystem.generatePassword(passwordSize);
		
		String record[] = {this.userName, this.password};
		
		WriterCSV.Writer(passwordRecord, record);
		
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	
}
