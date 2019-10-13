package br.ufg.inf.alumniinf.persistence.model.bean;


public class ExternalUser extends User{

	private String razaoSocial;
	private int CNPJ;
	
	
	/*------------------------------------------------CONSTRUTOR-----------------------------------------------*/
	public ExternalUser(String fullName, String razao, int numCPF, int numCNPJ, String email, String tellphone) {
		super(fullName, numCPF, email, tellphone, true); //10: tamanho da senha
		
		this.razaoSocial = razao;
		this.CNPJ      	 = numCNPJ;
		
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
	/*--------------------------------------------GETTERS E SETTERS--------------------------------------------*/

		
}
