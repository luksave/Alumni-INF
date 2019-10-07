package br.ufg.inf.alumniinf.negocio.autenticacao;


public class ExternalUser extends User{

	private int numeroCPF;
	private int numeroCNPJ;
	private String numeroTelefone;
	
	public ExternalUser(String fullName, int CPF, int CNPJ, String telefone) {
		//10: tamanho da senha
		super(fullName, 10);
		
		this.numeroCNPJ     = CNPJ;
		this.numeroCPF      = CPF;
		this.numeroTelefone = telefone;
		
	}
	
	
	public int getNumeroCPF() {
		return numeroCPF;
	}

	public void setNumeroCPF(int numeroCPF) {
		this.numeroCPF = numeroCPF;
	}

	public int getNumeroCNPJ() {
		return numeroCNPJ;
	}

	public void setNumeroCNPJ(int numeroCNPJ) {
		this.numeroCNPJ = numeroCNPJ;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	
	
}
