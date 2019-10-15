package br.ufg.inf.alumniinf.persistence.model.bean;

import br.ufg.inf.alumniinf.services.AlumniINFSystem;

public class User {
	private String fullName;
	private String userName;
	private String password;
	private int    numCPF;
	private String email;
	private String tellphone;
	private String type;
	
	
	/*-----------------------------------CONSTRUTORES----------------------------------*/
	public User(String fullName, int CPF, String email, String tellphone, String type) {
		this.fullName  = fullName;
		this.numCPF	   = CPF;
		this.email     = email;
		this.tellphone = tellphone;
		this.type      = type;
		this.userName  = AlumniINFSystem.generateUsername(fullName);
		this.password  = AlumniINFSystem.generatePassword(10); //10: tamanho da senha
		
	}
	
	public User(String user, String fullName, String type) {
		this.userName  = user;
		this.fullName  = fullName;
		this.type      = type;
		
	}
	
	/*------------------------------------CONSTRUTOR-----------------------------------*/
	
	
	/*--------------------------------GETTERS E SETTERS--------------------------------*/
	
	/*----------------------------------Nome Completo----------------------------------*/
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	/*---------------------------------Nome de Usuário---------------------------------*/
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/*--------------------------------------Senha--------------------------------------*/
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/*---------------------------------------CPF---------------------------------------*/
	public int getCPF() {
		return numCPF;
	}
	public void setCPF(int cPF) {
		numCPF = cPF;
	}
	
	/*----------------------------------TIPO-de-USER------------------------------------*/
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	/*--------------------------------------E-mail-------------------------------------*/
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	/*-------------------------------------Telefone------------------------------------*/
	public String getTellphone() {
		return tellphone;
	}
	public void setTellphone(String tellphone) {
		this.tellphone = tellphone;
	}
	/*--------------------------------GETTERS E SETTERS--------------------------------*/
}
