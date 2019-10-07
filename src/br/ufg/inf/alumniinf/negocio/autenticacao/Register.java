package br.ufg.inf.alumniinf.negocio.autenticacao;

//import java.util.Scanner;

public class Register {

	//private static Scanner scanner;
	public  static int quantidadeCadastros = 0;
	
	public static void main() {
		
		//scanner = new Scanner(System.in);
		
		//System.out.print("Nome Completo: ");
		String nomeCompleto = "Lucas Felipe"; //scanner.nextLine();
		
		//System.out.print("CPF: ");
		int CPF = 219389384; //scanner.nextInt();
		
		//System.out.print("CNPJ: ");
		int CNPJ = 910291142; //scanner.nextInt();

		//System.out.print("Telefone: ");
		String telefone = "01290494029"; //scanner.nextLine();
		
		//scanner.close();
		
		ExternalUser usuario = new ExternalUser(nomeCompleto, CPF, CNPJ, telefone);
		
		System.out.println("User cadastrado: " +usuario.getNomeCompleto() + " - " 
											   +usuario.getNumeroCPF() + " - "
											   +usuario.getNumeroCNPJ() + " - "
											   +usuario.getNumeroTelefone() + ".");
		
		quantidadeCadastros++;
		
	}
	
}
