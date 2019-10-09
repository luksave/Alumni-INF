package br.ufg.inf.alumniinf.negocio.autenticacao;

//import java.util.Scanner;

public class Register {

	//private static Scanner scanner;
	public  static int registerQuantity = 0;
	
	public static void main() {
		
		//scanner = new Scanner(System.in);
		
		//System.out.print("Nome Completo: ");
		String fullName = "Lucas Felipe"; //scanner.nextLine();
		
		//System.out.print("CPF: ");
		int CPF = 219389384; //scanner.nextInt();
		
		//System.out.print("CNPJ: ");
		int CNPJ = 910291142; //scanner.nextInt();
		
		//System.out.print("E-mail: ");
		String email = "lucasfelipems@gmail.com"; //scanner.nextLine();
				
		//System.out.print("Telefone: ");
		String tellphone = "01290494029"; //scanner.nextLine();
		
		//scanner.close();
		
		ExternalUser user = new ExternalUser(fullName, CPF, CNPJ, email, tellphone);
		
		System.out.println("Usuário cadastrado: " +user.getFullName() +  " - " 
											      +user.getCPF() +     " - "
											      +user.getCNPJ() +    " - "
											      +user.getEmail() +         " - "
											      +user.getTellphone() + ".");
		
		registerQuantity++;
		
	}
	
}
