package br.ufg.inf.alumniinf.utils.model.bean;

public class JobOpportunity {
	private String descriptiveTitle;
	private String actingCity;
	private String academicFormation;
	private String skils;
	private double minSalary;
	private double maxSalary;
	private String salaryRange;
	
	public JobOpportunity(String title,  String city,      String formation, 
			  			  String skils,  double minSalary, double maxSalary) {

		this.descriptiveTitle  = title;
		this.actingCity        = city;
		this.academicFormation = formation;
		this.skils             = skils;
		this.salaryRange       = "R$" +String.valueOf(minSalary) 
				            + " ~ R$" +String.valueOf(maxSalary);
		
	}

	/*--------------------------------GETTERS E SETTERS--------------------------------*/
	
	/*--------------------------------Título Descritivo--------------------------------*/
	public String getDescriptiveTitle() {
		return descriptiveTitle;
	}
	public void setDescriptiveTitle(String descriptiveTitle) {
		this.descriptiveTitle = descriptiveTitle;
	}
	
	/*--------------------------------Cidade de Atuação--------------------------------*/
	public String getActingCity() {
		return actingCity;
	}
	public void setActingCity(String actingCity) {
		this.actingCity = actingCity;
	}
	
	/*--------------------------------Formação Acadêmica--------------------------------*/
	public String getAcademicFormation() {
		return academicFormation;
	}
	public void setAcademicFormation(String academicFormation) {
		this.academicFormation = academicFormation;
	}
	
	/*------------------------------------Habilidades-----------------------------------*/
	public String getSkils() {
		return skils;
	}
	public void setSkils(String skils) {
		this.skils = skils;
	}
	
	/*-----------------------------------Salário Mínimo---------------------------------*/
	public double getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(double minSalary) {
		this.minSalary = minSalary;
	}
	
	/*-----------------------------------Salário Máximo---------------------------------*/
	public double getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(double maxSalary) {
		this.maxSalary = maxSalary;
	}
	/*----------------------------------Faixa de Salário--------------------------------*/
	public String getSalaryRange() {
		return salaryRange;
	}
	public void setSalaryRange(String salaryRange) {
		this.salaryRange = salaryRange;
	}
	/*--------------------------------GETTERS E SETTERS--------------------------------*/
	
}
