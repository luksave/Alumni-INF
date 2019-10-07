package br.ufg.inf.alumniinf.negocio.sistema;


public class JobOpportunity {

	private String tituloDescritivo;
	private String cidadeAtuacao;
	private String formacaoAcademica;
	private String habilidades;
	
	private double salarioMin;
	private double salarioMax;
	private String faixaSalarial = String.valueOf(salarioMin) + String.valueOf(salarioMax);
	
	
	public JobOpportunity(String tituloDescritivo,  String cidadeAtuacao,
			              String formacaoAcademica, String habilidades, 
			              double salarioMin,        double salarioMax) {
		
		this.tituloDescritivo = tituloDescritivo;
		this.cidadeAtuacao = cidadeAtuacao;
		this.formacaoAcademica = formacaoAcademica;
		this.habilidades = habilidades;
		this.salarioMin = salarioMin;
		this.salarioMax = salarioMax;
		
	}

	
	public String getTituloDescritivo() {
		return tituloDescritivo;
		
	}
	
	public void setTituloDescritivo(String tituloDescritivo) {
		this.tituloDescritivo = tituloDescritivo;
		
	}
	
	public String getCidadeAtuacao() {
		return cidadeAtuacao;
		
	}
	
	public void setCidadeAtuacao(String cidadeAtuacao) {
		this.cidadeAtuacao = cidadeAtuacao;
		
	}
	
	public String getFormacaoAcademica() {
		return formacaoAcademica;
		
	}
	
	public void setFormacaoAcademica(String formacaoAcademica) {
		this.formacaoAcademica = formacaoAcademica;
		
	}
	
	public String getHabilidades() {
		return habilidades;
		
	}
	
	public void setHabilidades(String habilidades) {
		this.habilidades = habilidades;
		
	}
	
	public double getSalarioMin() {
		return salarioMin;
		
	}
	
	public void setSalarioMin(double salarioMin) {
		this.salarioMin = salarioMin;
		
	}
	public double getSalarioMax() {
		return salarioMax;
		
	}
	public void setSalarioMax(double salarioMax) {
		this.salarioMax = salarioMax;
		
	}

	public String getFaixaSalarial() {
		return faixaSalarial;
		
	}
}
