package br.ufg.inf.alumniinf.negocio.autenticacao;


public class ExternalUser extends User{

	private int CPF;
	private int CNPJ;
	private String email;
	private String tellphone;
	
	public ExternalUser(String fullName, int CPF, int CNPJ, String email, String tellphone) {
		//10: tamanho da senha
		super(fullName, 10);
		
		this.CNPJ      = CNPJ;
		this.CPF       = CPF;
		this.email 	   = email;
		this.tellphone = tellphone;
		
	}
	
	
	public int getCPF() {
		return CPF;
		
	}

	public void setCPF(int CPF) {
		this.CPF = CPF;
		
	}

	public int getCNPJ() {
		return CNPJ;
		
	}

	public void setCNPJ(int CNPJ) {
		this.CNPJ = CNPJ;
		
	}

	public String getEmail() {
		return email;
		
	}

	public void setEmail(String email) {
		this.email = email;
		
	}


	public String getTellphone() {
		return tellphone;
		
	}

	public void setTellphone(String tellphone) {
		this.tellphone = tellphone;
		
	}

	
	
}
