package br.ufg.inf.alumniinf.negocio.autenticacao;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.io.Console;
import java.io.File;

import br.ufg.inf.alumniinf.utils.ReaderCSV;

public class Login {

	static Scanner scanner = new Scanner(System.in);
	static Console console = System.console();
	
	private static File registerRecord = new File("cadastro/registroCadastros.csv");
	
	public static Boolean realizeLogin(){
		
		ReaderCSV reader = new ReaderCSV(registerRecord);
		//Lendo da linha 1 até a última linha no csv (quantidade de cadastros)
		List<String[]> registerDataList = reader.getLines().subList(0, Register.registerQuantity);
		
		System.out.print("Usuário: ");
		String user = "Lucas FelipL87";
		//String user = scanner.nextLine();
		
		System.out.print("Senha: ");
		String pass = "WhQjq_p+Nl";
		//String pass = scanner.nextLine();

		scanner.close();
		
		int currentLine = 0;
		
		for (Iterator<String[]> iterator = registerDataList.iterator(); iterator.hasNext();) {
			String[] currentUser = reader.getLines().get(currentLine);
			
			System.out.print("\nRegistro atual: " +currentUser[0] + " - " +currentUser[1]);
			
			if(currentUser[0].equals(user) && currentUser[1].equals(pass)) return true;
		
			currentLine++;
			
		}
		
		return false;
		
	}
	
}
