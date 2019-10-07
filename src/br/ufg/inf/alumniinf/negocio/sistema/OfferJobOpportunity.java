package br.ufg.inf.alumniinf.negocio.sistema;

//import java.util.Scanner;

public class OfferJobOpportunity {

	//private static Scanner scanner;
	
	public static void main() {
		
		//scanner = new Scanner(System.in);
		
		//System.out.print("Titulo Descritivo: ");
		String titulo = "Desenvolvedor Java";//scanner.nextLine();

		//System.out.print("Cidade de Atuação: ");
		String cidade = "Goiânia"; //scanner.nextLine();

		//System.out.print("Formação necessária (Opicional - Enter): ");
		String formacao = "Graduação em Engenharia de Software, Ciência da Computação, ou Sistemas de Informação";//scanner.nextLine();
		if(formacao == "\n") formacao = null;
			
		//System.out.print("Habilidades desejáveis: ");
		String habilidades = "Java e Pacote office";//scanner.nextLine();
		
		
		//System.out.print("Salario Mínimo (Opicional - Enter): ");
		String valMin = "1000.0"; //scanner.nextLine();
		double salMin;
		
		if(valMin == "\n") salMin = 0;
		else			   salMin = Double.valueOf(valMin);
		
		
		//System.out.print("Salario Máximo (Opicional - Enter): ");
		String valMax = "2000.0"; //scanner.nextLine();
		double salMax;
		
		if(valMax == "\n") salMax = 0;
		else			   salMax = Double.valueOf(valMax);
		
		
		JobOpportunity oportunidade = new JobOpportunity(titulo, cidade, formacao, habilidades, salMin, salMax);
		
		System.out.println("Oportunidade de emprego cadastrada: "   +oportunidade.getTituloDescritivo() + "\n"
																	+oportunidade.getCidadeAtuacao() + "\n"
																	+oportunidade.getFormacaoAcademica()+ "\n"
																	+oportunidade.getHabilidades() + "\n"
																	+oportunidade.getFaixaSalarial());
		
	}
	

}

