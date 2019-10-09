package br.ufg.inf.alumniinf.negocio.sistema;

//import java.util.Scanner;

public class OfferJobOpportunity {

	//private static Scanner scanner;
	
	public static void main() {
		
		//scanner = new Scanner(System.in);
		
		//System.out.print("Titulo Descritivo: ");
		String title = "Desenvolvedor Java";//scanner.nextLine();

		//System.out.print("Cidade de Atuação: ");
		String city = "Goiânia"; //scanner.nextLine();

		//System.out.print("Formação necessária (Opicional - Enter): ");
		String formation = "Graduação em Engenharia de Software, Ciência da Computação, ou Sistemas de Informação";//scanner.nextLine();
		if(formation == "\n") formation = null;
			
		//System.out.print("Habilidades desejáveis: ");
		String skils = "Java e Pacote office";//scanner.nextLine();
		
		
		//System.out.print("Salario Mínimo (Opicional - Enter): ");
		String minVal = "1000.0"; //scanner.nextLine();
		double minSal;
		
		if(minVal == "\n") minSal = 0;
		else			   minSal = Double.valueOf(minVal);
		
		
		//System.out.print("Salario Máximo (Opicional - Enter): ");
		String maxVal = "2000.0"; //scanner.nextLine();
		double maxSal;
		
		if(maxVal == "\n") maxSal = 0;
		else			   maxSal = Double.valueOf(maxVal);
		
		
		JobOpportunity oportunidade = new JobOpportunity(title, city, formation, skils, minSal, maxSal);
		
		System.out.println("Oportunidade de emprego cadastrada: \n" +oportunidade.getDescriptiveTitle() + " - "
																	+oportunidade.getActingCity()       + "\nFormação exigida: "
																	+oportunidade.getAcademicFormation()+ "\nHabilidades necessárias: "
																	+oportunidade.getSkils()            + "\nFaixa salarial: "
																	+oportunidade.getSalaryRange());
		
	}
	

}

