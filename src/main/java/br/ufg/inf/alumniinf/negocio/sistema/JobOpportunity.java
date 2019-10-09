package br.ufg.inf.alumniinf.negocio.sistema;


public class JobOpportunity {

	private String descriptiveTitle;
	private String actingCity;
	private String academicFormation;
	private String skils;
	private String salaryRange;
	
	
	public JobOpportunity(String title,  String city,     String formation, 
						  String skils,  double minSalary,  double maxSalary) {
		
		this.descriptiveTitle = title;
		this.actingCity = city;
		this.academicFormation = formation;
		this.skils = skils;
		this.salaryRange = "R$" +String.valueOf(minSalary) + " ~ R$" + String.valueOf(maxSalary);
		
	}

	
	public String getDescriptiveTitle() {
		return descriptiveTitle;
		
	}
	
	public void setDescriptiveTitle(String title) {
		this.descriptiveTitle = title;
		
	}
	
	public String getActingCity() {
		return actingCity;
		
	}
	
	public void setActingCity(String city) {
		this.actingCity = city;
		
	}
	
	public String getAcademicFormation() {
		return academicFormation;
		
	}
	
	public void setAcademicFormation(String formation) {
		this.academicFormation = formation;
		
	}
	
	public String getSkils() {
		return skils;
		
	}
	
	public void setSkils(String skils) {
		this.skils = skils;
		
	}

	public String getSalaryRange() {
		return salaryRange;
		
	}
}
