package br.ufg.inf.alumniinf.persistence.model.bean;


public class ExternalUser extends User{

	private int    ID;
	private int    CNPJ;
	private String razaoSocial;
	private String representedCompany;
	
	/*-----------------------------------------------CONSTRUTORES----------------------------------------------*/
	public ExternalUser(String fullName, String razao, int numCPF, int numCNPJ, String email, String tellphone, String represented) {
		super(fullName, numCPF, email, tellphone, "external"); 
		
		this.razaoSocial        = razao;
		this.representedCompany = represented;
		this.CNPJ      	        = numCNPJ;
		
	}
	public ExternalUser(String user, String fullName, int numCNPJ, String razao, String represented) {
		super(user, fullName, "external");
		
		this.CNPJ = numCNPJ;
		this.razaoSocial = razao;
		this.representedCompany = represented;
		
	}
	
	/*------------------------------------------------CONSTRUTOR-----------------------------------------------*/
	
	
	/*--------------------------------------------GETTERS E SETTERS--------------------------------------------*/
	
	/*-----------------------------------------------Razão Social----------------------------------------------*/
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	/*---------------------------------------------------CNPJ--------------------------------------------------*/
	public int getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(int CNPJ) {
		this.CNPJ = CNPJ;
	}

	/*----------------------------------------------------ID---------------------------------------------------*/
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		this.ID = iD;
	}
	
	/*--------------------------------------------Represented Company-------------------------------------------*/
	public String getRepresentedCompany() {
		return representedCompany;
	}
	public void setRepresentedCompany(String representedCompany) {
		this.representedCompany = representedCompany;
	}
	/*--------------------------------------------GETTERS E SETTERS--------------------------------------------*/
		
}
