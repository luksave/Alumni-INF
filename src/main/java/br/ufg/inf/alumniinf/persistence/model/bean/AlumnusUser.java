package br.ufg.inf.alumniinf.persistence.model.bean;

import java.util.Date;

public class AlumnusUser extends User{

	private int     registration;
	private Date    birthDate; //Importar de .sql dá diferença?
	private boolean active = false; //Padrão: ex-aluno não ter conta
	
	public AlumnusUser(String fullName,  int    CPF,  String email, 
			           String tellphone, String type, int    registration, 
			           Date   birthDate) {
		
		super(fullName, CPF, email, tellphone, type);

		this.registration = registration;
		this.birthDate    = birthDate;
		this.active       = true;
		
	}

	public int getRegistration() {
		return registration;
	}

	public void setRegistration(int registration) {
		this.registration = registration;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
